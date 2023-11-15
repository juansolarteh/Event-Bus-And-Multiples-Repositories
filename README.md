# Event Bus and Multiple Repositories
This repository houses a Java project built with 
the **Spring Boot Framework.** It showcases an 
example of an **Event Bus**, multiple repository 
implementations within a **Vertical Slice 
architecture** (DDD), combined with the **Hexagonal 
architecture.**

## Event Bus
The project demonstrates a generic synchronous 
**Event Bus** capable of supporting various types 
of events.

## Repositories
Furthermore, the project includes an interface 
for a repository and two distinct implementations. 
The first implementation simulates a repository 
using a list of employees, while the second one 
mimics a repository, displaying new data as an 
output system.

## Transactional Methods
The usage example incorporates the 
**@Transactional** annotation. By substituting 
the repository implementationsS with real ones, 
you'll harness the synchronous power of the event 
bus with transactions. This ensures the 
reliability and security of your data.

## Architecture
In extensive projects, this architecture proves 
invaluable. It allows you to decouple your system 
components within their respective domains and 
apply SOLID patterns in an organized manner.
