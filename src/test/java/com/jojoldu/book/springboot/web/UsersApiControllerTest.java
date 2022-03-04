package com.jojoldu.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.book.springboot.domain.users.Users;
import com.jojoldu.book.springboot.domain.users.UsersRepository;
import com.jojoldu.book.springboot.web.dto.users.UsersSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.users.UsersUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// For mockMvc

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        usersRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void Users_save() throws Exception {

        //given
        String userName = "userName";
        String userEmail = "userEmail";
        String userPassword = "userPassword";
        String ssaId = "ssaId";
        String userDept = "userDept";
        String userPosition = "userPosition";
        int companyId = 12;

        UsersSaveRequestDto requestDto = UsersSaveRequestDto.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .ssaId(ssaId)
                .userDept(userDept)
                .userPosition(userPosition)
                .companyId(companyId)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getUserName()).isEqualTo(userName);
        assertThat(all.get(0).getUserEmail()).isEqualTo(userEmail);
        assertThat(all.get(0).getUserPassword()).isEqualTo(userPassword);
        assertThat(all.get(0).getSsaId()).isEqualTo(ssaId);
        assertThat(all.get(0).getUserDept()).isEqualTo(userDept);
        assertThat(all.get(0).getUserPosition()).isEqualTo(userPosition);
        assertThat(all.get(0).getCompanyId()).isEqualTo(companyId);
    }

    @Test
    @WithMockUser(roles="USER")
    public void Users_update() throws Exception {
        //given
        Users savedUsers = usersRepository.save(Users.builder()
                .userName("userName")
                .userEmail("userEmail")
                .userPassword("userPassword")
                .ssaId("ssaId")
                .userDept("userDept")
                .userPosition("userPosition")
                .companyId(123)
                .build());

        Long updateId = savedUsers.getUserNoId();
        String expectedUserName = "userName";
        String expectedUserEmail = "userEmail";
        String expectedUserPassword = "userPassword";
        String expectedSsaId = "ssaId";
        String expectedUserDept = "userDept";
        String expectedUserPosition = "userPosition";
        int expectedCompanyId = 12;

        UsersUpdateRequestDto requestDto = UsersUpdateRequestDto.builder()
                .userName(expectedUserName)
                .userEmail(expectedUserEmail)
                .userPassword(expectedUserPassword)
                .ssaId(expectedSsaId)
                .userDept(expectedUserDept)
                .userPosition(expectedUserPosition)
                .companyId(expectedCompanyId)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users/" + updateId;

        //when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getUserName()).isEqualTo(expectedUserName);
        assertThat(all.get(0).getUserEmail()).isEqualTo(expectedUserEmail);
        assertThat(all.get(0).getUserPassword()).isEqualTo(expectedUserPassword);
        assertThat(all.get(0).getSsaId()).isEqualTo(expectedSsaId);
        assertThat(all.get(0).getUserDept()).isEqualTo(expectedUserDept);
        assertThat(all.get(0).getUserPosition()).isEqualTo(expectedUserPosition);
        assertThat(all.get(0).getCompanyId()).isEqualTo(expectedCompanyId);
    }
}
