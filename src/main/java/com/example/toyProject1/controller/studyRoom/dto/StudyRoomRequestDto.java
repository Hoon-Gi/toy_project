package com.example.toyProject1.controller.studyRoom.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StudyRoomRequestDto {
    private String studyRoomName;
    private String studyRoomNumber;
    private String location;

    @Builder
    public StudyRoomRequestDto (String studyRoomName, String studyRoomNumber, String location) {
        this.studyRoomName = studyRoomName;
        this.studyRoomNumber = studyRoomNumber;
        this.location = location;
    }
}
