package com.example.toyProject1.domain.studyRoom;

import java.util.List;

import javax.persistence.*;

import com.example.toyProject1.domain.seats.Seats;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany(mappedBy = "studyRoom", cascade = CascadeType.REMOVE)
    private List<Seats> seatsList;
}
