/**
* PLEASE READ
* Notes about program:
* • The values selected and message that states if a bonus is applied appears after values are selected each round
* and before the updated board and scores appear; you may need to scroll up to see it
* • Player1 starting index for selecting values is 0; valid range is 0 to (number of rows/columns - 1)
**/

public class Main {

    public static void main(String[] args) {
        /**Generate and add Players for the game**/
        PlayerList playerList = new PlayerList();       //Instantiate playerlist object
        playerList.loadPlayers();       //Call loadPlayers to create each player for the game and add to playerlist

        /**Generate game board**/
        Board gameboard = new Board();    //Instantiate Board object named gameboard
        gameboard.initializeBoard();      //Call initializeBoard from Board to generate the board for the game

        /**Play the game**/
        playGame(gameboard, playerList);    //Loop to run the game

        
    }
    //Game continues until someone reaches 100 or now more valid spaces
    public static void playGame(Board board, PlayerList PlayerList) {
        while (!board.isGameOver(PlayerList)) {   //As long as isGameOver is false which means all spaces haven't been captured, or no one has reached 100 points yet players will capture spaces untill someone reaches 100 or until all spaces are captured
            board.DisplayBoard();   //Display the board
            PlayerList.displayPlayersScores();  //Display each player score for all the players in the arraylist of players

            for (Player player : PlayerList.getPlayers()) {     //For each player in the PlayerList
                player.captureSpaces(board);    //Each player gets to capture spaces
                if (player.getScore() >= 100) {     //When a player score reaches 100 stop the game and display winner
                    PlayerList.displayPlayersScores();  //Display player scores
                    System.out.println(player.getName() + " wins!");    //Winner message
                    break; //Exit the loop and end the game
                }
            }
        }
    }
}

