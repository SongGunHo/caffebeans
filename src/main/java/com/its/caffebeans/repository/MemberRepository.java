package com.its.caffebeans.repository;

import com.its.caffebeans.dto.MemberDTO;
import com.its.caffebeans.entiry.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findBymemberEmail(String memberEmail);
}
