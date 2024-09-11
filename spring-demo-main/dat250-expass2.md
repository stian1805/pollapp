Report:

Pending issues:
Currently, the system lacks proper error handling when users attempt to access objects that do not exist, 
which could lead to unexpected behavior.
Implemented GET, POST and DELETE handlers, but have not implemented a way to update. This means users cannot modify 
existing objects such as polls or vote options without deleting and recreating them. 
Do not have a GET handler for Votes and Votes does not get deleted if the Poll is deleted. Need to figure out how i should
represent the votes relations before i can properly implement the votes. 

I am currently unsure about how to best implement the relationships in the domain model. The User entity maintains a list 
of its created Polls and Votes, while the Poll entity has a list of VoteOptions. Should probably be set up differently.
Users are identified by their usernames, and polls are identified using an auto-generated index.

I used Bruno for testing and running HTTP requests. Bruno lets me set up a seriez of requests that the poll should
be able to handle and view the output. I based the tests primarily on the HTTP requests provided in the assignment specification

