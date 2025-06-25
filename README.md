# Computer Science 12 Final Project
2.5 Raycaster engine in Java with Jframe
Uses 120 rays projected from the player on a 2D map to draw 32x32 resolution walls, floor, and ceiling on an 8 x 8 tile map


https://github.com/user-attachments/assets/c07e4466-b7b7-4cf1-8264-19ccc6f828bf


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

# Process

1. Followed RyiSnow's Tutorial for a 2D game in Java to learn how to use JFframe (game window, drawing shapes, managing frame rate)
2. Created a top down view of the player, map, and drawn rays
3. Added player collisions
4. Took each individual ray and rendered it as a vertical slice of a wall to make the map "3D". North/South and East/West walls are slightly different shades of color to imitate lighting
5. Did some research on how to use sockets to add multiplayer, was able to send/recieve a one string message
6. Gave walls Textures by projecting a texture onto each slice of wall
7. Made the rendered output take up the full screen, hiding the top down map
8. Added textured celings and floors
9. Started to try to draw a "sprite", a square that would stay at the same relative map position and scale with distance

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
