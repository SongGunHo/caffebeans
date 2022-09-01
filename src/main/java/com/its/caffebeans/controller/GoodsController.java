package com.its.caffebeans.controller;

import com.its.caffebeans.dto.GoodsDTO;
import com.its.caffebeans.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @GetMapping("/save-form")
    public String saveForm() {

        return "/goodsPages/save";
    }
    @PostMapping("/save")
    public String save(GoodsDTO goodsDTO) throws IOException {
         goodsService.save(goodsDTO);
        return "redirect:/goods/list";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<GoodsDTO> allDTO = goodsService.findAll();
        System.out.println("allDTO = " + allDTO);
        model.addAttribute("all", allDTO);
        return "/goodsPages/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        GoodsDTO byIdDTO = goodsService.findById(id);
        model.addAttribute("byId", byIdDTO);
        System.out.println("GoodsController.detail");
        System.out.println(" model = " + model);
        return "/goodsPages/detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        goodsService.findById(id);
        return "index";
    }
    @GetMapping("/update-form/{id}")
    public String update(@PathVariable Long id, Model model){
         GoodsDTO byIdDTO = goodsService.findById(id);
         model.addAttribute("member",byIdDTO);
         return "/goodsPages/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute GoodsDTO goodsDTO){
        goodsService.update(goodsDTO);
        return "/goodsPages/list";
    }
}