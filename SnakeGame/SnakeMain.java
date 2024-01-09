package SnakeGamePractice;

import java.util.LinkedList;

public class SnakeMain {

    public static void main(String[] args) throws InterruptedException{
        Frame f = new Frame(10, 50);
        Food food = new Food();
        food.setRow(2);
        food.setCol(2);

        LinkedList <MakeSnake> snake = new LinkedList<>();
        snake.add(new MakeSnake(5, 15, "@"));
        snake.add(new MakeSnake(5, 16, "*"));
        snake.add(new MakeSnake(5, 17, "*"));
        snake.add(new MakeSnake(5, 18, "*"));
        snake.add(new MakeSnake(5, 19, "*"));
        snake.add(new MakeSnake(5, 20, "*"));

        System.out.println("Enter direction to start");
        Character move = 'w';

        Input input = new Input(move);
        Thread inputThread = new Thread(input);
        inputThread.start();

        while(true) {
            move = input.ch;
            f.walls();
            f.displayFood(food);
            f.displaySnake(snake);
            f.displayFrame();
            System.out.println(move);

            int lastRow = snake.get(snake.size() - 1).getRow();
            int lastCol = snake.get(snake.size() - 1).getCol();

            if(move == 'w') {
                f.moveUp(snake);
            }
            else if(move == 's') {
                f.moveBottom(snake);
            }
            else if(move == 'a') {
                f.moveLeft(snake);
            }
            else if(move == 'd') {
                f.moveRight(snake);
            }

            if (f.checkSnakeAteFood(snake, food)) {
                snake.add(new MakeSnake(lastRow, lastCol, "*"));
                f.setRandomFoodLocation(food);
            }

            Thread.sleep(1000);
        }

    }
}
