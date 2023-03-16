package com.example.toyProject1.controller;

import com.example.toyProject1.controller.dto.InsertMemberInfoDto;
import com.example.toyProject1.controller.dto.UpdateMemberInfoDto;
import com.example.toyProject1.domain.member.Member;
import com.example.toyProject1.domain.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberApiControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MemberRepository memberRepository;

    @LocalServerPort
    private int port;

    @Test
    public void testJpa_insert() throws Exception {
        String memberName = "회원 이름";
        String memberNumber = "회원 전화번호";

        InsertMemberInfoDto dto = InsertMemberInfoDto.builder()
                .memberName(memberName)
                .memberNumber(memberNumber)
                .build();

        String url = "http://localhost:" + port + "/api/member/insert";

        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, dto, Integer.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0);

        List<Member> all = memberRepository.findAll();

        assertThat(all.get(2).getMemberName()).isEqualTo(memberName);
        assertThat(all.get(2).getMemberNumber()).isEqualTo(memberNumber);
    }

    @Test
    public void Member_update() throws Exception {

        Integer updateMemberId = 5;
        String memberName = "가나다";
        String memberNumber = "00033332222";

        UpdateMemberInfoDto dto = UpdateMemberInfoDto.builder()
                .memberName(memberName)
                .memberNumber(memberNumber)
                .build();

        String url = "http://localhost:" + port + "/api/member/update/" + updateMemberId;

        HttpEntity<UpdateMemberInfoDto> requestEntity = new HttpEntity<>(dto);

        ResponseEntity<Integer> responseEntity =
                restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Integer.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0);

        List<Member> all = memberRepository.findAll();

        assertThat(all.get(3).getMemberName()).isEqualTo(memberName);
        assertThat(all.get(3).getMemberNumber()).isEqualTo(memberNumber);

    }
}
