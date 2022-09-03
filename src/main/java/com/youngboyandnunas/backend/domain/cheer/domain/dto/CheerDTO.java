package com.youngboyandnunas.backend.domain.cheer.domain.dto;

import com.youngboyandnunas.backend.domain.worry.dto.WorryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheerDTO {

    private Long cheerId;

    private Long worryId ;

    private Long userId;

    private WorryResponseDTO worryDTO;

    private String contents;

    private MultipartFile imageMultipartFile;

    private MultipartFile audioMultipartFile;

    private String imgUrl;

    private String audioUrl;

}
