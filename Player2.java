
import java.util.Random;

public class Player2 extends Player{      //CPU1
    /**Constructor**/
    public Player2(String name) {       //Initilizes name
        super(name, 0);     //score starts at zero
    }

    /**Methods**/
    @Override
    public void captureSpaces(Board board) {    //Selects spaces at random
        int[][] selectedSpaces = new int[3][2];     //2D Array to store selected spaces locations and if they were the 1,2, or 3rd number selected this round

        for (int i = 0; i < 3; i++){
            while(true){
                Random random = new Random();

                int row = random.nextInt(board.getRowCount()); //Generate random row
                int col = random.nextInt(board.getColCount()); //Generate random column

                //Check if the location is marked true in alreadyCaptured
                if (!board.alreadyCaptured[row][col]) {     //If the space has not already been captured
                board.alreadyCaptured[row][col] = true; //Mark the space as captured
                selectedSpaces[i][0] = row; //Store the row of the captured space i = index- if it was selected first, second, third 0 = row
                selectedSpaces[i][1] = col; //Store the column of the captured space i = index- if it was selected first, second, third 1 = column
                                           
                break; //Exit the loop and move to the next space
                }
        }
        
    }
    calculateScore(selectedSpaces, board);  //Call method to capture spaces, display values captured, calculate bonus points, and add to score
}
}
