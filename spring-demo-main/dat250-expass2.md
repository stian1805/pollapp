Pending issues:
It lacks error handling if someone tries to access an 
object that does not exist.
Implemented GET, POST and DELETE handlers, but have not implemented a way to update.
Do not have a GET handler for Votes and Votes does not get deleted if the Poll is deleted.

Unsure of how the relations from the model should be implemented. Currently, the User have a list of its created
Polls and Votes, and the Poll have a list of VoteOptions. Should probably be set up differently.
Chose to identify Users by their username and Polls by a created index.
Created and ran test scenarios using Bruno.
