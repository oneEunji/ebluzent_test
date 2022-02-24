package com.jojoldu.book.springboot.web.dto.company;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CompanyListResponseDto {
    private Long companyId;
    private String companyName;

    public CompanyListResponseDto(Company entity) {
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
    }
}
