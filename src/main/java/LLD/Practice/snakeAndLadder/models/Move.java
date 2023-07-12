package LLD.Practice.snakeAndLadder.models;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class Move {
    Cell cell;
    public Move(Cell cell) {
        this.cell=cell;
    }
}
