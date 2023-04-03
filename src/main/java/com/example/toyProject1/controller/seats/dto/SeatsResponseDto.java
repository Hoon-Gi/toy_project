package com.example.toyProject1.controller.seats.dto;

import com.example.toyProject1.domain.seats.SeatsRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class SeatsResponseDto {
    private Integer seatsId;
    private Integer usedStatus;
    private Integer seatNumber;

    @Builder
    public SeatsResponseDto(Integer seatsId, Integer usedStatus, Integer seatNumber) {
        this.seatsId = seatsId;
        this.usedStatus = usedStatus;
        this.seatNumber = seatNumber;
    }
}
