package com.example.toyProject1;

import com.example.toyProject1.domain.member.MemberRepository;
import com.example.toyProject1.domain.seats.Seats;
import com.example.toyProject1.domain.seats.SeatsRepository;
import com.example.toyProject1.domain.studyRoom.StudyRoom;
import com.example.toyProject1.domain.studyRoom.StudyRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ToyProject1ApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private StudyRoomRepository studyRoomRepository;
	@Autowired
	private SeatsRepository seatsRepository;

	@Test
	void testJpa() {
		/*insert
		Member m1 = new Member();
		m1.setMemberName("윤기훈");
		m1.setMemberNumber("01056687581");
		this.memberRepository.save(m1);

		List<Member> all = this.memberRepository.findAll();
		assertEquals(2, all.size());
		*/

		/*
		Member m = all.get(0);
		assertEquals("윤기훈", m.getMemberName());
		*/

		/*select by id
		Optional<Member> findById = this.memberRepository.findById(1);
		if(findById.isPresent()) {
			Member om = findById.get();
			assertEquals("윤기훈", om.getMemberName());
		}
		*/

		//Member m = this.memberRepository.findByMemberNameAndMemberNumber("윤기훈", "01056687581");

		/*update
		Optional<Member> om = this.memberRepository.findById(2);
		assertTrue(om.isPresent());
		Member m = om.get();
		m.setMemberName("윤영훈");
		m.setMemberNumber("01084487581");
		this.memberRepository.save(m);
		*/

		/*delete
		assertEquals(2, this.memberRepository.count());
		Optional<Member> om = this.memberRepository.findById(2);
		assertTrue(om.isPresent());
		Member m = om.get();
		this.memberRepository.delete(m);
		assertEquals(1, this.memberRepository.count());
		 */

		/*
		StudyRoom r = new StudyRoom();
		r.setStudyRoomName("행복독서실");
		r.setStudyRoomNumber("025557777");
		r.setLocation("저기 어딘가");
		this.studyRoomRepository.save(r);
		 */


		Optional<StudyRoom> or = this.studyRoomRepository.findById(1);
		assertTrue(or.isPresent());
		StudyRoom r = or.get();

		Seats s = new Seats();
		s.setUsedStatus(0);
		s.setSeatNumber(1);
		s.setStudyRoom(r);
		this.seatsRepository.save(s);

	}

}
