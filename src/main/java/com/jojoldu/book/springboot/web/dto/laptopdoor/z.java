//package com.jojoldu.book.springboot.web.dto.laptopdoor;
//
//import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.sql.Date;
//@Getter
//@NoArgsConstructor
//
//public class LaptopdoorSaveRequestDto {
//    private Long userNoId;
//    private String ssaId;
//    private Long deptId;
//    private Long companyBranchID;
//    private Long companyId;
//    private Date doorOpenTime;
//    private Long doorOpen;
//
//    @Builder
//    public LaptopdoorUpdateRequestDto(Long laptopDoorId, Long userNoId, String ssaId, Long deptId, Long companyBranchID,
//                                      Long companyId, Date doorOpenTime, Long doorOpen) {
//        this.laptopDoorId = laptopDoorId;
//        this.userNoId = userNoId;
//        this.ssaId = ssaId;
//        this.deptId = deptId;
//        this.companyBranchID = companyBranchID;
//        this.companyId = companyId;
//        this.doorOpenTime = doorOpenTime;
//        this.doorOpen = doorOpen;
//
//    }
//
//    public LaptopDoor toEntity() {
//        return LaptopDoor.builder()
//                .userNoID(userNoID)
//                .SSAID(SSAID)
//                .deptId(deptId)
//                .companyBranchID(companyBranchID)
//                .companyId(companyId)
//                .doorOpenTime(doorOpenTime)
//                .doorOpen(doorOpen)
//                .build();
//    }
//
//}