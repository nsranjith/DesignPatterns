package LLD.TicTacToe.Strategies;

import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Cell;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;

public class GameWinningStrategy implements  WinningStrategy{
    static List<HashMap<Character,Integer>> rowMap=new ArrayList<>();
    static List<HashMap<Character,Integer>> colMap=new ArrayList<>();
    HashMap<Character,Integer> leftDiag=new HashMap<>();
    HashMap<Character,Integer> rightDiag=new HashMap<>();
    private static GameWinningStrategy gameWinningStrategy;
    public static GameWinningStrategy getGameWinningStrategy(int dimension) {
        if(gameWinningStrategy==null){
            synchronized (GameWinningStrategy.class){
                if(gameWinningStrategy==null){
                    gameWinningStrategy=new GameWinningStrategy();
                }
            }
        }
        for(int i=0;i<dimension;i++){
            HashMap<Character,Integer> rows=new HashMap<>();
            HashMap<Character,Integer> cols=new HashMap<>();
            rowMap.add(rows);
            colMap.add(cols);
        }
        return gameWinningStrategy;
    }

    public boolean isTopLeftDiag(int row, int col){
        if(row==col){
            return true;
        }
        return false;
    }

    public boolean isTopRightDiag(int row, int col, int dimension){
        if((row+col)==dimension-1){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkWinner(Board board, Cell cell) {
        char symbol=cell.getPlayer().getSymbol();
        int row=cell.getRow();
        int col=cell.getCol();
        int dimension=board.getDimension();
        HashMap<Character,Integer> map=rowMap.get(row);
        if(map.containsKey(symbol)){
            map.put(symbol,map.get(symbol)+1);
        }else{
            map.put(symbol,1);
        }
        if(map.get(symbol).intValue()==dimension) return true;
        HashMap<Character,Integer> mapCol=colMap.get(col);
        if(mapCol.containsKey(symbol)){
            mapCol.put(symbol,mapCol.get(symbol)+1);
        }else{
            mapCol.put(symbol,1);
        }

        if(mapCol.get(symbol).intValue()==dimension) return true;

        if(isTopLeftDiag(row,col)){
            if(leftDiag.containsKey(symbol)){
                leftDiag.put(symbol,leftDiag.get(symbol)+1);
            }else{
                leftDiag.put(symbol,1);
            }
            if(leftDiag.get(symbol).intValue()==dimension) return true;
        }

        if(isTopRightDiag(row,col,dimension)) {
            if (rightDiag.containsKey(symbol)) {
                rightDiag.put(symbol, rightDiag.get(symbol) + 1);
            } else {
                rightDiag.put(symbol, 1);
            }
            return rightDiag.get(symbol).intValue() == dimension;
        }
        return false;
    }
}
