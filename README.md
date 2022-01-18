# Discord-Zoom-Bot

Simple Java application that uses Zoom 
API's Webhooks to keep track of active
users in a given meeting. User information
is stored using an ArrayList <will change
into MongoDB> and is relayed onto a Discord channel
of choice by using JDA wrapper class for Discord's API.

## On Zoom

Since the Zoom Webhooks are associated to my account,
any meeting created by me will generate Webhooks every time someone leaves or enters a meeting.

## On Discord

Discord Bot (as registered as an application under Discord's Developer Portal)
needs to be added and be given permission to be added to a given server and be given permission to send messages.
Discord users can then type `!zoom` to get the meeting's invite link and see how many people are currently in the meeting.
The Bot is also programmed to notify a specific text channel whenever a user joins or leaves a meeting.
  
### Technologies Used
  
* JDA - Java Wrapper for Discord API: https://github.com/DV8FromTheWorld/JDA
* Zoom API (Webhooks): https://marketplace.zoom.us/docs/api-reference/webhook-reference
* Spark - Java Framework for creating web apps: https://sparkjava.com/
