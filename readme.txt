## Voting System API - Usage Guide

### Features Implemented :

> Enter Candidate (/vote/entercandidate): Adds a candidate with an initial vote count of 0.
> Cast Vote (/vote/castvote): Increments the vote count for a specified candidate.
> Count Vote (/vote/countvote): Returns the current vote count for a specified candidate.
> List Votes (/vote/listvote): Lists all candidates and their vote counts.
Get Winner (/vote/getwinner): Returns the candidate with the highest vote count.

### Usage
To test this API, you can use tools like Postman.

#### Example Requests:

*Add Candidate*: POST http://localhost:8080/vote/entercandidate?name=ajay
*Cast Vote*: POST http://localhost:8080/vote/castvote?name=ajay
*Get Vote Count*: GET http://localhost:8080/vote/countvote?name=ajay
*List Votes*: GET http://localhost:8080/vote/listvote
*Get Winner*: GET http://localhost:8080/vote/getwinner