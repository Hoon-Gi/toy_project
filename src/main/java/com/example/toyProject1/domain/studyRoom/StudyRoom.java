package com.example.toyProject1.domain.studyRoom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.toyProject1.domain.seats.Seats;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Entity
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studyRoomId;

    @Column
    private String studyRoomName;
    @Column
    private String studyRoomNumber;
    @Column
    private String location;

    @OneToMany(mappedBy = "studyRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    @Singular
    private List<Seats> seatsList = new ArrayList<>();

    public StudyRoom() {

    }
    @Builder
    public StudyRoom (String studyRoomName, String studyRoomNumber, String location, List<Seats> seatsList) {
        this.studyRoomName = studyRoomName;
        this.studyRoomNumber = studyRoomNumber;
        this.location = location;
        this.seatsList = seatsList;
    }

    public List<Seats> getSeatsList() {
        return seatsList;
    }
}
