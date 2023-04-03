package com.example.toyProject1.service;

import com.example.toyProject1.controller.member.dto.InsertMemberInfoDto;
import com.example.toyProject1.controller.member.dto.LoginDataDto;
import com.example.toyProject1.controller.member.dto.ReadMemberInfoDto;
import com.example.toyProject1.controller.member.dto.UpdateMemberInfoDto;
import com.example.toyProject1.domain.member.Member;
import com.example.toyProject1.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Integer insertMemberInfo(InsertMemberInfoDto dto) {
        //Member member = new Member(dto.getMemberName(), dto.getMemberNumber());
        Member member = Member.builder()
                .memberName(dto.getMemberName())
                .memberNumber(dto.getMemberNumber())
                .build();

        Member savedMember = memberRepository.save(member);
        return member.getMemberId();
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

    @Transactional
    public Integer login(LoginDataDto dto) {
       Member member = memberRepository.findByMemberNameAndMemberNumberEndsWith(dto.getMemberName(), dto.getMemberNumberSuffix())
               .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

       return member.getMemberId();
    }
}
