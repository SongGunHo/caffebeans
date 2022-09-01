package com.its.caffebeans.controller;

import com.its.caffebeans.dto.MenuDTO;
import com.its.caffebeans.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "menuPages/save";
    }
    @PostMapping("/save")
    public String save(MenuDTO menuDTO){
          menuService.save(menuDTO);
         return "/menuPages/save";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<MenuDTO> all =menuService.findAll();
        model.addAttribute("all",all);
        return "/menuPages/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){
        MenuDTO byIdDTO = menuService.findById(id);
        model.addAttribute("byId",byIdDTO);
        return  "/menuPages/detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        menuService.findById(id);
        return "index";
    }
    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable Long id,Model model){
         MenuDTO byId = menuService.findById(id);
         model.addAttribute("update",byId);
         return "/menuPages/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MenuDTO menuDTO){
        menuService.update(menuDTO);
        return "/menuPages/list";
    }
}
