package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.attendance.AttendanceService;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceListResponseDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceResponseDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainApiController {

}
//1. companyid로 companyname받아오기, 2.attendance위치가 company랑 다를 때 위치 좌표찍어오기.