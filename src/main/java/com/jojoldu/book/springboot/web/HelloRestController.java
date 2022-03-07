package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.users.Users;
import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

        @GetMapping("/hello/{userName}")
        public ResponseEntity<Users> hello(@PathVariable String userName) {
            return ResponseEntity.ok()
                    .body(new Users(userName, "안녕하세요!"));
        }
    }
