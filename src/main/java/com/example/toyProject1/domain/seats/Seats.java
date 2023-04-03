package com.example.toyProject1.domain.seats;

import javax.persistence.*;

import com.example.toyProject1.domain.studyRoom.StudyRoom;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatsId;

    @ColumnDefault("0")
    private Integer usedStatus;

    @Column
    private Integer seatNumber;

    @ManyToOne
    @JoinColumn(name = "study_room_id")
    private StudyRoom studyRoom;

    @PrePersist
    private void setDefault() {
        if(this.usedStatus == null) {
            this.usedStatus = 0;
        }
    }
}
