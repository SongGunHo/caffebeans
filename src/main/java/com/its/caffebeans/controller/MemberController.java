package com.its.caffebeans.controller;

import com.its.caffebeans.dto.MemberDTO;
import com.its.caffebeans.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "memberPages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
         return "memberPages/login";
    }
    @GetMapping("/login-form")
    public String loginForm(){
        return "memberPages/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
         MemberDTO loginDTO = memberService.login(memberDTO);
        System.out.println("loginDTO = " + loginDTO);
         if(loginDTO != null){
             session.setAttribute("login", loginDTO);
             return "memberPages/main";
         }else {
             return "memberPages/login";
         }
    }
    @GetMapping("/main")
    public String main(){
        List<MemberDTO> all = memberService.findAll();
        return "/memberPages/main";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<MemberDTO> all = memberService.findAll();
        System.out.println("model = " + model);
        model.addAttribute("all",all);
        return "/memberPages/list";
    }

    @GetMapping("/myPages-form")
    public String myPagesForm(){
        return "/memberPages/myPages";
    }
    @PostMapping("/myPages/{id}")
    public String myPages(@PathVariable Long id){
        memberService.findById(id);
         return "/memberPages/main";
    }

    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        MemberDTO memberDTO =memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "memberPages/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        memberService.update(memberDTO);
        return "/memberPages/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        memberService.delete(id);
        return  "index";
    }
    @GetMapping("/admin-form")
    public String adminForm(Model model) {
        List<MemberDTO> memberDTOList = new ArrayList<>();
        memberDTOList = memberService.findAll();
        model.addAttribute("member",memberDTOList);
        return "memberPages/admin";
    }
    @GetMapping("/logout")
    public String logout(MemberDTO memberDTO ,HttpSession session){
        MemberDTO login = memberService.login(memberDTO);
        session.setAttribute("login",login);
        return "index";
    }
    @GetMapping("/emailResult")
    public @ResponseBody String emailResult(@PathVariable("memberEmail")String memberEmail){
         String count = memberService.emailResult(memberEmail);
        System.out.println("memberEmail = " + memberEmail);
         return count;
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){
         MemberDTO byIdDTO = memberService.findById(id);
         model.addAttribute("byId",byIdDTO);
         return "memberPages/detail";
    }

}
