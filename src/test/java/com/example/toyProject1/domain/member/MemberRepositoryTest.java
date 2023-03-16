package com.example.toyProject1.domain.member;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @Test
    public void member_save() {
        String memberName = "회원 이름";
        String memberNumber = "회원 전화번호";

        memberRepository.save(
                Member.builder()
                        .memberName(memberName)
                        .memberNumber(memberNumber)
                        .build()
        );

        List<Member> memberList = memberRepository.findAll();

        Member member = memberList.get(0);
        assertThat(member.getMemberName()).isEqualTo(memberName);
        assertThat(member.getMemberNumber()).isEqualTo(memberNumber);
    }
}
