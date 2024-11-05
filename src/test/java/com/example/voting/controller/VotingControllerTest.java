package com.example.voting.controller;

import com.example.voting.service.VotingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest(VotingController.class)
class VotingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VotingService votingService;

    @Test
    void testEnterCandidate() throws Exception {
        when(votingService.addCandidate("Alice")).thenReturn("Candidate Alice added with initial vote count of 0.");

        mockMvc.perform(post("/vote/entercandidate")
                        .param("name", "Alice")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Candidate Alice added with initial vote count of 0."));
    }

    @Test
    void testCastVote() throws Exception {
        when(votingService.castVote("Bob")).thenReturn("Vote cast for Bob. Current vote count: 1");

        mockMvc.perform(post("/vote/castvote")
                        .param("name", "Bob")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Vote cast for Bob. Current vote count: 1"));
    }

    @Test
    void testCountVote() throws Exception {
        when(votingService.getVoteCount("Charlie")).thenReturn("Current vote count for Charlie: 0");

        mockMvc.perform(get("/vote/countvote")
                        .param("name", "Charlie")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Current vote count for Charlie: 0"));
    }

    @Test
    void testListVotes() throws Exception {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Alice", 1);
        votes.put("Bob", 2);

        when(votingService.listVotes()).thenReturn(votes);

        mockMvc.perform(get("/vote/listvote")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Alice").value(1))
                .andExpect(jsonPath("$.Bob").value(2));
    }

    @Test
    void testGetWinner() throws Exception {
        when(votingService.getWinner()).thenReturn("Bob");

        mockMvc.perform(get("/vote/getwinner")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Bob"));
    }
}

