//package com.jojoldu.book.springboot.domain.companydept;
//
//
//import com.jojoldu.book.springboot.domain.companydept.CompanyDept;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface CompanyDeptRepository extends JpaRepository<CompanyDept, Long> {
//
//    @Query("SELECT cd FROM CompanyDept cd ORDER BY cd.id DESC")
//    List<CompanyDept> findAllDesc();
//
//
//}
