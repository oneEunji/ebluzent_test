package com.jojoldu.book.springboot.web.dto.laptopdoor;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class LaptopDoorSaveRequestDto {
    private Long userNoId;
    private String ssaId;
    private Date doorOpenTime;
    private int doorOpen;

    @Builder
    public LaptopDoorSaveRequestDto(Long userNoId, String ssaId,
                                    Date doorOpenTime, int doorOpen) {

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
