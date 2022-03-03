package com.jojoldu.book.springboot.web.dto.attendance;

import com.jojoldu.book.springboot.domain.attendance.Attendance;
import lombok.Getter;

import java.sql.Date;

@Getter
public class AttendanceResponseDto {

    private Long userNoId;
    private Long deptId;
    private Long companyBranchId;
    private Long companyId;
    private String attendanceOX;
    private Date attendanceDate;
    private String attendanceTimeEnd;
    private String attendanceTimeStart;
    private String attendanceTimeHours;
    private Double attendanceAddressLatitude;
    private Double attendanceAddressHardness;

    public AttendanceResponseDto(Attendance entity) {
        this.userNoId = entity.getUserNoId();
        this.deptId = entity.getDeptId();
        this.companyBranchId = entity.getCompanyBranchId();
        this.companyId = entity.getCompanyId();
        this.attendanceOX = entity.getAttendanceOX();
        this.attendanceDate = entity.getAttendanceDate();
        this.attendanceTimeEnd = entity.getAttendanceTimeEnd();
        this.attendanceTimeStart = entity.getAttendanceTimeStart();
        this.attendanceTimeHours = entity.getAttendanceTimeHours();
        this.attendanceAddressLatitude = entity.getAttendanceAddressLatitude();
        this.attendanceAddressHardness = entity.getAttendanceAddressHardness();
    }
}
