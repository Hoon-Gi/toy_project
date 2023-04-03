package com.example.toyProject1.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Optional<Member> findByMemberId(Integer memberId);
    Member findByMemberNameAndMemberNumber(String memberName, String MemberNumber);
    Optional<Member> findByMemberNameAndMemberNumberEndsWith(String memberName, String memberNumberSuffix);
}
