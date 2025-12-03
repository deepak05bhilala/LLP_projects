package com.example;

import com.example.Piece.PieceType;
import com.example.Piece.PlayingPiece;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String Name;
    private final PlayingPiece playingPiece;
}
