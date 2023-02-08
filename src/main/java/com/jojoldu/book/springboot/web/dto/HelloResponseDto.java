package com.jojoldu.book.springboot.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Data
public class HelloResponseDto {

    private final String name;
    private final int amount;

}