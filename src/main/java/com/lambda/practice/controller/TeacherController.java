package com.lambda.practice.controller;

import com.lambda.practice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor //final인 것에만 DI를 해준다. new를 하여 ApplicationContext에 등록해 놓은 것을 넣어준다.
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String get() {
        return "Hello";
    }
}
