

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerList {

/**Attributes**/
private ArrayList<Player> players = new ArrayList<>();      //ArrayList that stores different player types (player 1, player 2, player3) for the game

/**Methods**/
//Creates the players for the game
public void loadPlayers(){
    Scanner scanner = new Scanner(System.in);       //New scanner object to get the name of Player1 from the user
    /**Create Player 1 that represents the user**/
    System.out.print("Player1, please enter your name: ");        //User enters their name
    String UserName = scanner.nextLine();       //Input is stored into UserName

    Player1 User = new Player1(UserName);       //Create new Player1 object that represents the user; the name entered by the user will be displayed on the scoreboard, score is set to zero using constructor

    /**Create Player 2 that represents CPU1**/
    Player2 CPU1 = new Player2("CPU1");    //Create new Player2 object that represents CPU1; score is set to zero using constructor

    /**Create Player 3 that represents CPU2**/
    Player3 CPU2 = new Player3("CPU2");    //Create new Player3 object that represents CPU2; score is set to zero using constructor

    /**Add each player generated to the ArrayList**/
    players.add(User);
    players.add(CPU1);
    players.add(CPU2);
}


//Displays player scores at the end of each round
public void displayPlayersScores(){
    for(Player player : players){      //When we access each element from the list here we are essentially converting it into a player object
           player.displayPlayerScore();              //Call displayPlayerScore(); from Player class
        }

}
//Returns list of players
public ArrayList<Player> getPlayers() {
    return players;
}
}
