package com.youngboyandnunas.backend.global.infra;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class AwsS3UploadFacade {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public String uploadFile(File file, String fileName) {
        amazonS3.putObject(bucket, fileName, file);
        cleanUpLocalFile(file.toPath());
        return getFileUrl(fileName);
    }

//    public String uploadFileInMemory(File file, String fileName){
//        amazonS3.putObject(bucket, fileName, file);
//        return getFileUrl(fileName);
//    }

    public void deleteFile(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
    }

    private String getFileUrl(String fileName) {
        return amazonS3.getUrl(bucket, fileName).toString();
    }

    private void cleanUpLocalFile(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(path.toString());
        }
    }

}
