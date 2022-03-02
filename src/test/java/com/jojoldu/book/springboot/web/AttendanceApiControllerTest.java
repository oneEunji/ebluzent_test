//package com.jojoldu.book.springboot.web;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jojoldu.book.springboot.domain.attendance.Attendance;
//import com.jojoldu.book.springboot.domain.attendance.AttendanceRepository;
//import com.jojoldu.book.springboot.web.dto.attendance.AttendanceSaveRequestDto;
//import com.jojoldu.book.springboot.web.dto.attendance.AttendanceUpdateRequestDto;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//// For mockMvc
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class AttendanceApiControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        attendanceRepository.deleteAll();
//    }
//
//    @Test
//    @WithMockUser(roles="USER")
//    public void Attendance_등록된다() throws Exception {
//        //given
//        String title = "title";
//        String content = "content";
//        AttendanceSaveRequestDto requestDto = AttendanceSaveRequestDto.builder()
//                .title(title)
//                .content(content)
//                .author("author")
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/posts";
//
//        //when
//        mvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//        //then
//        List<Attendance> all = attendanceRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(title);
//        assertThat(all.get(0).getContent()).isEqualTo(content);
//    }
//
//    @Test
//    @WithMockUser(roles="USER")
//    public void Attendance_수정된다() throws Exception {
//        //given
//        Attendance savedAttendance = attendanceRepository.save(Attendance.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//
//        Long updateId = savedAttendance.getId();
//        String expectedTitle = "title2";
//        String expectedContent = "content2";
//
//        AttendanceUpdateRequestDto requestDto = AttendanceUpdateRequestDto.builder()
//                .id(id)
//                .attendanceOX(attendanceOX)
//                .attendanceDate(attendanceDate)
//                .attendanceTimeEnd(attendanceTimeEnd)
//                .attendanceTimeStart(attendanceTimeStart)
//                .attendanceTimeHours(attendanceTimeHours)
//                .attendanceAdressLatitude(attendanceAdressLatitude)
//                .attendanceAdressHardness(attendanceAdressHardness)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/attendance/" + updateId;
//
//        //when
//        mvc.perform(put(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//        //then
//        List<Attendance> all = attendanceRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
//    }
//}
