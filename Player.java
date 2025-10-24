
public abstract class Player {
/**Attributes**/
private String name;        //Stores the player name
private int score;          //Stores the player score


/**Constructor**/
public Player(String name, int score) {     //Constructor that initializes name and score
    this.name = name;
    this.score = score;
}


/**Methods**/
abstract public void captureSpaces(Board board);       //Player captures 3 spaces on the board; different depending on the player

//Method to check for the duplicate number bonus
public boolean checkDuplicateBonus(int[][] selectedSpaces, Board board) {
    for (int i = 0; i < selectedSpaces.length; i++) {
        int value1 = board.getValues(selectedSpaces[i][0], selectedSpaces[i][1]); //Get value at first selected space on the board
        for (int j = i + 1; j < selectedSpaces.length; j++) {   //Compare wth all values selected after that oe 
            int value2 = board.getValues(selectedSpaces[j][0], selectedSpaces[j][1]); //Get second value
            if (value1 == value2) {
                return true; //Found a duplicate value
            }
        }
    }
    return false; //No duplicates found
    }


    //Method to check for increasing sequence bonus
    public boolean checkIncreasingSequenceBonus(int[][] selectedSpaces, Board board) {
       
        for (int i = 1; i < selectedSpaces.length; i++) {//Starting at the second element 
            int prevValue = board.getValues(selectedSpaces[i - 1][0], selectedSpaces[i - 1][1]); //Get value of previously selected space
            int currValue = board.getValues(selectedSpaces[i][0], selectedSpaces[i][1]);    //Get the value of current space
                if (currValue <= prevValue) {  //If current value is not less
                    return false;
                }
            }
        return true;
    }

    //Method to check for decreasing sequence bonus
    public boolean checkDecreaseSequenceBonus(int[][] selectedSpaces, Board board) {
    for (int i = 1; i < selectedSpaces.length; i++) {//Starting at the second element 
        int prevValue = board.getValues(selectedSpaces[i - 1][0], selectedSpaces[i - 1][1]);    //Get value of previously selected space
        int currValue = board.getValues(selectedSpaces[i][0], selectedSpaces[i][1]);    //Get the value of current space
        if (currValue >= prevValue) {  //If current value is not more
            return false;
        }
    }
    return true;
}

    //Method to add score
    public void addScore(int score) {   //Adds an amount to a player's score
        this.score += score;
    }

    //Calculate bonus for selected values that round
    public void calculateScore(int[][] selectedSpaces, Board board){
        //Capture spaces and get score
        int sum = board.captureSpaces(selectedSpaces);      //Store the number returned from capturedSpaces in sum

        //Display selected numbers
        System.out.print(getName() + "'s Numbers Selected: ");
        for (int i = 0; i < selectedSpaces.length; i++) {
            int value = board.getValues(selectedSpaces[i][0], selectedSpaces[i][1]);
            System.out.print(value + " ");
        }

        //Check for scoring bonuses
        if (checkIncreasingSequenceBonus(selectedSpaces, board)) {
            System.out.println("\nNumbers Increase Sequentially! Points 2x");
            sum = sum * 2; //Double the sum if sequence bonus applies

        } else if (checkDecreaseSequenceBonus(selectedSpaces, board)) {
            System.out.println("\nNumbers Decrease Sequentially! Points 2x");
            sum = sum * 2; //Double the sum if decreasing sequence bonus applies

        } else if (checkDuplicateBonus(selectedSpaces, board)) {
            System.out.println("\nNumbers Match! Points 2x");
            sum = sum * 2; //Double the sum if duplicate bonus applies
       
        } else{
            System.out.println("\nNo Bonus This Time");
        }
        System.out.println();

        addScore(sum); //Add sum to the player's total score
    }

//Displays Player score
public void displayPlayerScore(){
    System.out.println(name + "'s Score: \t\t\t"+ score);
}

/**Accessors**/
public String getName() {
    return name;
}

public int getScore() {
    return score;
}
}







