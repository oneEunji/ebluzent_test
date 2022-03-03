package com.jojoldu.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.company.CompanyRepository;
import com.jojoldu.book.springboot.web.dto.company.CompanySaveRequestDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
//import org.springframework.restdocs.JUnitRestDocumentation;
//import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// For mockMvc

@RunWith(SpringRunner.class)
//@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private WebApplicationContext context;


    private MockMvc mvc;

//    @Rule
//    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
//
    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

//    @Before
//    public void setUp() {
//        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
//                .apply(documentationConfiguration(this.restDocumentation))
//                .build();
//    }

    @After
    public void tearDown() throws Exception {
        companyRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void Company_save() throws Exception {
        //given
        String companyName = "companyName";
        Double companyAddressLatitude = 1.1;
        Double companyAddressHardness = 2.2;

        CompanySaveRequestDto requestDto = CompanySaveRequestDto.builder()
                .companyName(companyName)
                .companyAddressLatitude(companyAddressLatitude)
                .companyAddressHardness(companyAddressHardness)
                .build();

        String url = "http://localhost:" + port + "/api/v1/company";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Company> all = companyRepository.findAll();
        assertThat(all.get(0).getCompanyName()).isEqualTo(companyName);
    }

    @Test
//    @WithMockUser(roles="USER")
    public void Company_update() throws Exception {
        //given
        Company savedCompany;
        savedCompany = companyRepository.save(Company.builder()
                .companyName("companyName")
                .companyAddressLatitude(1.1)
                .companyAddressHardness(2.2)
                .build());


        Long updateId = savedCompany.getCompanyId();

        String companyName = "companyName";
        Double companyAddressLatitude = 1.1;
        Double companyAddressHardness = 2.2;

        CompanyUpdateRequestDto requestDto;
        requestDto = CompanyUpdateRequestDto.builder()
                .companyName(companyName)
                .companyAddressLatitude(companyAddressLatitude)
                .companyAddressHardness(companyAddressHardness)
                .build();

        String url = "http://localhost:" + port + "/api/v1/company/" + updateId;

        //when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
//        //when
//        mvc.perform(put(url)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .content(new ObjectMapper().writeValueAsString(requestDto)))
//
//                .andExpect(status().isOk());


        //then
        List<Company> all = companyRepository.findAll();
        assertThat(all.get(0).getCompanyName()).isEqualTo(companyName);
        assertThat(all.get(0).getCompanyAddressLatitude()).isEqualTo(1.1);
        assertThat(all.get(0).getCompanyAddressHardness()).isEqualTo(1.1);
    }
}
