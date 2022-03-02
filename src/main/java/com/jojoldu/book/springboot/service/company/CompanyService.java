package com.jojoldu.book.springboot.service.company;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.company.CompanyRepository;
import com.jojoldu.book.springboot.web.dto.company.CompanyListResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanySaveRequestDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    public Long save(CompanySaveRequestDto requestDto) {
        return companyRepository.save(requestDto.toEntity()).getCompanyId();
    }

    @Transactional
    public Long update(Long companyId, CompanyUpdateRequestDto requestDto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사번호가 없습니다. companyId=" + companyId));

        company.update(requestDto.getCompanyName());

        return companyId;
    }

    @Transactional
    public void delete (Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사번호가 없습니다. companyId=" + companyId));

        companyRepository.delete(company);
    }

    @Transactional(readOnly = true)
    public CompanyResponseDto findById(Long companyId) {
        Company entity = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사번호가 없습니다. companyId=" + companyId));

        return new CompanyResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CompanyListResponseDto> findAllDesc() {
        return companyRepository.findAllDesc().stream()
                .map(CompanyListResponseDto::new)
                .collect(Collectors.toList());
    }
}
