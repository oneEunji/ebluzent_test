package com.jojoldu.book.springboot.domain.company;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long companyId;

    @Column(length = 500, nullable = false)
    private String companyName;

    @Column(nullable = false)
    private Double companyAddressLatitude;

    @Column(nullable = false)
    private Double companyAddressHardness;

    @Builder
    public Company(String companyName, Double companyAddressLatitude, Double companyAddressHardness) {
        this.companyName = companyName;
        this.companyAddressLatitude = companyAddressLatitude;
        this.companyAddressHardness = companyAddressHardness;
    }

    public void update(String companyName, Double companyAddressLatitude, Double companyAddressHardness) {
        this.companyName = companyName;
        this.companyAddressLatitude = companyAddressLatitude;
        this.companyAddressHardness = companyAddressHardness;
    }
}
