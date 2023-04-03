package com.example.toyProject1.controller.studyRoom;

import com.example.toyProject1.controller.studyRoom.dto.AddSeatsRequestDto;
import com.example.toyProject1.controller.studyRoom.dto.StudyRoomRequestDto;
import com.example.toyProject1.controller.studyRoom.dto.StudyRoomResponseDto;
import com.example.toyProject1.domain.studyRoom.StudyRoomRepository;
import com.example.toyProject1.service.StudyRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudyRoomApiController {
    private final StudyRoomService studyRoomService;

    public StudyRoomApiController(StudyRoomService studyRoomService) {
        this.studyRoomService = studyRoomService;
    }

    @GetMapping("/api/studyRoom/read/{studyRoomId}")
    public StudyRoomResponseDto getStudyRoomInfoByStudyRoomId(@PathVariable Integer studyRoomId) {
        return studyRoomService.findByStudyRoomId(studyRoomId);
    }

    @GetMapping("/api/studyRoom/readAll")
    public List<StudyRoomRepository.StudyRoomInfoMapping> getAllStudyRoomLists() {
        return studyRoomService.findAllStudyRoomLists();
    }

    @PostMapping("/api/studyRoom/insert")
    public ResponseEntity<StudyRoomResponseDto> insertStudyRoomInfo (@RequestBody StudyRoomRequestDto studyRoomRequestDto) {
        StudyRoomResponseDto studyRoomResponseDto = studyRoomService.insertStudyRoomInfo(studyRoomRequestDto);
        return ResponseEntity.ok().body(studyRoomResponseDto);
    }

    @PostMapping("/api/studyRoom/addSeats")
    public String addSeatsToStudyRoom(@RequestBody AddSeatsRequestDto dto) {
        return studyRoomService.addSeatsToStudyRoom(dto);
    }

    @PostMapping("/api/studyRoom/update")
    public Integer updateStudyRoomInfo (@RequestBody StudyRoomResponseDto dto) {
        return studyRoomService.updateStudyRoomInfo(dto);
    }

    @PostMapping("/api/studyRoom/delete/{studyRoomId}")
    public String deleteStudyRoomInfo (@PathVariable Integer studyRoomId) {
        return studyRoomService.deleteStudyRoomInfo(studyRoomId);
    }
}
