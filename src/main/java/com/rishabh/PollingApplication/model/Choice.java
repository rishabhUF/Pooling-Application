package com.rishabh.PollingApplication.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Choice {

    @Id
    private String id;

    @NotBlank
    @Size(max = 40)
    private String text;

    private Poll poll;

    public Choice(){

    }

    public Choice(String text){
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
