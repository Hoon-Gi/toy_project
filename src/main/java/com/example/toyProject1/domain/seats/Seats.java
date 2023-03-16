package com.example.toyProject1.domain.seats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.toyProject1.domain.studyRoom.StudyRoom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatsId;

    @Column
    private Integer usedStatus;

    @Column
    private Integer seatNumber;

    @ManyToOne
    private StudyRoom studyRoom;
}
