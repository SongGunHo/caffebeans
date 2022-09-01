package com.its.caffebeans.repository;

import com.its.caffebeans.dto.MemberDTO;
import com.its.caffebeans.entiry.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByMemberEmail(String memberEmail);

}
