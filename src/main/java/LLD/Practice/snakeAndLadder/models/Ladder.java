package LLD.Practice.snakeAndLadder.models;

import lombok.Getter;

@Getter
public class Ladder extends SpecialEntity{
    int start;
    int end;
    Ladder(int start, int end){
        super(TYPE.LADDER);
        this.start=start;
        this.end=end;
    }
}
