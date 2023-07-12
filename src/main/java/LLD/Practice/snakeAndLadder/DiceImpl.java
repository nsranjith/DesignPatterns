package LLD.Practice.snakeAndLadder;

import LLD.Practice.snakeAndLadder.models.Dice;

import java.util.Random;

public class DiceImpl implements Dice {
    @Override
    public int roll(int max) {
        return new Random().nextInt(max);
    }
}
