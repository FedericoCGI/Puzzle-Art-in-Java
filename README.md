# ![icon](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/images/PA_icon.png)    Puzzle Art in Java

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
- [Importa_Immagine](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/Importa_Immagine.java): Allows importing images into a class.
- [GrigliaFotoComponent](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/GrigliaFotoComponent.java): Creates a grid of rectangles represented as a 2D array of Rectangle2D.Double instances.
- [Cronometro](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/Cronometro.java): Sets the available playtime for each level.
- [CardViewer](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/CardViewer.java): Creates a window showing the reference image of the puzzle, helping players to place every piece correctly.
- [ViewerAction](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/ViewerAction.java): Manages actions related to "View Image" button.
- [AssegnazioneFotoComponent](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/AssegnazioneFotoComponent.java): Manages and displays the grid in a window, while randomizing the puzzle pieces for each level.
- [PressPlayAction](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/PressPlayAction.java): Describes the actions that will be performed when the play button is pressed and creates the screen for the first level.
- [PuzzleArt](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/PuzzleArt.java): It is the class that contains the main method and manages the intro window of the game.
- [TutorialAction](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/TutorialAction.java): Manages actions related to "Tutorial" button.
- [SecondoLivello](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/SecondoLivello.java): Manages level 2 data.
- [TerzoLivello](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/TerzoLivello.java): Manages level 3 data. 
- [Congratulation](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/code/src/Congratulation.java): Creates the end-game screen, where the CPU congratulates the player for completing the levels.

## Libraries

- Java Swing: For creating the graphical user interface and managing visual components.
- Java AWT and Javax.sound.sampled: For managing the graphical rendering of rectangles and playing sound effects.

## Content

- Project documentation is avaible in [documentation.pdf](https://github.com/FedericoCGI/Puzzle-Art-in-Java/blob/main/sources/PA_documentation.pdf), in [sources](https://github.com/FedericoCGI/Puzzle-Art-in-Java/tree/main/sources) folder. Currently, this file is written in Italian, but an English version will be uploaded as soon as possible.
- Project implementation is available in the [code](https://github.com/FedericoCGI/Puzzle-Art-in-Java/tree/main/code) folder.

## Authors

[Federico March](https://github.com/FedericoCGI)
- [ArtStation](https://www.artstation.com/federicomarch_cgi)
- [LinkedIn](https://www.linkedin.com/in/federico-march-a15b17194/)
- federico.march.cgi@gmail.com

Isabel Toro Sima
