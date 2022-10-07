import java.util.Scanner;
public class TicTacToe {
    static int row;
    static int column;
    String symbol;
    public static boolean ongoing=true;
    //Constructor
    public TicTacToe(String sym, int rows, int columns){
        symbol=sym;
        row=rows;
        column=columns;
    }

    public static void main(String[] args) {
        String[][] game = new String[3][3];
        TicTacToe player1 = new TicTacToe("|X|", 0, 0);
        TicTacToe player2 = new TicTacToe("|O|", 0, 0);
        while(true){
            createGame(game);
            move();
            System.out.println("X starts.");

            while (ongoing == true) {
                Scanner row_choice = new Scanner(System.in);
                Scanner column_choice = new Scanner(System.in);
                //Player 1 interface
                System.out.println("====PLAYER 1 MOVE====.");
                System.out.println("Enter number of the row: ");
                player1.row = row_choice.nextInt();
                System.out.println("Enter number of the column: ");
                player1.column = column_choice.nextInt();
                System.out.println("Player1 move: [" + player1.row + "][" + player1.column + "]");
                displayGame(game, player1.row, player1.column, player1.symbol);
                checkWinner(game, player1.symbol);
                if (ongoing == false) {
                    break;
                }
                //Player 2 interface
                System.out.println("====PLAYER 2 MOVE====");
                System.out.println("Enter number of the row: ");
                player2.row = row_choice.nextInt();
                System.out.println("Enter number of the column: ");
                player2.column = column_choice.nextInt();
                System.out.println("Player2 move: [" + player2.row + "][" + player2.column + "]");
                displayGame(game, player2.row, player2.column, player2.symbol);
                checkWinner(game, player2.symbol);
            }
        }
    }
    //Display initial gameboard
    public static void createGame(String play[][]){
        System.out.println("Welcome to TicTacToe!!!");
        for(int i=0;i<play.length;i++){
            for(int j=0;j<play[i].length;j++){
                play[i][j]="|_|";
                System.out.print(play[i][j]);
            }
            System.out.print("\n");
        }
    }
    //Let the user choose the action at the beginning
    public static void move(){
        System.out.println("Choose action(number): ");
        System.out.println("1:Start Game");
        System.out.println("2:Quit");
        Scanner choice= new Scanner(System.in);
        String choose=choice.nextLine();
        ongoing=true;
        switch(choose){
            case "1":
                System.out.println("Game starts");
                break;
            case "2":
                System.exit(0);
                break;
            default:
                System.out.println("Press correct number");
        }
    }
    //Display current state of the game
    public static void displayGame (String g[][], int r, int c, String s){
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (i == r - 1 && j == c - 1 && g[i][j]=="|_|") {
                    g[i][j] = s;
                }
                System.out.print(g[i][j]);
                }
            System.out.print("\n");
            }
        }
    //Check game stat and announce winner
    public static void checkWinner(String checkWin[][], String s){
        if(checkWin[0][0].equals(s) && checkWin[0][1].equals(s) &&checkWin[0][2].equals(s)){
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[1][0].equals(s) && checkWin[1][1].equals(s) &&checkWin[1][2].equals(s)){
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[2][0].equals(s) && checkWin[2][1].equals(s) &&checkWin[2][2].equals(s)){
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[0][0].equals(s) && checkWin[1][0].equals(s) &&checkWin[2][0].equals(s)){
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[0][1].equals(s) && checkWin[1][1].equals(s) &&checkWin[2][1].equals(s)) {
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[0][2].equals(s) && checkWin[1][2].equals(s) &&checkWin[2][2].equals(s)) {
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[0][0].equals(s) && checkWin[1][1].equals(s) &&checkWin[2][2].equals(s)) {
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }
        else if(checkWin[0][2].equals(s) && checkWin[1][1].equals(s) &&checkWin[2][0].equals(s)) {
            ongoing=false;
            System.out.println("Congratulations!!!"+s+"wins");
        }else if(checkWin[0][0]!="|_|" && checkWin[1][0]!="|_|" && checkWin[2][0]!="|_|" && checkWin[0][1]!="|_|" && checkWin[1][1]!="|_|" && checkWin[2][1]!="|_|" && checkWin[0][2]!="|_|" && checkWin[1][2]!="|_|" && checkWin[2][2]!="|_|"){
            ongoing=false;
            System.out.println("It's a draw!");
        }
    }
}


