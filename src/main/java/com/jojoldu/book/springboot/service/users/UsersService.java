package com.jojoldu.book.springboot.service.users;

import com.jojoldu.book.springboot.domain.company.Company;
import com.jojoldu.book.springboot.domain.company.CompanyRepository;
import com.jojoldu.book.springboot.domain.users.Users;
import com.jojoldu.book.springboot.domain.users.UsersRepository;
import com.jojoldu.book.springboot.web.dto.company.CompanyListResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyResponseDto;
import com.jojoldu.book.springboot.web.dto.company.CompanySaveRequestDto;
import com.jojoldu.book.springboot.web.dto.company.CompanyUpdateRequestDto;
import com.jojoldu.book.springboot.web.dto.users.UsersListResponseDto;
import com.jojoldu.book.springboot.web.dto.users.UsersResponseDto;
import com.jojoldu.book.springboot.web.dto.users.UsersSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.users.UsersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getUserNoId();
    }

    @Transactional
    public Long update(Long userNoId, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(userNoId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. userNoId=" + userNoId));

        users.update(requestDto.getUserName(),requestDto.getUserEmail(),requestDto.getUserPassword()
                ,requestDto.getSsaId(),requestDto.getUserDept(),requestDto.getUserPosition(),requestDto.getCompanyId());

        return userNoId;
    }

    @Transactional
    public void delete (Long userNoId) {
        Users users = usersRepository.findById(userNoId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. userNoId=" + userNoId));

        usersRepository.delete(users);
    }

    @Transactional(readOnly = true)
    public UsersResponseDto findById(Long userNoId) {
        Users entity = usersRepository.findById(userNoId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. userNoId=" + userNoId));

        return new UsersResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<UsersListResponseDto> findAllDesc() {
        return usersRepository.findAllDesc().stream()
                .map(UsersListResponseDto::new)
                .collect(Collectors.toList());
    }
}
