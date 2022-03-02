package com.jojoldu.book.springboot.web.dto.company;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanyUpdateRequestDto {
    private String companyName;
    private Double companyAddressLatitude;
    private Double companyAddressHardness;

    @Builder
    public CompanyUpdateRequestDto(String companyName, Double companyAddressLatitude, Double companyAddressHardness) {
        this.companyName = companyName;
        this.companyAddressLatitude = companyAddressLatitude;
        this.companyAddressHardness = companyAddressHardness;
    }
}
