package com.its.caffebeans.controller;

import com.its.caffebeans.dto.CoffeeDTO;
import com.its.caffebeans.entiry.CoffeeEntity;
import com.its.caffebeans.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeService coffeeService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "coffeePages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute CoffeeDTO coffeeDTO) throws IOException {
        CoffeeEntity save = coffeeService.save(coffeeDTO);
        return "redirect:/coffee/list";
    }
    @GetMapping("/list")
    public String list(Model model){
         List<CoffeeDTO> allDTO = coffeeService.findAll();
         model.addAttribute("all",allDTO);
         return "/coffeePages/list";
    }
    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable Long id,Model model){
         CoffeeDTO byId = coffeeService.findById(id);
         model.addAttribute("update",byId);
         return "coffeePages/update";
    }
    @PostMapping("/update")
    public String update(CoffeeDTO coffeeDTO){
        coffeeService.update(coffeeDTO);
        return "/coffeePages/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){
         CoffeeDTO byIdDTO =coffeeService.findById(id);
         model.addAttribute("byId",byIdDTO);
         return "coffeePages/detail";

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        coffeeService.delete(id);
        return "index";
    }
}
