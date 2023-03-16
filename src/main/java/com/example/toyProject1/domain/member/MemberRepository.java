package com.example.toyProject1.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByMemberNameAndMemberNumber(String memberName, String MemberNumber);
}
