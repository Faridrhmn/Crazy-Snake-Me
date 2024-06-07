package id.dojo.things;

import id.dojo.model.Points;

public interface AnimalBehavior {
    Points checkForward();
    void stepForward(Board board);
    Cell checkLeft();
    void moveLeft(Board board);
    Cell checkRight();
    void moveRight(Board board);
    void eat();
}