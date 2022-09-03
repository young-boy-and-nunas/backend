package com.youngboyandnunas.backend.domain.cheer.domain.service;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.cheer.domain.dao.CheerRepository;
import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import com.youngboyandnunas.backend.util.CustomModelMapper;
import com.youngboyandnunas.backend.util.FileStorageUtil;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CheerService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;


    private final CustomModelMapper customModelMapper;

    private final FileStorageUtil fileStorageUtil;

    public CheerService(CheerRepository cheerRepository
            , UserRepository userRepository
            , CustomModelMapper customModelMapper
            , FileStorageUtil fileStorageUtil) {
        this.cheerRepository = cheerRepository;
        this.userRepository = userRepository;
        this.customModelMapper = customModelMapper;
        this.fileStorageUtil = fileStorageUtil;
    }

    @Transactional
    public int insertCheer(CheerDTO cheerDTO){

        Cheer cheerEntity = customModelMapper.dtoToEntityMapper().map(cheerDTO, Cheer.class);
        Optional<User> user = userRepository.findById(cheerDTO.getUserId());
//        Optional<Worry> worry =

        if(cheerDTO.getAudioMultipartFile() != null){
            cheerEntity.setAudioUrl(fileStorageUtil.store(cheerDTO.getAudioMultipartFile()));
        }

        if(cheerDTO.getImageMultipartFile() != null){
            cheerEntity.setImgUrl(fileStorageUtil.store(cheerDTO.getImageMultipartFile()));
        }

        cheerEntity.setUser(user.get());
        Cheer savedCheer = cheerRepository.save(cheerEntity);

        return 0;
//        return customModelMapper.strictMapper().map(savedCheer, CheerDTO.class);
    }

    public List<CheerDTO> selectLimit20Cheer(){

        return null;
    }

    public CheerDTO selectOneDTO(){
        return null;
    }

    public int updateCheck(){

        return 0;
    }

}
