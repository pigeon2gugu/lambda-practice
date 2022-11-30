package com.lambda.practice.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void name() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher kyeongrok = new Teacher("김경록", true, true);
        Teacher kyeonghwan = new Teacher("고경환", true, false);
        Teacher sujin = new Teacher("김수진", false, true);
        Teacher sohyun = new Teacher("강소현", true, true);

        teachers.add(kyeongrok);
        teachers.add(kyeonghwan);
        teachers.add(sujin);
        teachers.add(sohyun);


        System.out.println("---Algorithm이 true");
        List<Teacher> likeAlgorithmTeachers = teachers.stream()
                .filter(teacher -> teacher.isLikeAlgorithm() == true)
                .collect(Collectors.toList());


        for (Teacher teacher : likeAlgorithmTeachers) {
            System.out.println(teacher.getName());
        }

        //람다 사용하지 않을 시
        List<Teacher> likeAlgorithmTeacher = new ArrayList<>();

        for(int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).isLikeAlgorithm()) {
                likeAlgorithmTeacher.add(teachers.get(i));
            }
        }


        System.out.println("---Spring Boot이 true");
        //sLikeSpring boot가 true이면 필터해서 그 다음 teacher.getName을 매핑
        List<String> likeSpringBootTeachers = teachers.stream()
                .filter(teacher -> teacher.isLikeSpringBoot() == true)
                .map(teacher -> teacher.getName())
                .collect(Collectors.toList());


        for (String teacherName : likeSpringBootTeachers) {
            System.out.println(teacherName);
        }
    }

    @Test
    void predicateTest() {
        //숫자 num을 넣으면 10보다 큰지 true or false로 return
        Predicate<Integer> predicate = num -> num > 10;
        System.out.println(predicate.test(10));
    }

    @Test
    void mapTest() {
        //타입을 collection단위로 바꿀수잇음.
        String[] list = {"1", "2", "3"};
        List<Integer> nums = Arrays.stream(list)
                .map(strNum -> Integer.parseInt(strNum))
                .collect(Collectors.toList());

        //reduce : Collection을 연산해서 한개의 값으로 만들어주는 연산
        int reduceSum = Arrays.stream(list)
                .map(strNum -> Integer.parseInt(strNum))
                .reduce(0, (a,b) -> a+b);

        System.out.println("reduceSum : " +reduceSum);
    }

    @Test
    void teacherNameLength() {

        List<Teacher> teachers = new ArrayList<>();
        Teacher kyeongrok = new Teacher("김경록", true, true);
        Teacher kyeonghwan = new Teacher("고경환", true, false);
        Teacher sujin = new Teacher("김수진", false, true);
        Teacher sohyun = new Teacher("강소현", true, true);

        teachers.add(kyeongrok);
        teachers.add(kyeonghwan);
        teachers.add(sujin);
        teachers.add(sohyun);


/*        List<Integer> likeSpringBootTeachers = teachers.stream()
                .filter(teacher -> teacher.isLikeSpringBoot() == true)
                .map(teacher -> (teacher.getName()).length())
                .collect(Collectors.toList());*/

        List<Integer> likeSpringBootTeachers = teachers.stream()
                .filter(Teacher :: isLikeSpringBoot)
                .map(Teacher :: cntNameDigit)
                .collect(Collectors.toList());

        for (Integer teacherName : likeSpringBootTeachers) {
            System.out.println(teacherName);
        }

    }

    @Test
    void optionalTest() {

        //값이 없는 경우
        Optional<Teacher> emptyTeacher2 = Optional.empty();
        //emptyTeacher2.get() : error;
        emptyTeacher2.orElseThrow(RuntimeException::new);
        Teacher teacher1 = emptyTeacher2.orElseThrow(() -> new RuntimeException());

        //값이 있는 경우
        Optional<Teacher> optionalTeacher3 = Optional.of(new Teacher("김경록", true, true));
        optionalTeacher3.ifPresent(sth ->{
            throw new RuntimeException(sth.getName());
        });

        // .ofNullable, orElse()
        Optional<Teacher> optionalTeacher4 = Optional.of(new Teacher(null, true, true));
        String name = Optional.ofNullable(optionalTeacher4.get().getName()).orElse("이름이 없습니다.");
        System.out.println(name);

    }
}