package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class VoteOption {

    private String caption;

    private List<Vote> votes;

    private int presentationOrder;

    public VoteOption(String caption) {
        this.caption = caption;
        this.presentationOrder = 0;
        this.votes = new ArrayList<>();
    }

    public VoteOption() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
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
}
