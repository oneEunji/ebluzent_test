package com.jojoldu.book.springboot.web.dto.users;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.users.Users;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class UsersListResponseDto {
    private Long userNoId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String ssaId;
    private String userDept;
    private String userPosition;
    private int companyId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public UsersListResponseDto(Users entity) {
        this.userNoId = entity.getUserNoId();
        this.userName = entity.getUserName();
        this.userEmail = entity.getUserEmail();
        this.userPassword = entity.getUserPassword();
        this.ssaId = entity.getSsaId();
        this.userDept = entity.getUserDept();
        this.userPosition = entity.getUserPosition();
        this.companyId = entity.getCompanyId();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
