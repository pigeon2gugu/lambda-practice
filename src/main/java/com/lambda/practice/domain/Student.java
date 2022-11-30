package com.lambda.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String name;
    private boolean isLikeAlgorithm;
    private boolean isLikeSpringBoot;
}
