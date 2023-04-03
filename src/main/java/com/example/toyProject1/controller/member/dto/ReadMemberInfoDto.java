package com.example.toyProject1.controller.member.dto;

import com.example.toyProject1.domain.member.Member;
import lombok.Getter;

@Getter
public class ReadMemberInfoDto {

    private String memberName;
    private String memberNumber;

    public ReadMemberInfoDto(Member entity) {
        this.memberName = entity.getMemberName();
        this.memberNumber = entity.getMemberNumber();
    }
}
