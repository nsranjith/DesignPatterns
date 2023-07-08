package LLD.Practice.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;
@AllArgsConstructor
@Getter
public class Player {
    String name;
    char symbol;
    PlayerType playerType;

    public Move decideMove() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Pls. enter the row and col");
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        return new Move(new Cell(row,col));
    }
}
