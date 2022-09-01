package com.its.caffebeans.service;

import com.its.caffebeans.dto.MenuDTO;
import com.its.caffebeans.entiry.MenuEntity;
import com.its.caffebeans.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
private  final MenuRepository menuRepository;

    public MenuEntity save(MenuDTO menuDTO) {

        return menuRepository.save(MenuEntity.toSaveEntity(menuDTO));
    }


    public List<MenuDTO> findAll() {
        List<MenuEntity> menuEntityList =menuRepository.findAll();
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for(MenuEntity menu : menuEntityList){
            menuDTOList.add(MenuDTO.toMenuTO(menu));
        }return menuDTOList;
    }

    public MenuDTO findById(Long id) {
         Optional<MenuEntity> byId =menuRepository.findById(id);
         if(byId.isPresent()){
              MenuEntity menuEntity = byId.get();
              return MenuDTO.toMenuTO(menuEntity);
         }else {
             return null;
         }
    }

    public void update(MenuDTO menuDTO) {
        menuRepository.save(MenuEntity.toUpdate(menuDTO));
    }
}
