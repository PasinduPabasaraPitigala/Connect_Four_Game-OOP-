package lk.ijse.dep.service;

public class HumanPlayer extends Player {
    public HumanPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {
        boolean flag = board.isLegalMove(col);
        if (flag){
            board.updateMove(col,Piece.BLUE);
            board.getBoardUI().update(col,true);


            Winner winner = board.findWinner();
            if (winner.getWinningPiece()==Piece.EMPTY){
                boolean fl = board.existLegalMoves();
                if (!fl){
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }else {
                board.getBoardUI().notifyWinner(winner);
            }
        }
    }
}
