package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoor;
import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoorRepository;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorListResponseDto;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorResponseDto;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorSaveRequestDto;
//import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LaptopDoorService {
    private final LaptopDoorRepository laptopDoorRepository;

    @Transactional
    public Long save(LaptopDoorSaveRequestDto requestDto) {
        return laptopDoorRepository.save(requestDto.toEntity()).getLaptopDoorId();
    }

//    @Transactional
//    public Long update(Long laptopDoorId, LaptopDoorUpdateRequestDto requestDto) {
//        LaptopDoor laptopDoor = LaptopDoorRepository.findById(laptopDoorId)
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + laptopDoorId));
//
////        laptopDoor.update(requestDto.getTitle(), requestDto.getContent());
//
//        return laptopDoorId;
//    }

//    @Transactional
//    public void delete (Long laptopDoorId) {
//        LaptopDoor laptopDoor = laptopDoorRepository.findById(laptopDoorId)
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + laptopDoorId));
//
//        laptopDoorRepository.delete(laptopDoor);
//    }

    @Transactional(readOnly = true)
    public LaptopDoorResponseDto findById(Long laptopDoorId) {
        LaptopDoor entity = laptopDoorRepository.findById(laptopDoorId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + laptopDoorId));

        return new LaptopDoorResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<LaptopDoorListResponseDto> findAllDesc() {
        return laptopDoorRepository.findAllDesc().stream()
                .map(LaptopDoorListResponseDto::new)
                .collect(Collectors.toList());
    }
}
