package LLD.Practice.snakeAndLadder.models;

import lombok.Getter;

@Getter
public class Snake extends SpecialEntity{
    int start;
    int end;
    Snake(int start, int end){
        super(TYPE.SNAKE);
        this.start=start;
        this.end=end;
    }
}
