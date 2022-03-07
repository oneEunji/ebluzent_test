//package com.jojoldu.book.springboot.web;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jojoldu.book.springboot.domain.attendance.Attendance;
//import com.jojoldu.book.springboot.domain.attendance.AttendanceRepository;
//import com.jojoldu.book.springboot.web.dto.attendance.AttendanceSaveRequestDto;
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
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
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
//    @WithMockUser(roles = "USER")
//    public void Attendance_등록된다() throws Exception {
//        //given
//        Long userNoId = 1L;
//        Long deptId = 1L;
//        Long companyBranchId = 1L;
//        Long companyId = 1L;
//        String attendanceOX = "attendanceOX";
//        LocalDateTime attendanceDate = null;
////        Date attendanceDate = Date.valueOf(dateByAttendence);
//        String attendanceTimeEnd = "attendanceTimeEnd";
//        String attendanceTimeStart = "attendanceTimeStart";
//        String attendanceTimeHours = "attendanceTimeHours";
//        Double attendanceAddressLatitude = 1.1;
//        Double attendanceAddressHardness = 2.1;
//
//        AttendanceSaveRequestDto requestDto = AttendanceSaveRequestDto.builder()
//                .userNoId(userNoId)
//                .deptId(deptId)
//                .companyBranchId(companyBranchId)
//                .companyId(companyId)
//                .attendanceOX(attendanceOX)
//                .attendanceDate(attendanceDate)
//                .attendanceTimeEnd(attendanceTimeEnd)
//                .attendanceTimeEnd(attendanceTimeEnd)
//                .attendanceTimeStart(attendanceTimeStart)
//                .attendanceTimeHours(attendanceTimeHours)
//                .attendanceAddressLatitude(attendanceAddressLatitude)
//                .attendanceAddressHardness(attendanceAddressHardness)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/attendance";
//
//        //when
//        mvc.perform(post(url)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//        //then
//        List<Attendance> all = attendanceRepository.findAll();
//        assertThat(all.get(0).getUserNoId()).isEqualTo(userNoId);
//        assertThat(all.get(0).getDeptId()).isEqualTo(deptId);
//        assertThat(all.get(0).getCompanyBranchId()).isEqualTo(companyBranchId);
//        assertThat(all.get(0).getCompanyId()).isEqualTo(companyId);
//        assertThat(all.get(0).getAttendanceOX()).isEqualTo(attendanceOX);
//        assertThat(all.get(0).getAttendanceDate()).isEqualTo(attendanceDate);
//        assertThat(all.get(0).getAttendanceTimeEnd()).isEqualTo(attendanceTimeEnd);
//        assertThat(all.get(0).getAttendanceTimeStart()).isEqualTo(attendanceTimeStart);
//        assertThat(all.get(0).getAttendanceTimeHours()).isEqualTo(attendanceTimeHours);
//        assertThat(all.get(0).getAttendanceAddressLatitude()).isEqualTo(attendanceAddressLatitude);
//        assertThat(all.get(0).getAttendanceAddressHardness()).isEqualTo(attendanceAddressHardness);
//    }
//
////    @Test
////    @WithMockUser(roles = "USER")
////    public void Attendance_수정된다() throws Exception {
////        //given
////        Attendance savedAttendance = attendancRepository.save(Attendance.builder()
////                .userNoId(null)
////                .attendanceOX("attendanceOX")
////                .attendanceDate(null)
////                .attendanceTimeEnd("attendanceTimeEnd")
////                .attendanceTimeEnd("attendanceTimeEnd")
////                .attendanceTimeStart("attendanceTimeStart")
////                .attendanceTimeHours("attendanceTimeHours")
////                .attendanceAddressLatitude(1.1)
////                .attendanceAddressHardness(2.1)
////                .build());
////
////        Long updateId = savedAttendance.getAttendanceId();
////        //given
////        Long userNoId = null;
////        String attendanceOX = "attendanceOX";
////        Date attendanceDate = null;
////        String attendanceTimeEnd = "attendanceTimeEnd";
////        String attendanceTimeStart = "attendanceTimeStart";
////        String attendanceTimeHours = "attendanceTimeHours";
////        Double attendanceAddressLatitude = 1.1;
////        Double attendanceAddressHardness = 2.1;
////
////        AttendanceUpdateRequestDto requestDto = AttendanceUpdateRequestDto.builder()
////                .userNoId(userNoId)
////                .attendanceOX(attendanceOX)
////                .attendanceDate(attendanceDate)
////                .attendanceTimeEnd(attendanceTimeEnd)
////                .attendanceTimeEnd(attendanceTimeEnd)
////                .attendanceTimeStart(attendanceTimeStart)
////                .attendanceTimeHours(attendanceTimeHours)
////                .attendanceAddressLatitude(attendanceAddressLatitude)
////                .attendanceAddressHardness(attendanceAddressHardness)
////                .build();
////
////        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
////
////        //when
////        mvc.perform(put(url)
////                        .contentType(MediaType.APPLICATION_JSON_UTF8)
////                        .content(new ObjectMapper().writeValueAsString(requestDto)))
////                .andExpect(status().isOk());
////
////        //then
////        List<Attendance> all = attendancRepository.findAll();
////        assertThat(all.get(0).getUserNoId()).isEqualTo(userNoId);
////        assertThat(all.get(0).getAttendanceOX()).isEqualTo(attendanceOX);
////        assertThat(all.get(0).getAttendanceDate()).isEqualTo(attendanceDate);
////        assertThat(all.get(0).getAttendanceTimeEnd()).isEqualTo(attendanceTimeEnd);
////        assertThat(all.get(0).getAttendanceTimeStart()).isEqualTo(attendanceTimeStart);
////        assertThat(all.get(0).getAttendanceTimeHours()).isEqualTo(attendanceTimeHours);
////        assertThat(all.get(0).getAttendanceAddressLatitude()).isEqualTo(attendanceAddressLatitude);
////        assertThat(all.get(0).getAttendanceAddressHardness()).isEqualTo(attendanceAddressHardness);
////    }
//}
////출근시간,출근 위치 퇴근시간 퇴근 위치