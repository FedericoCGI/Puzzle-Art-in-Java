# Puzzle Art in Java

Puzzle Art!

Puzzle Art! is a game developed in Java that combines the experience of traditional puzzles with elements of interactivity and graphics management. This project was created by Federico March and Isabel Toro Sima as part of the Programming in Java course at the University of Tor Vergata.

## Game Description

The game consists of reconstructing famous works of art by correctly placing their pieces in a grid. The main feature of the game is the use of interactive images and audio, which guide the player through various levels of difficulty, starting with simpler grids of 4 pieces and progressing to more complex grids of 16 pieces.

## Features:

- Three Difficulty Levels: The game includes three difficulty levels with grids of increasing size (4, 9, 16 pieces).
- Timer and Scoring System: Each level has a timer that limits the available time to complete the puzzle. Accuracy and speed determine the player's score.
- Audio and Visual Components: Uses WAV audio clips to enhance the gaming experience, including sound effects for game actions and background music.
- Image Viewing: Whenever the player wants to see the complete image to be reconstructed, a "View Image" button is available that opens a dedicated window with the reference image.
- Piece Movement and Logic: Puzzle pieces can be dragged using the mouse. The game automatically checks if a piece has been placed correctly in the grid, increasing the score accordingly.

## Classes

The custom classes developed for this project are listed as follows:
- [Importa_Audio](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/Importa_Audio.java): Manages and imports audio file into the project.
- [Importa_Immagine](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/Importa_Immagine.java): Allows images import into the project.
- [GrigliaFotoComponent](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/GrigliaFotoComponent.java): Creates a grid of rectangles represented as a 2D array of Rectangle2D.Double instances.
- [Cronometro](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/Cronometro.java): Creates a counter that communicates the time left to players to complete a level.
- [CardViewer](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/CardViewer.java):
