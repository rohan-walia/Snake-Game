package SnakeGamePractice;

public class MakeSnake {
    private int row;
    private int col;
    private String symbol;
    public MakeSnake(int row, int col, String symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }

}
