package com.example.demo;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class Poll {
    private static int uid = 0;

    private Integer id;

    private String question;

    private Instant publishedAt;

    private Instant validUntil;

    private List<VoteOption> options;

    private User creator;


    public Poll(String question, List<VoteOption> options, User user) {
        this.id = uid++;
        this.question = question;
        this.publishedAt = Instant.now();
        this.validUntil = Instant.now();
        this.options = options;
        this.creator = user;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public void addOption(VoteOption option) {
        options.add(option);
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
