package com.jojoldu.book.springboot.service.attendance;

import com.jojoldu.book.springboot.domain.attendance.Attendance;
import com.jojoldu.book.springboot.domain.attendance.AttendanceRepository;
import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.company.CompanyRepository;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceListResponseDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceResponseDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.attendance.AttendanceUpdateRequestDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyListResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanySaveRequestDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Transactional
    public Long save(AttendanceSaveRequestDto requestDto) {
        return attendanceRepository.save(requestDto.toEntity()).getAttendanceId();
    }

    @Transactional
    public Long update(Long attendanceId, AttendanceUpdateRequestDto requestDto) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new IllegalArgumentException("해당 순번이 없습니다. no=" + attendanceId));

//        attendance.update(requestDto.getAttendanceTimeStart());

        return attendanceId;
    }

    @Transactional
    public void delete (Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new IllegalArgumentException("해당 순번이 없습니다. no=" + attendanceId));

        attendanceRepository.delete(attendance);
    }

    @Transactional(readOnly = true)
    public AttendanceResponseDto findById(Long attendanceId) {
        Attendance entity = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new IllegalArgumentException("해당 순번이 없습니다. no=" + attendanceId));

        return new AttendanceResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<AttendanceListResponseDto> findAllDesc() {
        return attendanceRepository.findAllDesc().stream()
                .map(AttendanceListResponseDto::new)
                .collect(Collectors.toList());
    }
}
