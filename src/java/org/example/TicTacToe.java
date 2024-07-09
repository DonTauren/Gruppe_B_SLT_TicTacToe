package java.org.example;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    protected Player currentPlayer;
    protected Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start(Scanner sc) {
        board.clear();
        board.print();
        while (!board.isFull()) {
            System.out.print("Player " + currentPlayer.getMarker() + ", enter your move (row, 1-3): ");
            int x = sc.nextInt() - 1;
            System.out.print("Player " + currentPlayer.getMarker() + ", enter your move (column, 1-3): ");
            int y = sc.nextInt() - 1;

            if (x < 0 || x >= 3 || y < 0 || y >= 3) {
                System.out.println("This move is out of bounds!");
            } else if (!board.isCellEmpty(x, y)) {
                System.out.println("This cell is already occupied!");
            } else {
                board.place(x, y, currentPlayer.getMarker());
                board.print();
                switchCurrentPlayer();
            }
        }
    }

    protected void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.start(sc);
        sc.close();
    }
}
