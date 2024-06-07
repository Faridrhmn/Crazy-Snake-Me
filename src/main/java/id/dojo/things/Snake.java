package id.dojo.things;

import id.dojo.model.Points;

import java.util.ArrayList;
import java.util.List;

public class Snake extends Thing implements AnimalBehavior {

    private int size;
    private Points head;
    private List<Points> body;

    public Snake(Builder builder) {
        super(builder.getName(), builder.getAppearance());
        this.head = builder.getPosition();
        this.size = builder.getSize();
        body = new ArrayList<>();
    }

    public void generateBody(){
        int x = head.getX();
        for (int i = 1; i < size; i++) {
            body.add(new Points(x, head.getY() - 1));
        }

    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public Points getHead() {
        return head;
    }

    public void setHead(Points head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static class Builder{
        private int size;
        private String name;
        private String appearance;
        private int posX, posY;


        public int getSize(){
            return size;
        }

        public Builder setSize(int s){
            size = s;
            return this;
        }

        public String getName(){
            return name;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public String getAppearance(){
            return appearance;
        }

        public Builder setAppearance(String appearance){
            this.appearance = appearance;
            return this;
        }

        public Points getPosition(){
            return new Points(posX, posY);
        }

        public Builder setPosition(int x, int y){
            posX = x;
            posY = y;
            return this;
        }

        public Snake build(){
            return new Snake(this);
        }
    }

    @Override
    public Points checkForward() {
//        int xBefore = head.getX();
//        int yBefore = head.getY();
        int xPos = 0;
        int yPos = 0;

//        if(head.getX() - 1 == body.getFirst().getX()) {
//            xPos = head.getX()+1;
//            yPos = head.getY();
//        } else if (head.getY() - 1 == body.getFirst().getY()) {
//            xPos = head.getX();
//            yPos = head.getY()+1;
//        }
        return new Points(xPos,yPos);
    }

    @Override
    public void stepForward(Board board){
//        Points tail = body.remove(body.size() - 1);
//        board.putObject(head,null);
////        for(Points body: this.getBody()){
////            board.putObject(body,null);
////        }
//
//        int headXbefore2 = head.getX();
//        int headYbefore2 = head.getY();
//
//        Points newDirection = checkForward();
//
//        head.setX(newDirection.getX());
//        head.setY(newDirection.getY());
        int headXbefore = head.getX();
        int headYbefore = head.getY();
        board.putObject(head, null);
        for (Points bodPosisi : body) {
            board.putObject(bodPosisi, null);
        }
        Points tails = new Points(head.getX(), head.getY());
        int posX = head.getX();
        int posY = head.getY();
        head.setY(posY+1);
        Points follow = tails;
        for (int i = 0; i < body.size(); i++) {
            Points crnt = body.get(i);
            Points temp = new Points(crnt.getX(), crnt.getY());
            crnt.setX(follow.getX());
            crnt.setY(follow.getY());
            follow = temp;
            board.putObject(crnt, this);
        }
//        Random random = new Random();
//        int boundedInt = random.nextInt(10000);
//        if((posX < 18 && posX>2) && (posY<18&&posY>2)){
//            if(boundedInt > 5000){
//                if(boundedInt < 7500 && boundedInt > 5000){
//                    head.setX(posX+1);
//                }else {
//                    head.setX(posX-1);
//                }
//            } else {
//                if(boundedInt > 0 && boundedInt < 2500){
//                    head.setY(posY-1);
//                }else {
//                    head.setY(posY+1);
//                }
//            }
//        } else if (posX<=2) {
//            head.setX(posX+1);
//
//        } else if (posY<=2) {
//            head.setY(posY+1);
//        } else if (posX>=18){
//            head.setX(posX-1);
//        } else if (posY>=18) {
//            head.setY(posY-1);
//        }
        board.putObject(head, this);
    }

    @Override
    public Cell checkLeft() {
        return null;
    }

    @Override
    public void moveLeft(Board board) {

    }

    @Override
    public Cell checkRight() {
        return null;
    }

    @Override
    public void moveRight(Board board) {

    }

    @Override
    public void eat() {

    }

}