package com.jojoldu.book.springboot.web.dto.company;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class CompanyResponseDto {

    private Long companyId;
    private String companyName;


    public CompanyResponseDto(Company entity) {
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();

    }
}
