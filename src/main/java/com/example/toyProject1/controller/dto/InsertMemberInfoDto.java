package com.example.toyProject1.controller.dto;

import com.example.toyProject1.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InsertMemberInfoDto {
    private String memberName;
    private String memberNumber;

    @Builder
    public InsertMemberInfoDto(String memberName, String memberNumber) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }

    public Member toEntity() {
        return Member.builder()
                .memberName(memberName)
                .memberNumber(memberNumber)
                .build();
    }
}
