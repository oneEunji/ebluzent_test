package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.company.CompanyService;
import com.jojoldu.book.springboot.web.dto.company.CompanyListResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanySaveRequestDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompanyApiController {

    private final CompanyService companyService;

    @PostMapping("/company")
    public Long save(@RequestBody CompanySaveRequestDto requestDto) {
        return companyService.save(requestDto);
    }

    @PutMapping("/company/{companyId}")
    public Long update(@PathVariable Long companyId, @RequestBody CompanyUpdateRequestDto requestDto) {
        return companyService.update(companyId, requestDto);
    }
    @DeleteMapping("/company/{companyId}")
    public Long delete(@PathVariable Long companyId) {
        companyService.delete(companyId);
        return companyId;
    }

//    @GetMapping("/api/v1/company/{companyId}")
    @GetMapping("/company/{companyId}")
    public CompanyResponseDto findById(@PathVariable Long companyId) {
        return companyService.findById(companyId);
    }

//    @GetMapping("/api/v1/company/list")
    @GetMapping("/company/list")
    public List<CompanyListResponseDto> findAll() {
        return companyService.findAllDesc();
    }
}
