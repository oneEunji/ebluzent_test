package com.jojoldu.book.springboot.web.dto.company;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanySaveRequestDto {
    private String companyName;

    @Builder
    public CompanySaveRequestDto(String companyName) {
        this.companyName = companyName;

    }

    public Company toEntity() {
        return Company.builder()
                .companyName(companyName)
                .build();
    }

}
