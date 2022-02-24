package com.jojoldu.book.springboot.domain.company;

import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c ORDER BY c.companyId DESC")
    List<Company> findAllDesc();


}
