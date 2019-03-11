package service.filters;

import service.Boards;
import service.Filter;

public abstract class NumbersFilter extends Filter {
    private int leftBoard;
    private int rightBoard;

    public NumbersFilter(int leftBoard, int rightBoard){
        this.leftBoard = leftBoard;
        this.rightBoard = rightBoard;
    }

    public int getLeftBoard() {
        return leftBoard;
    }

    public void setLeftBoard(int leftBoard) {
        this.leftBoard = leftBoard;
    }

    public int getRightBoard() {
        return rightBoard;
    }

    public void setRightBoard(int rightBoard) {
        this.rightBoard = rightBoard;
    }
}
