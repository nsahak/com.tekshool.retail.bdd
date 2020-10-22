Feature: Database SQL query feature

@sqlquery
Scenario: Execute all information from Actor Table
Given User connects to PostgreSQL
When User sends "select * from public.actor"
Then User should get all infomration from that table