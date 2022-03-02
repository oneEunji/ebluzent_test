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

    @PutMapping("/api/v1/attendance/{id}")
    public Long update(@PathVariable Long id, @RequestBody AttendanceUpdateRequestDto requestDto) {
        return attendanceService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/attendance/{id}")
    public Long delete(@PathVariable Long id) {
        attendanceService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/attendance/{id}")
    public AttendanceResponseDto findById(@PathVariable Long id) {
        return attendanceService.findById(id);
    }

    @GetMapping("/api/v1/attendance/list")
    public List<AttendanceListResponseDto> findAll() {
        return attendanceService.findAllDesc();
    }
}
