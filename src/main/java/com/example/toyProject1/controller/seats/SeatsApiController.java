package com.example.toyProject1.controller.seats;

import com.example.toyProject1.controller.seats.dto.SeatsResponseDto;
import com.example.toyProject1.domain.seats.Seats;
import com.example.toyProject1.service.SeatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SeatsApiController {

    private final SeatsService seatsService;

    public SeatsApiController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    //독서실에 포함된 모든 좌석 List 출력
    @GetMapping("/api/seats/readAll/{studyRoomId}")
    public List<SeatsResponseDto> findAllByStudyRoomId (@PathVariable Integer studyRoomId) {
        return seatsService.findByStudyRoomId(studyRoomId);
    }

    //좌석정보 수정
    @PostMapping("/api/seats/update")
    public Integer updateSeatsInfo(@RequestBody SeatsResponseDto dto) {
        return seatsService.updateSeatsInfo(dto);
    }

    @PostMapping("/api/seats/delete/{seatsId}")
    public String deleteSeatsInfo (@PathVariable Integer seatsId) {
        return seatsService.deleteSeatsInfo(seatsId);
    }

}
