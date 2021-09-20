package com.study.meetings.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.study.meetings.MeetingsAPIApplication;
import com.study.meetings.models.Meeting;
import com.study.meetings.models.Person;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Query implements GraphQLQueryResolver {


    public List<Meeting> getMeetings(String id){
        if(StringUtils.isBlank(id)){
            return MeetingsAPIApplication.meetings;
        }
        else{
            return MeetingsAPIApplication.meetings
                    .stream()
                    .filter(meeting -> meeting.getId().equalsIgnoreCase(id))
                    .collect(Collectors.toList());
        }
    }


    public List<Person> getPersons(String id){
        if(StringUtils.isBlank(id)){
            return MeetingsAPIApplication.persons;
        }
        else{
            return MeetingsAPIApplication.persons
                    .stream()
                    .filter(person -> person.getId().equalsIgnoreCase(id))
                    .collect(Collectors.toList());
        }
    }
}
