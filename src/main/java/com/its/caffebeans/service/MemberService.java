package com.its.caffebeans.service;

import com.its.caffebeans.dto.MemberDTO;
import com.its.caffebeans.entiry.MemberEntity;
import com.its.caffebeans.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public Long  save(MemberDTO memberDTO) {
       return memberRepository.save(MemberEntity.toSaveEntity(memberDTO)).getId();
    }

    public MemberDTO login(MemberDTO memberDTO) {
         Optional<MemberEntity> bymemberEmail = memberRepository.findBymemberEmail(memberDTO.getMemberEmail());
         if(bymemberEmail.isPresent()){
              MemberEntity memberEntity =bymemberEmail.get();
              if(memberEntity.getMemberPassword().equals(memberEntity.getMemberEmail())){
                  MemberDTO.toMemberDTO(memberEntity);
                  return memberDTO;
              }else{
                  return null;
              }
         }else {
             return null;
         }
    }
}
