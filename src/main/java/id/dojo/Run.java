package id.dojo;

import id.dojo.things.Snake;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        int row = 20;
        int col = 20;

        int posX = 3;
        int posY = 3;

        Snake snake = Snake.getBuilder()
                .setName("Ular")
                .setAppearance("o")
                .setPosition(posX, posY)
                .setSize(6)
                .build();
        snake.generateBody();
        Game game = Game.getBuilder()
                .createBoard(row, col)
                .createWalls()
                .createSnake(snake)
                .generatePopulation()
                .build();

        try {
            game.render();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
  }

    }
}