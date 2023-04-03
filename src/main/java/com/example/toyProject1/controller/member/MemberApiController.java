package com.example.toyProject1.controller.member;

import com.example.toyProject1.controller.member.dto.InsertMemberInfoDto;
import com.example.toyProject1.controller.member.dto.LoginDataDto;
import com.example.toyProject1.controller.member.dto.ReadMemberInfoDto;
import com.example.toyProject1.controller.member.dto.UpdateMemberInfoDto;
import com.example.toyProject1.domain.member.Member;
import com.example.toyProject1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MemberApiController {
    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/member/insert")
    public Integer insert(@RequestBody InsertMemberInfoDto dto) {
        return memberService.insertMemberInfo(dto);
    }

    @GetMapping("/api/member/read/{memberId}")
    public ResponseEntity<ReadMemberInfoDto> getMemberById(@PathVariable Integer memberId) {
        try {
            ReadMemberInfoDto memberInfo = memberService.findById(memberId);
            return ResponseEntity.ok(memberInfo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
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

    @PostMapping("/api/member/login")
    public Integer login (@RequestBody LoginDataDto dto) {
        return memberService.login(dto);
    }

}
