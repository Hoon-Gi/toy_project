package com.example.toyProject1.service;

import com.example.toyProject1.controller.studyRoom.StudyRoomApiController;
import com.example.toyProject1.controller.studyRoom.dto.AddSeatsRequestDto;
import com.example.toyProject1.controller.studyRoom.dto.StudyRoomRequestDto;
import com.example.toyProject1.controller.studyRoom.dto.StudyRoomResponseDto;
import com.example.toyProject1.domain.member.Member;
import com.example.toyProject1.domain.member.MemberRepository;
import com.example.toyProject1.domain.seats.Seats;
import com.example.toyProject1.domain.studyRoom.StudyRoom;
import com.example.toyProject1.domain.studyRoom.StudyRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudyRoomService {
    private final StudyRoomRepository studyRoomRepository;

    public StudyRoomService(StudyRoomRepository studyRoomRepository) {
        this.studyRoomRepository = studyRoomRepository;
    }

    public StudyRoomResponseDto findByStudyRoomId(Integer studyRoomId) {
        StudyRoom studyRoom = studyRoomRepository.findById(studyRoomId).orElseThrow(()
                -> new IllegalArgumentException("해당 독서실이 존재하지 않습니다. id=" + studyRoomId));

        return new StudyRoomResponseDto(studyRoom.getStudyRoomId(), studyRoom.getStudyRoomName(),
                studyRoom.getStudyRoomNumber(), studyRoom.getLocation());
    }

    public List<StudyRoomRepository.StudyRoomInfoMapping> findAllStudyRoomLists() {
        List<StudyRoomRepository.StudyRoomInfoMapping> studyRoomList = studyRoomRepository.findAllBy();
        return studyRoomList;
    }

    public StudyRoomResponseDto insertStudyRoomInfo(StudyRoomRequestDto studyRoomRequestDto) {
        StudyRoom studyRoom = StudyRoom.builder()
                .studyRoomName(studyRoomRequestDto.getStudyRoomName())
                .studyRoomNumber(studyRoomRequestDto.getStudyRoomNumber())
                .location(studyRoomRequestDto.getLocation())
                .build();

        StudyRoom savedStudyRoom = studyRoomRepository.save(studyRoom);

        StudyRoomResponseDto studyRoomResponseDto = StudyRoomResponseDto.builder()
                .studyRoomId(savedStudyRoom.getStudyRoomId())
                .studyRoomName(savedStudyRoom.getStudyRoomName())
                .studyRoomNumber(savedStudyRoom.getStudyRoomNumber())
                .location(savedStudyRoom.getLocation())
                .build();

        return studyRoomResponseDto;
    }

    public Integer updateStudyRoomInfo(StudyRoomResponseDto dto) {
        Optional<StudyRoom> opStudyRoom = studyRoomRepository.findById(dto.getStudyRoomId());
        if(opStudyRoom.isEmpty()) {
            throw new RuntimeException("잘못된 정보입니다.");
        }
        StudyRoom studyRoom = opStudyRoom.get();

        studyRoom.setStudyRoomName(dto.getStudyRoomName());
        studyRoom.setStudyRoomNumber(dto.getStudyRoomNumber());
        studyRoom.setLocation(dto.getLocation());

        studyRoomRepository.save(studyRoom);
        return studyRoom.getStudyRoomId();
    }

    public String deleteStudyRoomInfo(Integer id) {
        Optional<StudyRoom> opStudyRoom = studyRoomRepository.findById(id);
        if(opStudyRoom.isEmpty()) {
            throw new RuntimeException("잘못된 정보입니다.");
        }
        StudyRoom studyRoom = opStudyRoom.get();
        studyRoomRepository.delete(studyRoom);
        return "삭제되었습니다.";
    }

    //독서실 관리에서 일괄적으로 좌석을 추가하는 api
    public String addSeatsToStudyRoom(AddSeatsRequestDto dto) {
        StudyRoom studyRoom = studyRoomRepository.findByStudyRoomName(dto.getStudyRoomName());
        if (studyRoom == null) {
            throw new RuntimeException("잘못된 정보입니다.");
        }
        for(int i=1; i<=dto.getSeatCount(); i++) {
            Seats seats = new Seats();
            seats.setSeatNumber(i);
            seats.setStudyRoom(studyRoom);
            studyRoom.getSeatsList().add(seats);    //studyRoom 엔티티의 seatslist에 seats객체 add
        }
        studyRoomRepository.save(studyRoom);        //변경사항 업데이트
        return "입력되었습니다.";
    }
}
