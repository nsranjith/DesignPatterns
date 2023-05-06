package LLD.TicTacToe.models;

import LLD.TicTacToe.Exception.InvalidMove;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    String name;
    PlayerType type;
    char symbol;

    public Player(String name, PlayerType type, char symbol) {
        this.name = name;
        this.type = type;
        this.symbol = symbol;
    }

    public Move decideMove(Board board) throws InvalidMove {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Pls. enter the row and col");
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        return new Move(new Cell(row,col));
    }
}
