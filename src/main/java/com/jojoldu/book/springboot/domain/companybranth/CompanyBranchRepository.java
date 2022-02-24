package com.jojoldu.book.springboot.domain.companybranth;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyBranchRepository extends JpaRepository<CompanyBranch, Long> {

    @Query("SELECT cb FROM CompanyBranch cb ORDER BY cb.companyId DESC")
    List<CompanyBranch> findAllDesc();


}
