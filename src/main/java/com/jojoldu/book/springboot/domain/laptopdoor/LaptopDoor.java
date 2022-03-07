package com.jojoldu.book.springboot.domain.laptopdoor;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class LaptopDoor extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopDoorId;

    @Column(length = 500, nullable = false)
    private int doorOpen;

    @Column(length = 500, nullable = false)
    private Long userNoId;

    @Column(length = 500, nullable = false)
    private String ssaId;

    @Column
    private Date doorOpenTime;

    @Builder
    public LaptopDoor(Long userNoId, String ssaId, Date doorOpenTime, int doorOpen) {

        this.userNoId = userNoId;
        this.ssaId = ssaId;
        this.doorOpenTime = doorOpenTime;
        this.doorOpen = doorOpen;
    }

    public void update(Long userNoId, String ssaId, Date doorOpenTime, int doorOpen) {

        this.userNoId = userNoId;
        this.ssaId = ssaId;
        this.doorOpenTime = doorOpenTime;
        this.doorOpen = doorOpen;
    }
}