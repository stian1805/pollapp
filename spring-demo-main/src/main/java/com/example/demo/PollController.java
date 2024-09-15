package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
public class PollController {
    private PollManager manager;

    public PollController(@Autowired PollManager manager) {
        this.manager = manager;
    }

    @GetMapping("/polls")
    public Collection<Poll> getAllPollsHandler() {
        return manager.getAllPolls();
    }

    @GetMapping("/polls/{id}")
    public ResponseEntity<Poll> getPollHandler(@PathVariable Integer id) {
        return ResponseEntity.ok(manager.getPoll(id));
    }

    @PostMapping(value = "/polls")
    public ResponseEntity<Poll> createPollHandler(@RequestBody Poll poll) {
        manager.addPoll(poll);
        User creator = manager.getUser(poll.getCreator().getUsername());
        creator.addPoll(poll);

        return ResponseEntity.created(URI.create("/polls/" + poll.getId())).body(poll);
    }


    @DeleteMapping("/polls/delete")
    public ResponseEntity<Object> deletePollHandler(@RequestBody Poll poll) {
        Poll pollToRemove = manager.getPoll(poll.getId());

        User creator = manager.getUser(poll.getCreator().getUsername());
        creator.removePoll(pollToRemove);

        manager.removePoll(pollToRemove);

        return ResponseEntity.ok("Poll removed");
    }

}
