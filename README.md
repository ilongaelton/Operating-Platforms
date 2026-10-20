# CS 230 – Operating Platforms

## The Gaming Room Software Design Document

### Project Overview

The Gaming Room is a client that developed a game called *Draw It or Lose It*, originally designed for Android devices. The company wanted to expand the game so that users could play on multiple platforms, including Windows, macOS, Linux, and mobile devices.

The game allows teams to compete by guessing images displayed during timed rounds. The client needed a software design that would support multiple teams, unique game and team names, multiple players, and efficient resource management. The design also needed to address security, scalability, and compatibility across operating systems.

### 1. What did you do particularly well in developing this documentation?

One thing I did particularly well was explaining the differences between operating platforms and identifying how each platform could support the game. I focused on important requirements such as memory management, storage, security, and application performance. I also worked to organize the document clearly so that both the client and the development team could understand the recommendations.

### 2. What about the process of working through a design document did you find helpful when developing the code?

Creating the software design document helped me understand the application requirements before beginning development. It allowed me to identify the different components of the system and how they would communicate with each other. For example, using the Singleton design pattern helped ensure that the application would manage a single game service instance. This process showed me why planning is important before writing code.

### 3. If you could choose one part of your work on these documents to revise, what would you pick? How would you improve it?

If I could revise one part of my design document, I would improve the security and distributed systems sections. I would provide more detailed explanations of authentication, encryption, and how the game server communicates with multiple clients. I would also include diagrams to make the architecture easier to understand.

### 4. How did you interpret the user's needs and implement them into your software design? Why is it important to consider the user's needs?

I interpreted the client's needs by reviewing the game requirements and identifying the technical features necessary to support them. Since The Gaming Room wanted players to access the game from different operating systems, I recommended a web-based approach with a centralized server.

I also considered the need to manage multiple games, teams, and players while maintaining unique names and protecting application data. Understanding user needs is important because software should solve the client's actual problems and provide a reliable experience.

### 5. How did you approach designing software? What techniques or strategies would you use in the future?

My approach involved understanding the requirements, comparing different operating systems, and evaluating the advantages and limitations of each platform. I considered system architecture, memory management, storage, security, and scalability before recommending a solution.

In future projects, I would continue using requirement analysis, object-oriented programming principles, UML diagrams, and design patterns. I would also test prototypes early and collect feedback from users to identify problems before completing development.

### Conclusion

This project helped me understand how software architecture and operating systems influence application development. I learned that designing software involves more than writing code. It requires understanding client requirements, planning system components, and selecting technologies that support performance, security, and future growth.

The Gaming Room project gave me experience documenting technical decisions and communicating software design recommendations, which will be valuable in my future software engineering career.
