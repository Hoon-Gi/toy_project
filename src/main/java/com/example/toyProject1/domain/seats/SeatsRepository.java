package com.example.toyProject1.domain.seats;

import com.example.toyProject1.controller.seats.dto.SeatsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatsRepository extends JpaRepository<Seats,Integer> {
    List<SeatsResponseDto> findByStudyRoom_studyRoomId(Integer studyRoomId);
}
