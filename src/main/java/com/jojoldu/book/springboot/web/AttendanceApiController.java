package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.service.attendance.AttendanceService;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceListResponseDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceResponseDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AttendanceApiController {

    private final AttendanceService attendanceService;

    @PostMapping("/api/v1/attendance")
    public Long save(@RequestBody AttendanceSaveRequestDto requestDto) {
        return attendanceService.save(requestDto);
    }

    @PutMapping("/api/v1/attendance/{attendanceId}")
    public Long update(@PathVariable Long attendanceId, @RequestBody AttendanceUpdateRequestDto requestDto) {
        return attendanceService.update(attendanceId, requestDto);
    }

//    @DeleteMapping("/api/v1/attendance/{attendanceId}")
//    public Long delete(@PathVariable Long attendanceId) {
//        attendanceService.delete(attendanceId);
//        return attendanceId;
//    }

    @GetMapping("/api/v1/attendance/{attendanceId}")
    public AttendanceResponseDto findById(@PathVariable Long attendanceId) {
        return attendanceService.findById(attendanceId);
    }

    @GetMapping("/api/v1/attendance/list")
    public List<AttendanceListResponseDto> findAll() {
        return attendanceService.findAllDesc();
    }
}
