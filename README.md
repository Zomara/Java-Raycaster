# Computer Science 12 Final Project
2.5 Raycaster engine in Java with Jframe
Uses 120 rays projected from the player on a 2D map to draw 32x32 resolution walls, floor, and cieling on an 8 x 8 tile map

# Classes Breakdown
Main: Initializes and sets up the JFrame window

GamePanel: Handles the actual game loop and setup, creates instances of all the other classes

KeyHandler: Keeps track of the players keyboard states
- W = forward
- S = backward
- A = turn left
- D = turn right
- left arrow = increase ray count (more rays is more detailed horizontal resoultion)
- right arrow = decrease ray count
- e = interact (unused)

Player: Keeps track of player location, direction, and collisions

Map:Keeps track of Wall Positions along with which floor/ceiling/wall tiles have which textures

Sound: Plays background Music

Rays: The most important part of the code, simulates all the rays "emitted" from the player to calculate which walls to draw on screen at what distance / rotation. This class essentially calculates everything drawn on screen.

Sprite: Code still in development, intended purpose is to draw a 2d sprite (a yellow square) at a fixed location on the map 


# Future Roadmap
- Fix Sprite Code
- Create Client and Host versions with a one way connection, the client code send its player coordinates to be drawn as a sprite on the hosts screen
- Make Client/Host programs a two-way connection, both players can "see" each other
- Increase Map Size


# Sources:

https://www.geeksforgeeks.org/socket-programming-in-java/

https://www.baeldung.com/a-guide-to-java-sockets

https://www.youtube.com/playlist?list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq

https://www.youtube.com/watch?v=gYRrGTC7GtA

https://www.youtube.com/watch?v=PC1RaETIx3Y

https://www.youtube.com/watch?v=w0Bm4IA-Ii8

# Music:

The Legend of Zelda: A Link to the Past - Overworld Theme
