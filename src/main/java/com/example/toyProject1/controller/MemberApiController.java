package com.example.toyProject1.controller;

import com.example.toyProject1.controller.dto.InsertMemberInfoDto;
import com.example.toyProject1.controller.dto.ReadMemberInfoDto;
import com.example.toyProject1.controller.dto.UpdateMemberInfoDto;
import com.example.toyProject1.domain.member.Member;
import com.example.toyProject1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/api/member/create")
    public Integer insert(@RequestBody InsertMemberInfoDto dto) {
        return memberService.insertMemberInfo(dto);
    }

    @GetMapping("/api/member/read/{memberId}")
    public ReadMemberInfoDto findById(@PathVariable Integer memberId) {
        return memberService.findById(memberId);
    }

    @GetMapping("/api/member/readAll")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @PutMapping("/api/member/update/{memberId}")
    public Integer update(@PathVariable Integer memberId, @RequestBody UpdateMemberInfoDto dto) {
        return memberService.updateMemberInfo(memberId, dto);
    }

    @GetMapping("/api/member/delete/{memberId}")
    public String delete(@PathVariable Integer memberId) {
        return memberService.deleteMemberInfo(memberId);
    }

}
