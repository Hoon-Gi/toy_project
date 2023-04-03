package com.example.toyProject1.controller.studyRoom.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AddSeatsRequestDto {
    private String studyRoomName;
    private Integer seatCount;

    @Builder
    public AddSeatsRequestDto(String studyRoomName, Integer seatCount) {
        this.studyRoomName = studyRoomName;
        this.seatCount = seatCount;
    }
}
