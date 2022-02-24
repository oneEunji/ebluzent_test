package com.jojoldu.book.springboot.domain.company;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Company extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(length = 500, nullable = false)
    private String companyName;


    @Builder
    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void update(String companyName) {
        this.companyName = companyName;
    }
}
