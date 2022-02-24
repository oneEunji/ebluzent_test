package com.jojoldu.book.springboot.web.dto.attendance;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class AttendanceUpdateRequestDto {
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

    @Builder
    public AttendanceUpdateRequestDto(Long id, Long deptId, Long companyBranchId, Long companyId,
                                      String attendanceOX, Date attendanceDate, String attendanceTimeEnd, String attendanceTimeStart,
                                      String attendanceTimeHours, Double attendanceAdressLatitude, Double attendanceAdressHardness) {
        this.id =  id;
        this.deptId =  deptId;
        this.companyBranchId = companyBranchId;
        this.companyId = companyId;
        this.attendanceOX = attendanceOX;
        this.attendanceDate =  attendanceDate;
        this.attendanceTimeEnd =  attendanceTimeEnd;
        this.attendanceTimeStart = attendanceTimeStart;
        this.attendanceTimeHours = attendanceTimeHours;
        this.attendanceAdressLatitude = attendanceAdressLatitude;
        this.attendanceAdressHardness = attendanceAdressHardness;
    }
}
