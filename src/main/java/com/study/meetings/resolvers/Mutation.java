package com.study.meetings.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.study.meetings.MeetingsAPIApplication;
import com.study.meetings.models.Meeting;
import com.study.meetings.models.Person;
import com.study.meetings.models.input.MeetingInput;
import com.study.meetings.models.input.PersonInput;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Mutation implements GraphQLMutationResolver {

    public Meeting createMeeting(MeetingInput meetingInput){

        Meeting meeting = new Meeting();
        meeting.setStartsAt(meetingInput.getStartsAt());
        meeting.setEndsAt(meetingInput.getEndsAt());
        var organizer = MeetingsAPIApplication.persons.stream().filter(person -> person.getId().equalsIgnoreCase(meetingInput.getOrganizerID())).findFirst().get();
        meeting.setOrganizer(organizer);
        List<Person> invitees = new ArrayList<>();
        for (String inviteeId: meetingInput.getInvitees()) {
            var invitee = MeetingsAPIApplication.persons.stream().filter(person -> person.getId().equalsIgnoreCase(inviteeId)).findFirst().get();
            invitees.add(invitee);
        }
        meeting.setInvitees(invitees);
        meeting.setId(UUID.randomUUID().toString());
        MeetingsAPIApplication.meetings.add(meeting);

        return meeting;
    }

    public Person createPerson(PersonInput personInput){

        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setEmail(personInput.getEmail());
        person.setFirstName(personInput.getFirstName());
        person.setLastName(personInput.getLastName());
        if(StringUtils.isNotBlank(personInput.getPhoneNumber()))
            person.setPhoneNumber(personInput.getPhoneNumber());

        MeetingsAPIApplication.persons.add(person);

        return person;
    }

}
