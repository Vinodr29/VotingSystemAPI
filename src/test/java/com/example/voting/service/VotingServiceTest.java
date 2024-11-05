package com.example.voting.service;

import com.example.voting.model.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VotingServiceTest {

    private VotingService votingService;

    @BeforeEach
    void setUp() {
        votingService = new VotingService();
    }

    @Test
    void testAddCandidate() {
        assertEquals("Candidate Alice added with initial vote count of 0.", votingService.addCandidate("Alice"));
        assertEquals("Candidate already exists.", votingService.addCandidate("Alice"));
    }

    @Test
    void testCastVote() {
        votingService.addCandidate("Bob");
        assertEquals("Vote cast for Bob. Current vote count: 1", votingService.castVote("Bob"));
    }

    @Test
    void testGetVoteCount() {
        votingService.addCandidate("Charlie");
        assertEquals("Current vote count for Charlie: 0", votingService.getVoteCount("Charlie"));
    }

    @Test
    void testListVotes() {
        votingService.addCandidate("Alice");
        votingService.addCandidate("Bob");
        votingService.castVote("Alice");
        assertEquals(1, votingService.listVotes().get("Alice"));
    }

    @Test
    void testGetWinner() {
        votingService.addCandidate("Alice");
        votingService.castVote("Alice");
        assertEquals("Alice", votingService.getWinner());
    }
}