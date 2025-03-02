Voting Management System (Spring Boot REST API)
This project is a Voting Management System built using Spring Boot, where users can vote for candidates, and the system determines the winner based on the highest votes. The RESTful APIs are tested and executed using Postman.

Features:
✅ Register candidates for voting
✅ Allow users to cast votes
✅ Retrieve the total votes for each candidate
✅ Get the winner based on the highest votes

Technologies Used : 
Spring Boot (Backend API)
Spring Data JPA (Database interaction)
MySQL (Database)
Postman (API testing & execution)
Maven (Dependency management)


API Endpoints & Usage (via Postman) :
1) Enter Candidate :
     POST - http://localhost:8080/vote/entercandidate?name=John
2) Cast Vote :
     POST - http://localhost:8080/vote/castvote?name=John
4) Count Vote :
     GET - http://localhost:8080/vote/countvote?name=John
6) List Votes :
     GET - http://localhost:8080/vote/listvote
8) Get Winner :
     GET - http://localhost:8080/vote/getwinner
