package com.example.demo;

import java.time.Instant;

public class Vote {

    private User creator;

    private Instant publishedAt;

    private VoteOption option;


    public Vote(User creator, VoteOption option) {
        this.creator = creator;
        this.publishedAt = Instant.now();
        this.option = option;
    }


    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public VoteOption getOption() {
        return option;
    }

    public void setOption(VoteOption option) {
        this.option = option;
    }
}
