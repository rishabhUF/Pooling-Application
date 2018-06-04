package com.rishabh.PollingApplication.model;

import org.springframework.data.annotation.Id;

public class Vote {

    @Id
    private String id;

    private Poll poll;

    private Choice choice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
