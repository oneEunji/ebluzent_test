package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.LaptopDoorService;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorListResponseDto;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorResponseDto;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LaptopDoorApiController {

    private final LaptopDoorService laptopdoorService;

    @PostMapping("/api/v1/laptopdoor")
    public Long save(@RequestBody LaptopDoorSaveRequestDto requestDto) {
        return laptopdoorService.save(requestDto);
    }

    @GetMapping("/api/v1/laptopdoor/{laptopDoorId}")
    public LaptopDoorResponseDto findById(@PathVariable Long laptopDoorId) {
        return laptopdoorService.findById(laptopDoorId);
    }

    @GetMapping("/api/v1/laptopdoor/list")
    public List<LaptopDoorListResponseDto> findAll() {
        return laptopdoorService.findAllDesc();
    }
}
