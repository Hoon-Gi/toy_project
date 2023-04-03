package com.example.toyProject1.domain.studyRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudyRoomRepository extends JpaRepository<StudyRoom,Integer> {

    public interface StudyRoomInfoMapping {
        Integer getStudyRoomId();
        String getStudyRoomName();
        String getStudyRoomNumber();
        String getLocation();
    }
    List<StudyRoomInfoMapping> findAllBy();

    StudyRoom findByStudyRoomName(String studyRoomName);

}
