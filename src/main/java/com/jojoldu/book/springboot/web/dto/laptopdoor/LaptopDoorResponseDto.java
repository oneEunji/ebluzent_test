package com.jojoldu.book.springboot.web.dto.laptopdoor;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoor;
import lombok.Getter;

import java.sql.Date;

@Getter
public class LaptopDoorResponseDto {

    private Long laptopDoorId;
    private Long userNoId;
    private String ssaId;
    private Date doorOpenTime;
    private int doorOpen;


    public LaptopDoorResponseDto(LaptopDoor entity) {
        this.laptopDoorId = entity.getLaptopDoorId();
        this.userNoId = entity.getUserNoId();
        this.ssaId = entity.getSsaId();
        this.doorOpenTime = entity.getDoorOpenTime();
        this.doorOpen = entity.getDoorOpen();
    }
}