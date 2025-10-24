# zero-to-100
The game starts by generating a grid with each coordinate containing a hidden number. The player plays against two CPUs and takes turn picking coordinates of covered spaces and revealing the numbers underneath. The numbers revealed get added to the player’s score. First player that reaches 100 points wins.

# Project Overview
Zero to 100 is a turn-based Java strategy game where three players—one user and two CPUs—compete to reach a total score of 100 points first by capturing spaces on a randomly generated game board. The program is built using multiple object-oriented principles, featuring an abstract Player class and three subclasses: Player1, Player2, and Player3, each implementing the abstract captureSpaces method differently to define unique play styles. The Player1 class represents the user, allowing manual input to select board spaces, while Player2 (CPU1) randomly captures available spaces, and Player3 (CPU2) systematically captures the earliest uncaptured spaces on the board. A PlayerList class manages all players within an ArrayList, loading their data, displaying scores, and maintaining game order. The Board class creates and manages a 2D array representing the game board, where each space is initialized with random numeric values between 1 and 9 and a corresponding boolean array tracks whether a space has already been captured. When players select spaces, the board updates by replacing the asterisk (*) with the numeric value of that position, preventing duplicate selections. After each round, scores are recalculated using the inherited methods in the Player class, which determine point totals, apply bonuses for duplicate or sequential selections, and update cumulative scores. The board also dynamically updates to display the number of remaining spaces, the maximum remaining value, and the current sum of uncaptured spaces. The main game loop, contained within the playGame method, continues until a player’s score reaches 100 or all spaces are captured. The isGameOver method ensures smooth game termination by checking if a win condition has been met or if no playable spaces remain. Throughout gameplay, player interactions, board updates, and score progress are displayed in real time.

## Original Assignment Requirements
* User submits Java program creating and implementing at least 3 custom class all in separate .java files 
* Board contains random numbers 
* User is able to select spaces on the board 
* CPU1 and CPU2 can select spaces on board using steps provided 
* Board spaces cannot be selected multiple times during a game by any player 
* Board spaces selected are updated to include their value 
* Player scores are updated after each round 
* Board information (max value, spaces remaining, and sum) are updated after each round 
* Bonuses are applied to player selections when able
* Game ends when player score reaches 100 


<br />

# Getting Started
## Prerequisites

Before you begin, ensure you have met the following requirements:
* Java 8+

## Installing

* To install this program, clone or download this repository:

        git clone zero-to-100.git

* Then, navigate into the project directory:

        cd zero-to-100


## Executing program
* To run the program from the terminal:
        java .\main.java

### Example Output
```java .\main.java```
```
Player1, please enter your name: player1

Enter game board dimensions (minimum 5x5)
Enter number of rows: 5
Enter number of columns: 5

*       *       *       *       *
*       *       *       *       *
*       *       *       *       *
*       *       *       *       *
*       *       *       *       *

Sum Remaining:                          159
Spaces Remaining:                       25
Highest Value Remaining:                9

player1's Score:                        0
CPU1's Score:                   0
CPU2's Score:                   0
Enter row and column of space you want to capture
Enter a row: 3
Enter a column: 2
. . .
```


<br />

# Future Updates

* Update planned at a later time that includes error handling and refactoring

# Version History
*0.1
    *Initial Release

<br />

# Authors

**Author:** Emily Nowak

*Based on **Program 3** by **Professor Stephen Harris** for CSC222: Object-Oriented Programming with Java at Tidewater Community College*

<br />