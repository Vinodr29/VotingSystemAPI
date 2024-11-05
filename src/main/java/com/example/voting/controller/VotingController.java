package com.example.voting.controller;

import com.example.voting.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/vote")
public class VotingController {

    private final VotingService votingService;

    @Autowired
    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @PostMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        return votingService.addCandidate(name);
    }

    @PostMapping("/castvote")
    public String castVote(@RequestParam String name) {
        return votingService.castVote(name);
    }

    @GetMapping("/countvote")
    public String countVote(@RequestParam String name) {
        return votingService.getVoteCount(name);
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes() {
        return votingService.listVotes();
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        return votingService.getWinner();
    }
}
