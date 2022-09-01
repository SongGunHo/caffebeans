package com.its.caffebeans.entiry;

import com.its.caffebeans.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long memberId;
    @Column(length = 30,nullable = true)
    private String memberEmail;
    @Column(length = 30,nullable = false)
    private String memberPassword;
    @Column(length = 30,nullable = true)
    private String memberName;
    @Column
    private int memberAge;
    @Column(length = 30,nullable = false)
    private String memberPhone;



    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        return memberEntity;
    }

    public static MemberEntity toUpdateEntity(MemberDTO memberDTO) {
        MemberEntity member = new MemberEntity();
        member.setMemberId(memberDTO.getId());
        member.setMemberEmail(memberDTO.getMemberEmail());
        member.setMemberPassword(memberDTO.getMemberPassword());
        member.setMemberName(memberDTO.getMemberName());
        member.setMemberAge(memberDTO.getMemberAge());
        member.setMemberPhone(memberDTO.getMemberPhone());
        return member;
    }
}

