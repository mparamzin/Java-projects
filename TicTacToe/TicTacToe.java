import java.util.*;

public class TicTacToe {

    static List<Integer> playerAllPosition = new ArrayList<Integer>();
    static List<Integer> cpuAllPosition = new ArrayList<Integer>();

    public static void main(String[] args) {
        char [][] board = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
        int [] passedPositions = new int[10];

        while (true) {
            printGameBoard(board);

            Scanner choice = new Scanner(System.in);
            System.out.println("Enter your placement (1-9)");
            int playerPosition = choice.nextInt();
            while ((playerAllPosition.contains(playerPosition)) | (cpuAllPosition.contains(playerPosition))){
                System.out.println("You can't place this position. It's already taken");
                playerPosition=choice.nextInt();
            }
            playerAllPosition.add(playerPosition);

            placePiece(board, playerPosition, "player");

            if (checkWinner()!="0"){
                System.out.println(checkWinner());
                printGameBoard(board);
                break;}

            Random rand = new Random();
            int cpuPosition = rand.nextInt(1, 10);
            while ((playerAllPosition.contains(cpuPosition)) | (cpuAllPosition.contains(cpuPosition))){
                cpuPosition=rand.nextInt(1,10);
            }
            cpuAllPosition.add(cpuPosition);
            placePiece(board, cpuPosition, "cpu");

            if (checkWinner()!="0"){
                System.out.println(checkWinner());
                printGameBoard(board);
                break;
            }
        }
    }

    public static void printGameBoard(char [] [] board){
        for (char [] row: board){
            for(char elem: row) {
                System.out.print(elem);
            }
            System.out.print('\n');
        }
    }
    public static void placePiece(char [] [] board, int position, String user){
        char symbol=' ';
            if (user=="player"){
                symbol='X';
            } else if (user=="cpu"){
                symbol='O';
            }

            switch(position){
                case 1:
                    board[0][0]=symbol;
                    break;
                case 2:
                    board[0][2]=symbol;
                    break;
                case 3:
                    board[0][4]=symbol;
                    break;
                case 4:
                    board[2][0]=symbol;
                    break;
                case 5:
                    board[2][2]=symbol;
                    break;
                case 6:
                    board[2][4]=symbol;
                    break;
                case 7:
                    board[4][0]=symbol;
                    break;
                case 8:
                    board[4][2]=symbol;
                    break;
                case 9:
                    board[4][4]=symbol;
                    break;

            }
        }


        public static String checkWinner(){
            List topRow = Arrays.asList(1,2,3);
            List midRow = Arrays.asList(4,5,6);
            List belRowG = Arrays.asList(7,8,9);
            List diagRowMain= Arrays.asList(1,5,9);
            List diagRowPoboch=Arrays.asList(3,5,7);
            List leftRow= Arrays.asList(1,4,7);
            List midRowV= Arrays.asList(2,5,8);
            List rightRow= Arrays.asList(3,6,9);
            List<List> winningConditions= new ArrayList<List>();
            winningConditions.add(topRow);
            winningConditions.add(midRow);
            winningConditions.add(belRowG);
            winningConditions.add(diagRowMain);
            winningConditions.add(diagRowPoboch);
            winningConditions.add(leftRow);
            winningConditions.add(midRowV);
            winningConditions.add(rightRow);


            for (List a: winningConditions){
                if (playerAllPosition.containsAll(a)){
                    return ("Congratulations! You won!");
                } else if (cpuAllPosition.containsAll(a)){
                    return ("CPU wins. You lost!");
                } else if (cpuAllPosition.size()+playerAllPosition.size()==9){
                    return ("CAT");
                }
            }
            return "0";
        }

    }
