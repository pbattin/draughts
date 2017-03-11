package stg.model.board;

import stg.model.piece.Piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Board {
    private Square[][] gameBoard = new Square[8][8];
    private int[] board = new int[32];
    private int positionFrom = 0;
    private int positionTo;
    private int whiteCount;
    private int blackCount;
    
    public Board() {
        constructBoardSquares();
    }
    
    public Board(int[][] gameBoard) {
        constructBoardSquares();
    }
    
    public Board(Square[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    public Board(int[] gameBoard) {
        constructBoardSquares();
    }
    
    public int[] toArray() {
        return board;
    }
    
    public void setFromArray() {
        
    }
    
    public void newBoard() {
        constructBoardSquares();
    }
    
    private void constructBoardSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isEven(i)) {
                    if (isEven(j)) {
                        gameBoard[i][j] = new Square(i, j, SquareColor.LIGHT);
                    } else {
                        gameBoard[i][j] = new Square(i, j, SquareColor.DARK);
                    }
                } else {
                    if (isEven(j)) {
                        gameBoard[i][j] = new Square(i, j, SquareColor.DARK);
                    } else {
                        gameBoard[i][j] = new Square(i, j, SquareColor.LIGHT);
                    }
                }
            }
        }
    }
    
    private void setPiece(int i, int j) {
        
    }
    
    private boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    public int getPositionFrom() {
        return positionFrom;
    }
    
    public void setPositionFrom(int positionFrom) {
        this.positionFrom = positionFrom;
    }
    
    public int getPositionTo() {
        return positionTo;
    }
    
    public void setPositionTo(int positionTo) {
        this.positionTo = positionTo;
    }
    
    public int getWhiteCount() {
        return whiteCount;
    }
    
    public void setWhiteCount(int whiteCount) {
        this.whiteCount = whiteCount;
    }
    
    public int getBlackCount() {
        return blackCount;
    }
    
    public void setBlackCount(int blackCount) {
        this.blackCount = blackCount;
    }
    
    private static class Node<T extends Square> {
        T square;
        Piece piece;
        T upLeft;
        T upRight;
        T downRight;
        T downLeft;
        
        Node() {
            
        }
        
        Node(T square) {
            this.square = square;
        }
        
        public Piece get() {
            return this.piece;
        }
        
        public void set(Piece piece) {
            this.piece = piece;
        }
        
        // public T get() {
        //     return this.square;
        // }
        //
        // public void set(T square) {
        //     this.square = square;
        // }
        
        public boolean isEmpty() {
            return this.piece == null;
        }
    }
}