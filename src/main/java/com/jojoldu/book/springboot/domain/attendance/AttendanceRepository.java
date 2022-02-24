package com.jojoldu.book.springboot.domain.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT a FROM Attendance a ORDER BY a.attendanceId DESC")
    List<Attendance> findAllDesc();


}
