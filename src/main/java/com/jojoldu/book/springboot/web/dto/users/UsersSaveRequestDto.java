package com.jojoldu.book.springboot.web.dto.users;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {

    private Long userNoId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String ssaId;
    private String userDept;
    private String userPosition;
    private int companyId;

    @Builder
    public UsersSaveRequestDto(Long userNoId, String userName, String userEmail, String userPassword,
                               String ssaId,String userDept, String userPosition, int companyId) {

        this.userNoId = userNoId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.ssaId = ssaId;
        this.userDept = userDept;
        this.userPosition = userPosition;
        this.companyId = companyId;

    }

    public Users toEntity() {
        return Users.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .ssaId(ssaId)
                .userDept(userDept)
                .userPosition(userPosition)
                .companyId(companyId)
                .build();
    }

}
