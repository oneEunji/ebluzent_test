package com.jojoldu.book.springboot.web.dto.attendance;

import com.jojoldu.book.springboot.domain.attendance.Attendance;
import com.jojoldu.book.springboot.domain.company.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class AttendanceSaveRequestDto {

    private Long id;
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


    @Builder
    public AttendanceSaveRequestDto(Long id, Long deptId, Long companyBranchId, Long companyId,
                                    String attendanceOX, Date attendanceDate, String attendanceTimeEnd, String attendanceTimeStart,
                                    String attendanceTimeHours, Double attendanceAddressLatitude, Double attendanceAddressHardness) {
        this.id =  id;
        this.deptId =  deptId;
        this.companyBranchId = companyBranchId;
        this.companyId = companyId;
        this.attendanceOX = attendanceOX;
        this.attendanceDate =  attendanceDate;
        this.attendanceTimeEnd =  attendanceTimeEnd;
        this.attendanceTimeStart = attendanceTimeStart;
        this.attendanceTimeHours = attendanceTimeHours;
        this.attendanceAddressLatitude = attendanceAddressLatitude;
        this.attendanceAddressHardness = attendanceAddressHardness;

    }

    public Attendance toEntity() {
        return Attendance.builder()
                .id(id)
                .attendanceOX(attendanceOX)
                .attendanceDate(attendanceDate)
                .attendanceTimeEnd(attendanceTimeEnd)
                .attendanceTimeStart(attendanceTimeStart)
                .attendanceTimeHours(attendanceTimeHours)
                .attendanceAddressLatitude(attendanceAddressLatitude)
                .attendanceAddressHardness(attendanceAddressHardness)
                .build();
    }

}
