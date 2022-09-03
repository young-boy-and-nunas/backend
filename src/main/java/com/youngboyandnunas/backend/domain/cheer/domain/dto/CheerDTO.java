package com.youngboyandnunas.backend.domain.cheer.domain.dto;

import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
public class CheerDTO {

    private Long worryId ;

    private Long userId;

    private String contents;

    private MultipartFile imageMultipartFile;

    private MultipartFile audioMultipartFile;

    private String imgUrl;

    private String audioUrl;

}
