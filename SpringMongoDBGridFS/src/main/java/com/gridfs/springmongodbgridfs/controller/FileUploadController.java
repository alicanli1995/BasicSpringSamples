package com.gridfs.springmongodbgridfs.controller;

import com.gridfs.springmongodbgridfs.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping
    public void fileUpload(@RequestParam MultipartFile multipartFile){
        fileUploadService.uploadFile(multipartFile);
    }


}
