package com.rishabh.PollingApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Poll {

    @Id
    private String id;

    @NotBlank
    @Size(max = 140)
    private String question;

    @NotNull
    private Instant expirationDateTime;

    @NotNull
    private Date createdOn;

    @DBRef
    private List<Choice> choices = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(Instant expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public void addChoices(Choice choice) {
        choices.add(choice);
        choice.setPoll(this);
    }

    public void removeChoices(Choice choice) {
        choices.remove(choice);
        choice.setPoll(null);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
