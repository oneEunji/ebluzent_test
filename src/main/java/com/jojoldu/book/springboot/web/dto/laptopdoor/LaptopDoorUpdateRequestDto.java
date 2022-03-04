package com.jojoldu.book.springboot.web.dto.laptopdoor;

import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class LaptopDoorUpdateRequestDto {
    private Long laptopDoorId;
    private Long userNoId;
    private String ssaId;
    private Date doorOpenTime;
    private int doorOpen;

    @Builder
    public LaptopDoorUpdateRequestDto(Long laptopDoorId, Long userNoId, String ssaId,
                                      Date doorOpenTime, int doorOpen) {
        this.laptopDoorId = laptopDoorId;
        this.userNoId = userNoId;
        this.ssaId = ssaId;
        this.doorOpenTime = doorOpenTime;
        this.doorOpen = doorOpen;

    }

    public LaptopDoor toEntity() {
        return LaptopDoor.builder()
                .userNoId(userNoId)
                .ssaId(ssaId)
                .doorOpenTime(doorOpenTime)
                .doorOpen(doorOpen)
                .build();
    }

}