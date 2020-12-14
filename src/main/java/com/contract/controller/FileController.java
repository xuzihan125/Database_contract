package com.contract.controller;

import com.contract.mybatis.dto.FileDeleteDTO;
import com.contract.mybatis.dto.FileDownloadDTO;
import com.contract.mybatis.dto.FileUploadDTO;
import com.contract.mybatis.vo.ErrorVO;
import com.contract.service.FileService;
import com.contract.util.exception.ErrorCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/file")
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping(value="/download")
    public ErrorVO fileDownload(@RequestBody FileDownloadDTO fileDownloadDTO, @RequestHeader(value = "num") String opnum, HttpServletResponse response){
        fileService.fileDownload(fileDownloadDTO,opnum,response);
        return new ErrorVO(true,ErrorCode.SUCCESS.getName());
    }

    @RequestMapping(value="/upload")
    public ErrorVO fileUpload(@RequestBody FileUploadDTO fileUploadDTO, @RequestParam("file") MultipartFile file, @RequestHeader(value = "num") String opnum, HttpServletResponse response){
        fileService.fileUpload(fileUploadDTO,file,opnum);
        return new ErrorVO(true,ErrorCode.SUCCESS.getName());
    }

    @RequestMapping(value="/delete")
    public ErrorVO fileDelete(@RequestBody FileDeleteDTO fileDeleteDTO, @RequestHeader(value = "num") String opnum){
        fileService.fileDelete(fileDeleteDTO,opnum);
        return new ErrorVO(true,ErrorCode.SUCCESS.getName());
    }
}
