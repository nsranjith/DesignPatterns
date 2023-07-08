package LLD.Practice.TicTacToe.strategy;

import LLD.Practice.TicTacToe.model.Board;
import LLD.Practice.TicTacToe.model.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    static WinningStrategy rowWinningStrategy=null;
    static List<HashMap<Character,Integer>> rowMap=new ArrayList<>();
    static List<HashMap<Character,Integer>> colMap=new ArrayList<>();
    HashMap<Character,Integer> leftDiag=new HashMap<>();
    HashMap<Character,Integer> rightDiag=new HashMap<>();
    private  RowWinningStrategy(int dim){
        for(int i=0;i<dim;i++){
            HashMap<Character,Integer> row=new HashMap<>();
            HashMap<Character,Integer> col=new HashMap<>();
            rowMap.add(row);
            colMap.add(col);
        }
    }
    public static WinningStrategy getInstance(int dimension){
        if(rowWinningStrategy==null){ // two threads
            synchronized (RowWinningStrategy.class){ // one gets passed, other in hold
                if (rowWinningStrategy==null){ // double check locking
                    // if double check is missing 2 instances will be created
                    rowWinningStrategy=new RowWinningStrategy(dimension);
                }
            }
        }
        return rowWinningStrategy;
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
    public boolean isWinner(Board board, Cell cell) {
        char symbol=cell.getPlayer().getSymbol();
        int row=cell.getRow();
        int col=cell.getCol();
        int dimension=board.getDimesnsion();
        HashMap<Character,Integer> map=rowMap.get(row);
        if(map.containsKey(symbol)){
            map.put(symbol,map.getOrDefault(symbol,0)+1);
        }else{
            map.put(symbol,map.getOrDefault(symbol,0)+1);
        }
        if(map.get(symbol) ==dimension) return true;
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
