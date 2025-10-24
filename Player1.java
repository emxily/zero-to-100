

import java.util.Scanner;

public class Player1 extends Player {


    /**Constructor**/
    public Player1(String name) {       //Initilizes name
        super(name, 0);     //Score starts at zero
    }

    /**Methods**/
    @Override
    public void captureSpaces(Board board) {
        Scanner scanner = new Scanner(System.in);       //Instantiate Scanner object to read user input
        int[][] selectedSpaces = new int[3][2];     //2D Array to store selected spaces locations and if they were the 1,2, or 3rd number selected this round
        
        
        for(int i = 0; i < 3; i++){     //Loop until 3 spaces are captured
            while(true){
        /**Prompt user to enter the row and column of spaces they want to capture**/
        System.out.println("Enter row and column of space you want to capture");
        System.out.print("Enter a row: ");
        int row = scanner.nextInt(); 
        System.out.print("Enter a column: ");
        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        //Check if the location is marked true in alreadyCaptured
        if (!board.alreadyCaptured[row][col]) {     //If the space has not already been captured
            board.alreadyCaptured[row][col] = true; //Mark the space as captured
            selectedSpaces[i][0] = row; //Store the row of the captured space i = index- if it was selected first, second, third 0 = row
            selectedSpaces[i][1] = col; //Store the column of the captured space i = index- if it was selected first, second, third 1 = column
                                           
            break; //Exit the loop and move to the next space
        } else {
            System.out.println("Already captured. Please select another space.");
        }
    }
    }
    calculateScore(selectedSpaces, board);  //Call method to capture spaces, display values captured, calculate bonus points, and add to score
    }
}
