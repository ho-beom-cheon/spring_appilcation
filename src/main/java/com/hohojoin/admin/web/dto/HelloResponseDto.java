package com.hohojoin.admin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 선언된 모든 필드의 get 메소드를 생성해준다.
@Getter
// 선언된 모든 final 필드가 포함된 생성자를 생성해준다.(final이 없는 필드는 미포함)
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;


}
