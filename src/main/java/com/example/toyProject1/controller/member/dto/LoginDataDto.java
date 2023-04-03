package com.example.toyProject1.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginDataDto {
    private String memberName;
    private String memberNumberSuffix;

    @Builder
    public LoginDataDto (String memberName, String memberNumberSuffix) {
        this.memberName = memberName;
        this.memberNumberSuffix = memberNumberSuffix;
    }
}
