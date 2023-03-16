package com.example.toyProject1.controller.dto;

import com.example.toyProject1.domain.member.Member;
import lombok.Getter;

@Getter
public class ReadMemberInfoDto {

    private Integer memberId;
    private String memberName;
    private String memberNumber;

    public ReadMemberInfoDto(Member entity) {
        this.memberId = entity.getMemberId();
        this.memberName = entity.getMemberName();
        this.memberNumber = entity.getMemberNumber();
    }
}
