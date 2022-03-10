package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.users.Users;
import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {

//        @GetMapping("/hello/{userName}")
//        public ResponseEntity<Users> hello(@PathVariable String userName) {
//            return ResponseEntity.ok()
//                    .body(new Users(userName, "안녕하세요!"));
//        }

            @GetMapping("/hello/{userName}")
        public ResponseEntity<Users> hello(@PathVariable String userName) {
            return ResponseEntity.ok()
                    .body(new Users(userName, "안녕하세요!"));
        }
//
//    @PostMapping("/api/v1/posts")
//    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
//        return postsService.save(requestDto);
//    }
//    @PutMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
//        return postsService.update(id, requestDto);
//    }

}
