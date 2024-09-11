package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;

    private String email;

    private List<Vote> votes;

    private List<Poll> polls;

    public User(String username, String email){
        this.username = username;
        this.email = email;
        this.polls = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void addVote(Vote vote){
        votes.add(vote);
    }
    public void removeVote(Vote vote){
        votes.remove(vote);
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public void addPoll(Poll poll){
        polls.add(poll);
    }
    public void removePoll(Poll poll){
        polls.remove(poll);
    }
}
