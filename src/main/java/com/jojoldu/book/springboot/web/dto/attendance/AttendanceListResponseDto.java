package com.jojoldu.book.springboot.web.dto.attendance;

import com.jojoldu.book.springboot.domain.attendance.Attendance;
import com.jojoldu.book.springboot.domain.company.Company;
import lombok.Getter;

import java.sql.Date;

@Getter
public class AttendanceListResponseDto {

    private Long id;
    private Long deptId;
    private Long companyBranchId;
    private Long companyId;
    private String attendanceOX;
    private Date attendanceDate;
    private String attendanceTimeEnd;
    private String attendanceTimeStart;
    private String attendanceTimeHours;
    private Double attendanceAdressLatitude;
    private Double attendanceAdressHardness;

    public AttendanceListResponseDto(Attendance entity) {
        this.id = entity.getId();
        this.deptId = entity.getDeptId();
        this.companyBranchId = entity.getCompanyBranchId();
        this.companyId = entity.getCompanyId();
        this.attendanceOX = entity.getAttendanceOX();
        this.attendanceDate = entity.getAttendanceDate();
        this.attendanceTimeEnd = entity.getAttendanceTimeEnd();
        this.attendanceTimeStart = entity.getAttendanceTimeStart();
        this.attendanceTimeHours = entity.getAttendanceTimeHours();
        this.attendanceAdressLatitude = entity.getAttendanceAdressLatitude();
        this.attendanceAdressHardness = entity.getAttendanceAdressHardness();
    }
}
