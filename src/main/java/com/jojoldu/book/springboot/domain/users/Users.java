package com.jojoldu.book.springboot.domain.users;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
//import com.jojoldu.book.springboot.domain.user.Role;
//import com.jojoldu.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNoId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String ssaId;

    @Column(nullable = false)
    private String userDept;

    @Column(nullable = false)
    private String userPosition;

    @Column(nullable = false)
    private int companyId;

    @Builder
    public Users(String userName, String userEmail, String userPassword,
                 String ssaId,String userDept, String userPosition, int companyId) {

            this.userName = userName;
            this.userEmail = userEmail;
            this.userPassword = userPassword;
            this.ssaId = ssaId;
            this.userDept = userDept;
            this.userPosition = userPosition;
            this.companyId = companyId;

    }

    @Builder
    public Users(String userName, String userEmail) {

        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Users update(String userName, String userEmail, String userPassword,
                        String ssaId, String userDept, String userPosition, int companyId) {

        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.ssaId = ssaId;
        this.userDept = userDept;
        this.userPosition = userPosition;
        this.companyId = companyId;


        return this;
    }
}
