package com.example.toyProject1.controller.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMemberInfoDto {

    private String memberName;
    private String memberNumber;

    @Builder
    public UpdateMemberInfoDto(String memberName, String memberNumber) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }
}
