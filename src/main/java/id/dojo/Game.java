package id.dojo;

import id.dojo.model.Points;
import id.dojo.things.Board;
import id.dojo.things.Cell;
import id.dojo.things.Snake;
import id.dojo.things.Wall;

import java.io.IOException;
import java.util.List;

// Class untuk mengontroll jalannya game, mengatur board, snake, dll
public class Game {
    private Board board;
    private List<Wall> walls;
    private Snake snake;
    private int speed;

    public void render() throws InterruptedException, IOException {
        while(true){
            board.displayBoard();
            snake.stepForward(board);
            Thread.sleep(100);

//            new ProcessBuilder("cls").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public Game(Builder builder){
        this.board = builder.board;
        this.walls = builder.walls;
        this.snake = builder.snake;
        this.speed = builder.speed;
    }

    public static class Builder{
        Board board;
        List<Wall> walls;
        Snake snake;
        int speed;

        public Builder createBoard(int row, int col){
            board = new Board("Board", "", row, col);

            return this;
        }

        public Builder createWalls(){
            //method untuk membuat dinding area game
            int row = board.getRow();
            int col = board.getCol();
            int temp = 0;

            for(int i = 0; i < row; i++){
                for(int j = 0; j< col; j++){
                    System.out.println("c");
                    if(i == 0 || i == row - 1 || j == 0 || j == col - 1){
                        board.putObject(new Points(i,j), new Wall("Wall", " * "));
                        temp = j;
                    }
                }
//                board.putObject(new Points(i,temp), new Wall("Wall", "x"));
            }
            return this;
        }


        public Builder createSnake(Snake snake){
            this.snake = snake;
            return this;
        }

        //dipake untuk membuat objek ular dan fruit
        public Builder generatePopulation(){
            board.putObject(snake.getHead(), snake);
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }
}