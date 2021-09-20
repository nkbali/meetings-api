package com.study.meetings.models.input;

import lombok.Data;

import java.util.List;

@Data
public class MeetingInput {

    private long startsAt;

    private long endsAt;

    private String organizerID;

    private List<String> invitees;

    private List<AgendaInput> agendas;

}
