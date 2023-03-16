package com.example.toyProject1.domain.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    @Column
    private String memberName;
    @Column
    private String memberNumber;

    @Builder
    public Member(String memberName, String memberNumber) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }

    public void update(String memberName, String memberNumber) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }
}
