package com.youngboyandnunas.backend.domain.worry.service;

import com.youngboyandnunas.backend.domain.history.domain.History;
import com.youngboyandnunas.backend.domain.history.repository.HistoryRepository;
import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import com.youngboyandnunas.backend.domain.worry.dto.CreateWorryRequestDto;
import com.youngboyandnunas.backend.domain.worry.dto.WorryResponseDTO;
import com.youngboyandnunas.backend.domain.worry.dao.WorryRepository;
import com.youngboyandnunas.backend.global.exception.ErrorCode;
import com.youngboyandnunas.backend.global.exception.GlobalException;
import com.youngboyandnunas.backend.global.security.service.AuthenticationFacade;
import com.youngboyandnunas.backend.util.FileStorageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class WorryServiceImpl implements WorryService {

    private final WorryRepository worryRepository;
    private final UserRepository userRepository;
    private final HistoryRepository historyRepository;
    private final AuthenticationFacade authenticationFacade;
    private final FileStorageUtil fileStorageUtil;

    @Transactional
    @Override
    public WorryResponseDTO getRandomWorry() {
        Long userId = authenticationFacade.getUserId();
        Worry worry = worryRepository.getRandomWorry(userId);
        if (worry == null)
            throw new GlobalException(ErrorCode.NOT_FOUND_ERROR);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GlobalException(ErrorCode.BAD_REQUEST_ERROR));

        historyRepository.save(History.builder()
                .worry(worry)
                .user(user)
                .build());

        String nickname = worry.getUser().getNickname();

        return WorryResponseDTO.builder()
                .worrySeq(worry.getWorrySeq())
                .contents(worry.getContents())
                .imgUrl(worry.getImgUrl())
                .nickname(nickname)
                .build();
    }

    @Override
    public void createWorry(CreateWorryRequestDto dto) {
        User user = userRepository.findById(authenticationFacade.getUserId())
                .orElseThrow(() -> new GlobalException(ErrorCode.BAD_REQUEST_ERROR));
        user.setLuckyPoint(user.getLuckyPoint()-1);

        userRepository.save(user);

        MultipartFile imgFile = dto.getImgFile();
        Worry worry = Worry.builder()
                .contents(dto.getContents())
                .imgUrl(imgFile != null? fileStorageUtil.store(dto.getImgFile()) : null)
                .user(user)
                .build();
        worryRepository.save(worry);
    }

}
