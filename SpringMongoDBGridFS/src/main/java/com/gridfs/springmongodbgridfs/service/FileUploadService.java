package com.gridfs.springmongodbgridfs.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final GridFsTemplate gridFsTemplate;

    public void uploadFile(MultipartFile multipartFile) {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("fileName",multipartFile.getName());
        dbObject.put("contentType",multipartFile.getContentType());
        dbObject.put("size",multipartFile.getSize());
        dbObject.put("userId","001");

        try {
            Object id = gridFsTemplate.store(multipartFile.getInputStream(),multipartFile.getName(),dbObject);
            System.out.println(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
