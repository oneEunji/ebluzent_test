package com.jojoldu.book.springboot.web.dto.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {

    private Long userNoId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String ssaId;
    private String userDept;
    private String userPosition;
    private int companyId;

    @Builder
    public UsersUpdateRequestDto(String userName, String userEmail, String userPassword,
                                 String ssaId,String userDept, String userPosition, int companyId) {

        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.ssaId = ssaId;
        this.userDept = userDept;
        this.userPosition = userPosition;
        this.companyId = companyId;

    }
}
