package com.jojoldu.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoor;
import com.jojoldu.book.springboot.domain.laptopdoor.LaptopDoorRepository;
import com.jojoldu.book.springboot.web.dto.laptopdoor.LaptopDoorSaveRequestDto;
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

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// For mockMvc

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaptopDoorApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LaptopDoorRepository laptopdoorRepository;

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
        laptopdoorRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void LaptopDoor_등록된다() throws Exception {
        //given
        int doorOpen = 0;
        Date doorOpenTime = null;
        Long userNoId = 1L;
        String ssaId = "ssaId";

        LaptopDoorSaveRequestDto requestDto = LaptopDoorSaveRequestDto.builder()
                .userNoId(userNoId)
                .ssaId(ssaId)
                .doorOpenTime(doorOpenTime)
                .doorOpen(doorOpen)
                .build();

        String url = "http://localhost:" + port + "/api/v1/laptopdoor";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<LaptopDoor> all = laptopdoorRepository.findAll();
        assertThat(all.get(0).getUserNoId()).isEqualTo(userNoId);
        assertThat(all.get(0).getSsaId()).isEqualTo(ssaId);
        assertThat(all.get(0).getDoorOpenTime()).isEqualTo(doorOpenTime);
        assertThat(all.get(0).getDoorOpen()).isEqualTo(doorOpen);
    }
}
