/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Move;

import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import chess_game.Pieces.Piece;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Move implements java.io.Serializable{

    Board board;
    Tile currentTile;
    Tile destinationTile;
    Piece movedPiece;
    Piece killedPiece;
    
    // Castling support
    private boolean isCastlingMove = false;
    private Tile rookStartTile;
    private Tile rookEndTile;

    // En passant support
    private boolean isEnPassantMove = false;
    private Tile enPassantCapturedTile;

    public Move(Board board, Tile currentTile, Tile destinationTile) {
        this.board = board;
        this.currentTile = currentTile;
        this.destinationTile = destinationTile;
        this.movedPiece = currentTile.getPiece();
        if (destinationTile.hasPiece()) {
            killedPiece = destinationTile.getPiece();
        }
        this.isCastlingMove = false;
        this.isEnPassantMove = false;
    }

    // Constructor for castling move
    public Move(Board board, Tile kingStartTile, Tile kingEndTile, Tile rookStartTile, Tile rookEndTile) {
        this.board = board;
        this.currentTile = kingStartTile;
        this.destinationTile = kingEndTile;
        this.movedPiece = kingStartTile.getPiece();
        this.rookStartTile = rookStartTile;
        this.rookEndTile = rookEndTile;
        this.isCastlingMove = true;
    }

    // Constructor for en passant
    public Move(Board board, Tile currentTile, Tile destinationTile, Tile enPassantCapturedTile) {
        this.board = board;
        this.currentTile = currentTile;
        this.destinationTile = destinationTile;
        this.movedPiece = currentTile.getPiece();
        this.enPassantCapturedTile = enPassantCapturedTile;
        this.isEnPassantMove = true;
        this.isCastlingMove = false;
        this.killedPiece = enPassantCapturedTile.getPiece();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public Tile getDestinationTile() {
        return destinationTile;
    }

    public void setDestinationTile(Tile destinationTile) {
        this.destinationTile = destinationTile;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
    
    public boolean hasKilledPiece()
    {
        return this.killedPiece != null;
    }

    public boolean isCastlingMove() {
        return isCastlingMove;
    }

    public Tile getRookStartTile() {
        return rookStartTile;
    }

    public Tile getRookEndTile() {
        return rookEndTile;
    }

    public boolean isEnPassantMove() {
        return isEnPassantMove;
    }

    public Tile getEnPassantCapturedTile() {
        return enPassantCapturedTile;
    }
}
