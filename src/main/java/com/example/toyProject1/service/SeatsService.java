package com.example.toyProject1.service;

import com.example.toyProject1.controller.seats.dto.SeatsResponseDto;
import com.example.toyProject1.domain.seats.Seats;
import com.example.toyProject1.domain.seats.SeatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SeatsService {
    private final SeatsRepository seatsRepository;

    public SeatsService(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    public Seats findById(Integer seatsId) {
        Seats seats = seatsRepository.findById(seatsId).orElseThrow(()
        -> new IllegalArgumentException("없는 좌석 ID입니다."));
        return seats;
    }

    public List<SeatsResponseDto> findByStudyRoomId(Integer studyRoomId) {
        List<SeatsResponseDto> seatsList = seatsRepository.findByStudyRoom_studyRoomId(studyRoomId);
        return seatsList;
    }
    public Integer updateSeatsInfo(SeatsResponseDto dto){
        Integer seatsId = dto.getSeatsId();
        Optional<Seats> opSeats = seatsRepository.findById(seatsId);
        if(opSeats.isEmpty()){
            throw new RuntimeException("잘못된 정보입니다.");
        }
        Seats seats = opSeats.get();

        seats.setUsedStatus(dto.getUsedStatus());
        seats.setSeatNumber(dto.getSeatNumber());

        return seatsId;
    }

    public String deleteSeatsInfo(Integer id) {
        Optional<Seats> opSeats = seatsRepository.findById(id);
        if(opSeats.isEmpty()) {
            throw new RuntimeException("잘못된 정보입니다.");
        }
        Seats seats = opSeats.get();
        seatsRepository.delete(seats);
        return "삭제되었습니다.";
    }
}
