package com.lambda.practice.service;

import com.lambda.practice.domain.Teacher;
import com.lambda.practice.exception.ErrorCode;
import com.lambda.practice.exception.HospitalException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    public Teacher world(String userName) {
        //exception발생시키기
        Optional<Teacher> teacherOptional = Optional.empty();
/*        teacherOptional.ifPresent(teacher -> {
            throw new HospitalException(ErrorCode.DUPLICATE_USER_NAME, "DB에 "+userName+"검색 시 빈값이 아닙니다.");
        });*/
        //teacher를 받아 name을 꺼내고 싶음. teacher가 없을 때에는 의도적인 exception처리.
        //Teacher teacher = teacherOptional.orElseThrow(() -> new RuntimeException("teacher가 없습니다."));
        Teacher teacher = teacherOptional.orElseThrow(() -> new HospitalException(ErrorCode.DUPLICATE_USER_NAME, "DB에 "+userName+"검색 시 빈값이 아닙니다."));

        //유저에게 exception의 원인을 알려주고 싶음. 콘솔에 뜨는것을 알려주기 위해 @RestControllerAdvice사용
        //특정 Exception이 발생하면 @RestControllerAdvice에서 처리.
        //Exception을 Throw하면 바로 위로만 간다.
        return teacher;
    }
}
