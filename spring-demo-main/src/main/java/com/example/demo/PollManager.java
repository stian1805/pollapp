package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class PollManager {

    private Map<Integer, Poll> pollMap= new HashMap<>();

    private Map<String, User> userMap= new HashMap<>();

    private Integer userId = 0;


    public Collection<Poll> getAllPolls() {
        return pollMap.values();
    }

    public Poll getPoll(Integer id) {
        return pollMap.get(id);
    }

    public void addPoll(Poll poll) {
        pollMap.put(poll.getId(), poll);
    }
    public void removePoll(Poll poll){
        pollMap.remove(poll.getId());
    }

    public Collection<User> getAllUsers() {
        return userMap.values();
    }

    public User getUser(String id) {
        return userMap.get(id);
    }
    public void addUser(User user) {
        userMap.put(user.getUsername(), user);
        userId++;
    }
    public void removeUser(User user) {
        userMap.remove(user.getUsername());
    }

}
