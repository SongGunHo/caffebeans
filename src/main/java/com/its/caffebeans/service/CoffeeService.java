package com.its.caffebeans.service;

import com.its.caffebeans.dto.CoffeeDTO;
import com.its.caffebeans.entiry.CoffeeEntity;
import com.its.caffebeans.repository.CoffeeRepository;
import com.its.caffebeans.repository.MemberRepository;
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
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final MemberRepository memberRepository;
    public CoffeeEntity save(CoffeeDTO coffeeDTO) throws IOException {
         MultipartFile coffeeFile =coffeeDTO.getCoffeeFile();
         String coffeeFileName =coffeeFile.getOriginalFilename();
         coffeeFileName = System.currentTimeMillis()+"_" +coffeeFileName;
         String savePath= "D:\\spring_boot"+coffeeFileName;
         if(!coffeeFile.isEmpty()){
             coffeeFile.transferTo(new File(savePath));
         }
         coffeeDTO.setCoffeeFileName(coffeeFileName);
        return coffeeRepository.save(CoffeeEntity.toSaveEntity(coffeeDTO));
    }

    @Transactional
    public List<CoffeeDTO> findAll() {
         List<CoffeeEntity> coffeeEntityList = coffeeRepository.findAll();
         List<CoffeeDTO> coffeeDTOList = new ArrayList<>();
         for(CoffeeEntity coffee: coffeeEntityList){
             coffeeDTOList.add(CoffeeDTO.toCoffeeDTO(coffee));
         }return coffeeDTOList;
    }

    public CoffeeDTO findById(Long id) {
         Optional<CoffeeEntity> coffee =coffeeRepository.findById(id);
         if(coffee.isPresent()){
              CoffeeEntity coffee1 =coffee.get();
              return CoffeeDTO.toCoffeeDTO(coffee1);
         }else {
             return null;
         }
    }

    public void update(CoffeeDTO coffeeDTO) {
        coffeeRepository.save(CoffeeEntity.toUpdate(coffeeDTO));
    }

    public void delete(Long id) {
        coffeeRepository.deleteById(id);
    }
}
