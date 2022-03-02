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
        return attendanceRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, AttendanceUpdateRequestDto requestDto) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

//        attendance.update(requestDto.getAttendanceOX());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        attendanceRepository.delete(attendance);
    }

    @Transactional(readOnly = true)
    public AttendanceResponseDto findById(Long id) {
        Attendance entity = attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new AttendanceResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<AttendanceListResponseDto> findAllDesc() {
        return attendanceRepository.findAllDesc().stream()
                .map(AttendanceListResponseDto::new)
                .collect(Collectors.toList());
    }
}
