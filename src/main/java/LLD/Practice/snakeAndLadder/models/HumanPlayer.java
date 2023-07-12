package LLD.Practice.snakeAndLadder.models;

public class HumanPlayer extends Player{
    String name;

    HumanPlayer(String name, char symbol){
        super(symbol);
    }
    public Move makeMove(Player player, Dice dice){
        int pos=dice.roll(6);
        return new Move(new Cell(pos,player));
    }
}
