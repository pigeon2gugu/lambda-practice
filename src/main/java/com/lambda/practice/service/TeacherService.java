package com.lambda.practice.service;

import com.lambda.practice.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    public String world() {
        //exception발생시키기
        Optional<Teacher> teacherOptional = Optional.empty();
        //teacher를 받아 name을 꺼내고 싶음. teacher가 없을 때에는 의도적인 exception처리.
        Teacher teacher = teacherOptional.orElseThrow(() -> new RuntimeException("해당 teacher가 없습니다."));

        //유저에게 exception의 원인을 알려주고 싶음. 콘솔에 뜨는것을 알려주기 위해 @RestControllerAdvice사용
        //특정 Exception이 발생하면 @RestControllerAdvice에서 처리.
        //Exception을 Throw하면 바로 위로만 간다.
        return "World";
    }
}
