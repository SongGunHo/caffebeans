package com.its.caffebeans.service;

import com.its.caffebeans.dto.MemberDTO;
import com.its.caffebeans.entiry.MemberEntity;
import com.its.caffebeans.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDTO login(MemberDTO memberDTO) {
         Optional<MemberEntity> bymemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
         if(bymemberEmail.isPresent()){
              MemberEntity memberEntity =bymemberEmail.get();
              if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                  return MemberDTO.toMemberDTO(memberEntity);
              }else{
                  return null;
              }
         }else {
             return null;
         }
    }

    public List<MemberDTO> findAll() {
         List<MemberEntity> memberEntityList = memberRepository.findAll();
         List<MemberDTO> memberList = new ArrayList<>();
         for (MemberEntity member: memberEntityList){
            memberList.add(MemberDTO.toMemberDTO(member));
         }
        System.out.println("memberList = " + memberList);
         return memberList;
    }

    public String emailResult(String memberEmail) {
        Optional<MemberEntity> bymemberEmail = memberRepository.findByMemberEmail(memberEmail);
        if(bymemberEmail.isEmpty()){
            return "ok";
        }else {
            return "no";
        }
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
             MemberEntity member = optionalMemberEntity.get();
            return MemberDTO.toMemberDTO(member);
        }else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateEntity(memberDTO));
    }



    public void delete(Long id) {

        memberRepository.deleteById(id);
    }

    public MemberEntity save(MemberDTO memberDTO) {
      return   memberRepository.save(MemberEntity.toSaveEntity(memberDTO));
    }
}
