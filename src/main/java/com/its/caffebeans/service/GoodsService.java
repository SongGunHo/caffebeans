package com.its.caffebeans.service;

import com.its.caffebeans.dto.GoodsDTO;
import com.its.caffebeans.entiry.GoodsEntity;
import com.its.caffebeans.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    @Transactional
    public List<GoodsDTO> findAll() {
        List<GoodsEntity> goodsEntityList =goodsRepository.findAll();
        System.out.println("goodsEntityList = " + goodsEntityList);
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        System.out.println("goodsDTOList = " + goodsDTOList);
        for(GoodsEntity goods : goodsEntityList){
            goodsDTOList.add(GoodsDTO.toGoodsDTO(goods));
        }return goodsDTOList;
    }

    public GoodsDTO findById(Long id) {
        Optional<GoodsEntity> byId = goodsRepository.findById(id);
        if (byId.isPresent()) {
            GoodsEntity goodsEntity = byId.get();
            return GoodsDTO.toGoodsDTO(goodsEntity);
        } else {
            return null;
        }
    }

    public GoodsEntity save(GoodsDTO goodsDTO) throws IOException {
         MultipartFile goodsFile =goodsDTO.getGoodsFile();
         String goodsFileName =goodsFile.getOriginalFilename();
         goodsFileName = System.currentTimeMillis()+"_"+ goodsFileName;
         String savePath = "D:\\spring_boot\\"+goodsFileName;
        if(!goodsFile.isEmpty()){
            goodsFile.transferTo(new File(savePath));
        }
        goodsDTO.setGoodsFileName(goodsFileName);
        return   goodsRepository.save(GoodsEntity.toSaveEntity(goodsDTO));
    }

    public void update(GoodsDTO goodsDTO) {
        goodsRepository.save(GoodsEntity.toUpdateEntity(goodsDTO));
    }
}
