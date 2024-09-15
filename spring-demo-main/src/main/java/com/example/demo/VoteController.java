package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin
public class VoteController {
    private PollManager manager;

    public VoteController(@Autowired PollManager manager) {
        this.manager = manager;
    }


    @PostMapping("/vote")
    public ResponseEntity<Object> voteHandler(@RequestBody Vote vote) {
        manager.getUser(vote.getCreator().getUsername()).addVote(vote);
        return ResponseEntity.ok("Vote created");
    }

    @DeleteMapping("/vote/delete")
    public ResponseEntity<Object> deleteVoteHandler(@RequestBody Vote vote) {
        manager.getUser(vote.getCreator().getUsername()).removeVote(vote);
        return ResponseEntity.ok("Vote deleted");
    }

}
