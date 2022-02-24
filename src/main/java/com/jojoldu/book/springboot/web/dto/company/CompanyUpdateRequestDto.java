package com.jojoldu.book.springboot.web.dto.company;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanyUpdateRequestDto {
    private String companyName;

    @Builder
    public CompanyUpdateRequestDto(String companyName) {
        this.companyName = companyName;
    }
}
