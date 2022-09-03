package com.youngboyandnunas.backend.domain.cheer.domain.service;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.cheer.domain.dao.CheerRepository;
import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.dao.WorryRepository;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import com.youngboyandnunas.backend.util.CustomModelMapper;
import com.youngboyandnunas.backend.util.FileStorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheerService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;

    private final WorryRepository worryRepository;

    private final CustomModelMapper customModelMapper;

    private final FileStorageUtil fileStorageUtil;


    @Autowired
    public CheerService(CheerRepository cheerRepository
            , UserRepository userRepository, WorryRepository worryRepository
            , CustomModelMapper customModelMapper
            , FileStorageUtil fileStorageUtil) {
        this.cheerRepository = cheerRepository;
        this.userRepository = userRepository;
        this.worryRepository = worryRepository;
        this.customModelMapper = customModelMapper;
        this.fileStorageUtil = fileStorageUtil;
    }

    @Transactional
    public CheerDTO insertCheer(CheerDTO cheerDTO){

//        Cheer cheerEntity = customModelMapper.dtoToEntityMapper().map(cheerDTO, Cheer.class);
        Cheer cheerEntity = new Cheer();
        cheerEntity.setContents(cheerDTO.getContents());

        User user = userRepository.findById(cheerDTO.getUserId()).get();
        Worry worry = worryRepository.findById(cheerDTO.getWorryId()).get();

        if(cheerDTO.getAudioMultipartFile() != null){
            cheerEntity.setAudioUrl(fileStorageUtil.store(cheerDTO.getAudioMultipartFile()));
        }

        if(cheerDTO.getImageMultipartFile() != null){
            cheerEntity.setImgUrl(fileStorageUtil.store(cheerDTO.getImageMultipartFile()));
        }

        user.plusLuckyPoint();
        cheerEntity.setUser(user);
        cheerEntity.setWorry(worry);
        Cheer savedCheer = cheerRepository.save(cheerEntity);

        return customModelMapper.strictMapper().map(savedCheer, CheerDTO.class);
    }

    public List<CheerDTO> selectLimit20Cheer(Long userId){

        Optional<User> user = userRepository.findById(userId);
        List<Cheer> cheerByUserIdLimit20 = cheerRepository.getCheerByUserIdLimit20(user.get(), PageRequest.of(0, 10));

        List<CheerDTO> collect = cheerByUserIdLimit20.stream()
                .map(m-> customModelMapper.strictMapper().map(m, CheerDTO.class))
                .collect(Collectors.toList());

        return collect;
    }

    @Transactional
    public void updateCheck(Long cheerSeq){

        Cheer cheer = cheerRepository.findById(cheerSeq).get();
        cheer.updateCheck();
        cheerRepository.save(cheer);

    }

}
