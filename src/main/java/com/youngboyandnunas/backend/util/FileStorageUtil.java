package com.youngboyandnunas.backend.util;


import com.youngboyandnunas.backend.global.infra.AwsS3UploadFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStorageUtil{

    private final UUID uuid;
    private final AwsS3UploadFacade awsS3UploadFacade;

    @Autowired
    public FileStorageUtil(AwsS3UploadFacade awsS3UploadFacade) {
        this.uuid = UUID.randomUUID();
        this.awsS3UploadFacade = awsS3UploadFacade;
    }

    public String store(MultipartFile multipartFile) {

        String newFileName = "";

        try {
            if (multipartFile.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }

            newFileName = uuid +"_"+ multipartFile.getOriginalFilename();
            File uploadFile = new File(newFileName);

            multipartFile.transferTo(uploadFile);

            return awsS3UploadFacade.uploadFileInMemory(uploadFile, newFileName);

        }
        catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }

    }

}


class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}