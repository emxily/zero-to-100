import  java.util.Random;               //Used for random board values
import java.util.Scanner;               //Used to get user input for generating the board

public class Board {
    /**Members**/
    boolean [][] alreadyCaptured;       //Holds if each location on the game board has already been selected
    char [][] board;                    //2D Array for the Display Board
    int  [][] values;                   //2D Array for Value Board
    private int sum;                    //Sum of remaining spaces
    private int spacesRemaining;        //Count for spaces remaining
    private int maxValue;               //Max value remaining on the board
    private int rowCount;               //Number of rows on boards
    private int colCount;               //Number of columns on boards



    /**Constructor**/
    Board(){}       //Deafault constructor - does not initilize attributes

    /**Methods**/
    //Generates game board 
    public void GenerateBoard(){
        Random random = new Random();                                 //New random object
        
        for(int row = 0; row < rowCount; row++) {                     //Iterate through each row of the 2D Array
            for(int col = 0; col < colCount; col++) {                 //Iterate through each column of the 2D Array
                board[row][col] = '*';                                //Each space on the board is filled with * until the space is selected by a player
                values[row][col] = random.nextInt(9) + 1;       //Each space has a randomly generate value ranging from 1-9
            }
        }
    }

    //Creates a new board using dimensions given by the user (minimum is 5x5)
    public void initializeBoard() { 
        Scanner scanner = new Scanner(System.in);       //Instantiate Scanner object to read user input

        while (true) {      //Loop until user enters valid board dimenstions
            /**Get number of board rows and coulmns from the user**/
            System.out.println();
            System.out.println("Enter game board dimensions (minimum 5x5)");    
            System.out.print("Enter number of rows: ");
            rowCount = scanner.nextInt();   //Stores board rows
            System.out.print("Enter number of columns: "); 
            colCount = scanner.nextInt();   //Stores board columns

            /**Board must have at least 5 rows and 5 columns**/
            if (rowCount >= 5 && colCount >= 5) {
                break;      //Exit the loop if both rowCount and colCount are at least 5
            } else {
                System.out.println("Minimum game board dimension must be 5x5. Please try again.");
            }
        }
    
        //Initialize 2D arrays with user-given dimensions
        board = new char[rowCount][colCount];
        values = new int[rowCount][colCount];
        alreadyCaptured = new boolean[rowCount][colCount];

        GenerateBoard();  //Call method to generate the board with updated dimensions
        
    }

    //Calculates the sum of remaining space values, the max value remaining, and number of remaining spaces of the game board
    public void UpdateBoardData()
    {   //Start values at zero to make sure they are calculated right each time
         sum = 0;
         spacesRemaining = 0;
         maxValue = 0;


        for (int row = 0; row < rowCount; row++) {      //Iterate through each row of the 2D Array
            for (int col = 0; col < colCount; col++) {  //Iterate through each column of the 2D Array
                if (board[row][col] == '*') {   
                    sum += values[row][col];   //If the space has * add the value at that location to sum which is the sum of all remaining spaces  
                    spacesRemaining++;         //if the space has * add 1 to the number of remaining spaces
                    if (values[row][col] > maxValue) {  //Checks if any board values are higher than current value in maxValue
                        maxValue = values[row][col];    //If so that is the new max value
                    }
                }
            }
        }
    }

    //Displays game board and board stats
    public void DisplayBoard()
    {
        UpdateBoardData();      //Calls UpdateBoardData
        System.out.println();
        for(int row = 0; row < rowCount; row++) {
            for(int col = 0; col < colCount; col++) {
                System.out.print(board[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        DisplayBoardData();     //Calls DisplayBoardData
        System.out.println();
    }

    //Displays the sum, max, and spaces remaining of the game board
    public void DisplayBoardData()
    {
        System.out.println("Sum Remaining: \t\t\t\t" + sum);
        System.out.println("Spaces Remaining: \t\t\t" + spacesRemaining);
        System.out.println("Highest Value Remaining: \t\t" + maxValue);
    }

    //Method to capture spaces and calculate those three values together
    //For each loop inspired by my ChainReactionMain solution
    public int captureSpaces(int[][] selectedSpaces) {
        int turnsum = 0; //Holds the selected values added together
        for (int[] space : selectedSpaces) {    //Space is a 1D array that holds row and column of a selected space  
            int row = space[0];     //Row index from the space array
            int col = space[1];     //Coumn index from space array
            board[row][col] = (char) (values[row][col] + '0'); //Converts the int value of a space to the char equivelent so it can be stored in board; array can only have 1 data type
            turnsum += values[row][col]; //Add each value of the selected spaces
        }
        UpdateBoardData(); //Update board data after capturing spaces
        return turnsum;
    }

    //Check if all spaces on the board have been captured
    public boolean isGameOver(PlayerList PlayerList) {
        //If a player score = 100 
        for(Player player : PlayerList.getPlayers()){   //For each player in the playerlist 
            if(player.getScore() >= 100){   //If the player score = 100
                return true;    //Return true
            }
            
        }
        for (int row = 0; row < rowCount; row++) {  //Iterate through each row 
            for (int col = 0; col < colCount; col++) {  //Iterate through each column
                if (board[row][col] == '*') {   //'*' means not captured
                    return false; //Game is not over if there is at least one '*' remaining
                }
            }
        }
        return true; //Game is over if no '*' are found
        
    }

    /**Accessors**/
    public char getBoard(int row, int col) {
        return board[row][col];
    }

    public int getValues(int row, int col) {
        return values[row][col];
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }

} 
