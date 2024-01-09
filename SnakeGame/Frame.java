package SnakeGamePractice;

import java.util.LinkedList;

public class Frame {
    String arr[][];
    int size;
    int snakeCol = 20;
    int snakeRow = 5;
    public Frame(int row, int col) {
      arr = new String[row][col];
    }
    public void walls() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(j == 0 || j == arr[0].length - 1) {
                    arr[i][j] = "|";
                }
                else if((i == 0 && j > 0 && j < arr[0].length) || (i == arr.length - 1 && j > 0 && j < arr[0].length)) {
                    arr[i][j] = "-";
                }
                else {
                    arr[i][j] = " ";
                }
            }
        }
    }
    public void displayFrame() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public void displayFood(Food food) {
        arr[food.getRow()][food.getCol()] = "0";
    }
    public void displaySnake(LinkedList<MakeSnake>snake) {
        for(int i = 0; i < snake.size(); i++) {
            arr[snake.get(i).getRow()][snake.get(i).getCol()] = snake.get(i).getSymbol();
        }
    }
    public void moveBottom(LinkedList <MakeSnake> snake) {
        LinkedList <MakeSnake> prev = new LinkedList<>();
        for(int i = 0; i < snake.size(); i++) {
            prev.add(new MakeSnake(snake.get(i).getRow(), snake.get(i).getCol(), snake.get(i).getSymbol()));
        }

        int row = -1;
        int col = -1;
        for(int i = 0; i < snake.size(); i++) {
            if(i == 0) {
                row = snake.get(i).getRow();
                col = snake.get(i).getCol();
                row = row + 1;
                if(row >= arr.length) {
                    row = 0;
                }
                arr[row][col] = snake.get(i).getSymbol();
                snake.get(i).setRow(row);
            }
            else {
                row = prev.get(i - 1).getRow();
                col = prev.get(i - 1).getCol();
                snake.get(i).setRow(row);
                snake.get(i).setCol(col);
                arr[row][col] = snake.get(i).getSymbol();
            }
        }
    }

    public void moveRight(LinkedList <MakeSnake> snake) {
        LinkedList <MakeSnake> prev = new LinkedList<>();
        Food food = new Food();
        for(int i = 0; i < snake.size(); i++) {
            prev.add(new MakeSnake(snake.get(i).getRow(), snake.get(i).getCol(), snake.get(i).getSymbol()));
        }

        int row = -1;
        int col = -1;
        for(int i = 0; i < snake.size(); i++) {
            if(i == 0) {
                row = snake.get(i).getRow();
                col = snake.get(i).getCol();
                col = col + 1;
                if(col >= arr[0].length) {
                    col = 0;
                }
                arr[row][col] = snake.get(i).getSymbol();
                snake.get(i).setCol(col);
            }
            else {
                row = prev.get(i - 1).getRow();
                col = prev.get(i - 1).getCol();
                snake.get(i).setRow(row);
                snake.get(i).setCol(col);
                arr[row][col] = snake.get(i).getSymbol();
            }
        }
    }

    public void moveUp(LinkedList <MakeSnake> snake) {
        LinkedList <MakeSnake> prev = new LinkedList<>();

        for(int i = 0; i < snake.size(); i++) {
            prev.add(new MakeSnake(snake.get(i).getRow(), snake.get(i).getCol(), snake.get(i).getSymbol()));
        }

        int row = -1;
        int col = -1;
        for(int i = 0; i < snake.size(); i++) {
            if(i == 0) {
                row = snake.get(i).getRow();
                col = snake.get(i).getCol();
                row = row - 1;
                if(row == -1) {
                    row = arr.length - 1;
                }
                arr[row][col] = snake.get(i).getSymbol();
                snake.get(i).setRow(row);
            }
            else {
                row = prev.get(i - 1).getRow();
                col = prev.get(i - 1).getCol();
                snake.get(i).setRow(row);
                snake.get(i).setCol(col);
                arr[row][col] = snake.get(i).getSymbol();
            }
        }
    }

    public void moveLeft(LinkedList <MakeSnake> snake) {
        LinkedList <MakeSnake> prev = new LinkedList<>();
        Food food = new Food();
        for(int i = 0; i < snake.size(); i++) {
            prev.add(new MakeSnake(snake.get(i).getRow(), snake.get(i).getCol(), snake.get(i).getSymbol()));
        }

        int row = -1;
        int col = -1;
        for(int i = 0; i < snake.size(); i++) {
            if(i == 0) {
                row = snake.get(i).getRow();
                col = snake.get(i).getCol();
                col = col - 1;
                if(col == -1) {
                    col = arr[0].length - 1;
                }
                arr[row][col] = snake.get(i).getSymbol();
                snake.get(i).setCol(col);
            }
            else {
                row = prev.get(i - 1).getRow();
                col = prev.get(i - 1).getCol();
                snake.get(i).setRow(row);
                snake.get(i).setCol(col);
                arr[row][col] = snake.get(i).getSymbol();
            }
        }
    }

    public boolean checkSnakeAteFood(LinkedList<MakeSnake> snake, Food food) {
        int snakeMouthRow = snake.get(0).getRow();
        int snakeMouthCol = snake.get(0).getCol();

        if(snakeMouthRow == food.getRow() && snakeMouthCol == food.getCol()) {
            return true;
        }

        return false;
    }

    public void setRandomFoodLocation(Food food) {
        food.setRow(getRandomNumber(1, this.snakeRow - 1));
        food.setCol(getRandomNumber(1, this.snakeCol - 1));
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
