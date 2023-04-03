package com.example.toyProject1.controller.studyRoom.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudyRoomResponseDto {
    private Integer studyRoomId;
    private String studyRoomName;
    private String studyRoomNumber;
    private String location;

    @Builder
    public StudyRoomResponseDto(Integer studyRoomId, String studyRoomName, String studyRoomNumber, String location) {
        this.studyRoomId = studyRoomId;
        this.studyRoomName = studyRoomName;
        this.studyRoomNumber = studyRoomNumber;
        this.location = location;
    }
}
