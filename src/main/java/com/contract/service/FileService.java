package com.contract.service;

import com.contract.mybatis.dto.FileDeleteDTO;
import com.contract.mybatis.dto.FileDownloadDTO;
import com.contract.mybatis.dto.FileUploadDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
    void fileDownload(FileDownloadDTO fileDownloadDTO, String opnum, HttpServletResponse response);

    void fileUpload(FileUploadDTO fileUploadDTO, MultipartFile transfile, String opnum);

    void fileDelete(FileDeleteDTO fileDeleteDTO, String opnum);
}
