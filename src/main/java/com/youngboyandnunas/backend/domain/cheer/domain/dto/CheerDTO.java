package com.youngboyandnunas.backend.domain.cheer.domain.dto;

import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

public class CheerDTO {

    private Worry worry;

    private User user;

    private String contents;

    private List<MultipartFile> multipartFileList;


}
