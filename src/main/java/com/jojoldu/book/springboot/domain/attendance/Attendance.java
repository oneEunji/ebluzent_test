package com.jojoldu.book.springboot.domain.attendance;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Attendance extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @Column(length = 500, nullable = false)
    private Long userNoId;

    @Column(length = 500, nullable = false)
    private Long deptId;

    @Column(length = 500, nullable = false)
    private Long companyBranchId;

    @Column(length = 500, nullable = false)
    private Long companyId;

    @Column(length = 500, nullable = false)
    private String attendanceOX;

    @Column
    private LocalDateTime attendanceDate;

    @Column(length = 500, nullable = false)
    private String attendanceTimeEnd;

    @Column(length = 500, nullable = false)
    private String attendanceTimeStart;

    @Column(length = 500, nullable = false)
    private String attendanceTimeHours;

    @Column(length = 500, nullable = false)
    private Double attendanceAddressLatitude;

    @Column(length = 500, nullable = false)
    private Double attendanceAddressHardness;

    @Builder
    public Attendance(Long userNoId, String attendanceOX, LocalDateTime attendanceDate, String attendanceTimeEnd, String attendanceTimeStart,
                      String attendanceTimeHours, Double attendanceAddressLatitude, Double attendanceAddressHardness){
        this.userNoId = userNoId;
        this.attendanceOX = attendanceOX;
        this.attendanceDate = attendanceDate;
        this.attendanceTimeEnd = attendanceTimeEnd;
        this.attendanceTimeStart = attendanceTimeStart;
        this.attendanceTimeHours = attendanceTimeHours;
        this.attendanceAddressLatitude = attendanceAddressLatitude;
        this.attendanceAddressHardness = attendanceAddressHardness;
    }

    public void update(Long userNoId,String attendanceOX,LocalDateTime attendanceDate,String attendanceTimeEnd,String attendanceTimeStart,
                       String attendanceTimeHours,Double attendanceAddressLatitude,Double attendanceAddressHardness){
        this.userNoId = userNoId;
        this.attendanceOX = attendanceOX;
        this.attendanceDate = attendanceDate;
        this.attendanceTimeEnd = attendanceTimeEnd;
        this.attendanceTimeStart = attendanceTimeStart;
        this.attendanceTimeHours = attendanceTimeHours;
        this.attendanceAddressLatitude = attendanceAddressLatitude;
        this.attendanceAddressHardness = attendanceAddressHardness;

    }
}
