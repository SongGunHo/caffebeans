package com.its.caffebeans.controller;

import com.its.caffebeans.dto.BoardDTO;
import com.its.caffebeans.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/save-form")
    public String saveForm(){
    return "boardPages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
          boardService.save(boardDTO);
        return "redirect:/board/list";
    }
    @GetMapping("/list")
    public String list(Model model){
         List<BoardDTO> allDTO = boardService.findAll();
        System.out.println("allDTO = " + allDTO);
         model.addAttribute("all",allDTO);
         return "boardPages/list";
    }
    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable Long id ,Model model){
        BoardDTO boardDTO= boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "/boardPages/update";
    }
    @PostMapping("update")
    public String update(BoardDTO boardDTO){
        boardService.update(boardDTO);
        return "redirect:/board/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){
         BoardDTO byIdDTO = boardService.findById(id);
         model.addAttribute("byId",byIdDTO);
         return "boardPages/detail";
    }
}
