package LLD.Practice.snakeAndLadder.models;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
public class Board extends BaseModel {
    int size;
    List<Cell> cell;
    List<SpecialEntity> specialEntities;
    HashMap<Integer,SpecialEntity> map;

    public Board(int size, List<Cell> cell, List<SpecialEntity> specialEntities, HashMap<Integer, SpecialEntity> map) {
        this.size = size;
        this.cell = cell;
        this.specialEntities = specialEntities;
        this.map = map;
    }
}
