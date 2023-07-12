package LLD.Practice.snakeAndLadder.models;

import lombok.Getter;

@Getter
public class Cell {
    int index;
    Player player;
    public Cell(int index){
        this.index=index;
    }
    public Cell(int index, Player player){
        this.index=index;
    }
}
