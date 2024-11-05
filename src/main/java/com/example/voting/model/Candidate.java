package com.example.voting.model;

public class Candidate {
	private String name;
	private int voteCount;
	
	public Candidate(String name) {
		this.name=name;
		this.voteCount=0;
		
	}

	public String getName() {
		return name;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void incrementVoteCount() {
		this.voteCount++;
	}
	
	

}
