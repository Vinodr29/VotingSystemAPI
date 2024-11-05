package com.example.voting.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.voting.model.Candidate;


@Service
public class VotingService {
	private final ConcurrentHashMap<String, Candidate> candidates = new ConcurrentHashMap<>();

    public String addCandidate(String name) {
        if (candidates.containsKey(name)) {
            return "Candidate already exists.";
        }
        candidates.put(name, new Candidate(name));
        return "Candidate " + name + " added with initial vote count of 0.";
    }

    public String castVote(String name) {
        Candidate candidate = candidates.get(name);
        if (candidate == null) {
            return "Invalid candidate.";
        }
        candidate.incrementVoteCount();
        return "Vote cast for " + name + ". Current vote count: " + candidate.getVoteCount();
    }

    public String getVoteCount(String name) {
        Candidate candidate = candidates.get(name);
        if (candidate == null) {
            return "Invalid candidate.";
        }
        return "Current vote count for " + name + ": " + candidate.getVoteCount();
    }

    public Map<String, Integer> listVotes() {
        Map<String, Integer> votes = new HashMap<>();
        candidates.forEach((name, candidate) -> votes.put(name, candidate.getVoteCount()));
        return votes;
    }

    public String getWinner() {
        return candidates.values()
                .stream()
                .max(Comparator.comparingInt(Candidate::getVoteCount))
                .map(Candidate::getName)
                .orElse("No candidates available.");
    }
}


