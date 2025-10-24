

public class Player3 extends Player {      //CPU2
    /**Constructor**/
    public Player3(String name) {       //Initilizes name
        super(name, 0);     //score starts at zero
    }

    /**Methods**/
    @Override
    public void captureSpaces(Board board) {
        int[][] selectedSpaces = new int[3][2];     //2D Array to store selected spaces locations and if they were the 1,2, or 3rd number selected this round
        int capturedCount = 0;  //Holds number of spaces selected

        /**
         * Thought process:
         * Originally tried for loop then while true but got an error,
         * then realized i can just iterate through board until '*' is found.
         * 
         * Knew i only needed 3 spaces to stop the turn so used that to stop loops
         */


        //Iterates through array to find first 3 uncaptured spaces
        for (int row = 0; row < board.getRowCount(); row++) {
            for (int col = 0; col < board.getColCount(); col++) {
                if (board.getBoard(row, col) == '*' && capturedCount < 3) { //Check if the space is available and if we need more spaces
                    selectedSpaces[capturedCount][0] = row;
                    selectedSpaces[capturedCount][1] = col;
                    board.alreadyCaptured[row][col] = true; //Mark the space as captured
                    capturedCount++; //Add to the count of successfully captured spaces

                    if (capturedCount == 3) {
                        break; //Exit the loop once 3 spaces have selected
                    }
                }
            }
            if (capturedCount == 3) {
                break; //Exit the loop if we've selected enough spaces
            }
        }
        calculateScore(selectedSpaces, board);  //Call method to capture spaces, display values captured, calculate bonus points, and add to score
    }
}