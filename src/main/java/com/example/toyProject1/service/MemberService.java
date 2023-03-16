package com.example.toyProject1.service;

import com.example.toyProject1.controller.dto.InsertMemberInfoDto;
import com.example.toyProject1.controller.dto.ReadMemberInfoDto;
import com.example.toyProject1.controller.dto.UpdateMemberInfoDto;
import com.example.toyProject1.domain.member.Member;
import com.example.toyProject1.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Insert;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Integer insertMemberInfo(InsertMemberInfoDto dto) {
        return memberRepository.save(dto.toEntity()).getMemberId();
    }

    @Transactional
    public ReadMemberInfoDto findById(Integer memberId) {
        Member entity = memberRepository.findById(memberId).orElseThrow(()
                -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + memberId));
        return new ReadMemberInfoDto(entity);
    }

    @Transactional
    public List<Member> findAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    @Transactional
    public Integer updateMemberInfo(Integer memberId, UpdateMemberInfoDto dto) {
        Member member = memberRepository.findById(memberId).orElseThrow(()
                -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + memberId));

        member.update(dto.getMemberName(), dto.getMemberNumber());
        return memberId;
    }

    @Transactional
    public String deleteMemberInfo(Integer memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()
                -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + memberId));

        memberRepository.deleteById(memberId);
        return "success";
    }

}
