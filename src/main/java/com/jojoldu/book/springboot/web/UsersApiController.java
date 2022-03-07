package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.users.Users;
import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.service.users.UsersService;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import com.jojoldu.book.springboot.web.dto.users.UsersListResponseDto;
import com.jojoldu.book.springboot.web.dto.users.UsersResponseDto;
import com.jojoldu.book.springboot.web.dto.users.UsersSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.users.UsersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @PutMapping("/api/v1/users/{userNoId}")
    public Long update(@PathVariable Long userNoId, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(userNoId, requestDto);
    }

    @DeleteMapping("/api/v1/users/{userNoId}")
    public Long delete(@PathVariable Long userNoId) {
        usersService.delete(userNoId);
        return userNoId;
    }

    @GetMapping("/api/v1/users/{userNoId}")
    public UsersResponseDto findById(@PathVariable Long userNoId) {
        return usersService.findById(userNoId);
    }

    @GetMapping("/api/v1/users/list")
    public List<UsersListResponseDto> findAll() {
        return usersService.findAllDesc();
    }
}
