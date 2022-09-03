package com.youngboyandnunas.backend.domain.cheer.domain.service;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.cheer.domain.dao.CheerRepository;
import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.util.CustomModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

@Service
public class CheerService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;

    private final CustomModelMapper customModelMapper;

    @Autowired
    public CheerService(CheerRepository cheerRepository, UserRepository userRepository
            , CustomModelMapper customModelMapper) {
        this.cheerRepository = cheerRepository;
        this.userRepository = userRepository;
        this.customModelMapper = customModelMapper;
    }

    public int insertCheer(CheerDTO cheerDTO){

        Cheer cheerEntity = customModelMapper.dtoToEntityMapper().map(cheerDTO, Cheer.class);



        return 0;
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
