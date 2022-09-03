package com.youngboyandnunas.backend.util;


import com.amazonaws.auth.policy.Resource;
import com.youngboyandnunas.backend.global.infra.AwsS3UploadFacade;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.stream.Stream;

public class FileStorageUtil{

    private final Path rootLocation;
    private final UUID uuid;
    private final AwsS3UploadFacade awsS3UploadFacade;

    @Autowired
    public FileStorageUtil(Path rootLocation, UUID uuid, AwsS3UploadFacade awsS3UploadFacade) {
        this.rootLocation = rootLocation;
        this.uuid = uuid;
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