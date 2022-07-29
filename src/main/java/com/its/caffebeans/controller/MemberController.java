package com.its.caffebeans.controller;

import com.its.caffebeans.dto.MemberDTO;
import com.its.caffebeans.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(MemberDTO memberDTO){
         Long save = memberService.save(memberDTO);
        System.out.println("memberDTO = " + memberDTO);
         return "login";
    }
    @GetMapping("/login-form")
    public String loginForm(){
        return "login";
    }
    @PostMapping("/login")
    public String login(MemberDTO memberDTO , HttpSession session){
         MemberDTO login = memberService.login(memberDTO);
         if(login== null){
             session.setAttribute("loginMember",login.getId());
             session.setAttribute("login",login);
             return "list";
         }else {
             return "login";
         }
    }

}
