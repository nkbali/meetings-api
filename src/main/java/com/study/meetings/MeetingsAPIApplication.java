package com.study.meetings;

import com.study.meetings.models.Meeting;
import com.study.meetings.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MeetingsAPIApplication {

    public static List<Person> persons = new ArrayList<>();

    public static List<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(MeetingsAPIApplication.class, args);
    }

}
