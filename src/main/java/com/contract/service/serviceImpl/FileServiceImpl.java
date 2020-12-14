package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.ContractAttachmentMapper;
import com.contract.mybatis.dto.FileDeleteDTO;
import com.contract.mybatis.dto.FileDownloadDTO;
import com.contract.mybatis.dto.FileUploadDTO;
import com.contract.mybatis.entity.ContractAttachment;
import com.contract.mybatis.entity.ContractAttachmentExample;
import com.contract.service.FileService;
import com.contract.util.emnu.EnumCamp;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import com.sun.net.ssl.internal.www.protocol.https.HttpsURLConnectionOldImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    private ContractAttachmentMapper contractAttachmentMapper;

    //文件下载
    @Override
    public void fileDownload(FileDownloadDTO fileDownloadDTO, String opnum, HttpServletResponse response){
        //参数效验
        if(StringTools.isEmpty(fileDownloadDTO.getConNum())) {
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
//        if(!right.selectAuthority(opnum, EnumCamp.Right.DOWNLOAD_FILE.getCode())) {
//            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
//        }
        //获得文件信息
        ContractAttachmentExample example = new ContractAttachmentExample();
        example.createCriteria().andConnumEqualTo(fileDownloadDTO.getConNum()).andFilenameEqualTo(fileDownloadDTO.getFileName());
        List<ContractAttachment> entityList = contractAttachmentMapper.selectByExample(example);
        if(entityList.size()==0) {
            throw new ActException(ErrorCode.MISSING_FILE.getCode(),ErrorCode.MISSING_FILE.getName());
        }
        ContractAttachment fileInfo = entityList.get(0);
        //读取文件
        String path;
        try{
            URL url= this.getClass().getClassLoader().getResource(fileInfo.getPath()+fileInfo.getFilename());
            path = url.getPath();
        }catch(Exception e){
            throw new ActException(ErrorCode.LOSS_FILE.getCode(),ErrorCode.LOSS_FILE.getName());
        }
        File file = new File(path);
        //建立连接
        //HttpServletResponse response;
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            //response = (HttpServletResponse)new URL(fileDownloadDTO.getUrl()).openConnection();
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileInfo.getFilename());
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }catch(Exception e){
            throw new ActException(ErrorCode.CONNECTION_ERROR.getCode(),ErrorCode.CONNECTION_ERROR.getName());
        }
        finally {
            if(bis!=null){
                try{
                    bis.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try{
                    fis.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void fileUpload(FileUploadDTO fileUploadDTO, MultipartFile transfile, String opnum){
        if(StringTools.isEmpty(fileUploadDTO.getConNum())) {
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
//        if(!right.selectAuthority(opnum, EnumCamp.Right.UPLOAD_FILE.getCode())) {
//            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
//        }

        String path = new File("file/"+fileUploadDTO.getConNum()).getAbsolutePath();
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        file = new File(path, fileUploadDTO.getFileName());
        if (file.exists()) {
            throw new ActException(ErrorCode.DUPLICATE_FILE.getCode(),ErrorCode.DUPLICATE_FILE.getName());
        }

        try {
            transfile.transferTo(file);
        } catch (IOException e) {
            throw new ActException(ErrorCode.CONNECTION_ERROR.getCode(),ErrorCode.CONNECTION_ERROR.getName());
        }

        ContractAttachment contractAttachment = new ContractAttachment();
        contractAttachment.setConnum(fileUploadDTO.getConNum());
        contractAttachment.setFilename(fileUploadDTO.getFileName());
        contractAttachment.setType(fileUploadDTO.getType());
        contractAttachment.setPath(path);
        contractAttachment.setUploadtime(new Date());
        contractAttachmentMapper.insert(contractAttachment);
    }

    @Override
    public void fileDelete(FileDeleteDTO fileDeleteDTO, String opnum){
        if(StringTools.isEmpty(fileDeleteDTO.getConNum())) {
            throw new ActException(ErrorCode.PARAM_ERROR.getCode(),ErrorCode.PARAM_ERROR.getName());
        }
//        if(!right.selectAuthority(opnum, EnumCamp.Right.DEL_FILE.getCode())) {
//            throw new ActException(ErrorCode.INVALID_OPERATION.getCode(),ErrorCode.INVALID_OPERATION.getName());
//        }

        //获得文件信息
        ContractAttachmentExample example = new ContractAttachmentExample();
        example.createCriteria().andConnumEqualTo(fileDeleteDTO.getConNum()).andFilenameEqualTo(fileDeleteDTO.getFileName());
        int num = contractAttachmentMapper.deleteByExample(example);
        if(num==0) {
            throw new ActException(ErrorCode.LOSS_FILE.getCode(),ErrorCode.LOSS_FILE.getName());
        }

        String path;
        try{
            URL url= this.getClass().getClassLoader().getResource("file/test.txt");
            path = url.getPath();
        }catch(Exception e){
            throw new ActException(ErrorCode.LOSS_FILE.getCode(),ErrorCode.LOSS_FILE.getName());
        }
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }

}
