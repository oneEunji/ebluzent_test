package com.jojoldu.book.springboot.domain.companybranth;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_company_branch")
public class CompanyBranch extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyBrannchId;

    @Column(length = 500, nullable = false)
    private Long companyId;

    @Column(length = 500, nullable = false)
    private String companyBranchName;


    @Builder
    public CompanyBranch(Long companyId, String companyBranchName) {
        this.companyId = companyId;
        this.companyBranchName = companyBranchName;
    }

    public void update(Long companyId, String companyBranchName) {
        this.companyId = companyId;
        this.companyBranchName = companyBranchName;
    }
}
