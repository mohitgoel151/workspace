package learn.ds.backtracking;

public class QueenProblem {

    int[][] chessBoard;

    public QueenProblem(int[][] board) {
        chessBoard = board;
        Arrange(0, board.length);
    }

    private boolean Arrange(int row, int ArrayBound) {
        if (row > ArrayBound)
            return true;

        for (int iCol = 0; iCol <= ArrayBound; iCol++) {
            chessBoard[row][iCol] = 1;
            Boolean isValid = IsValidLocation(row, iCol, ArrayBound);

            if (false == isValid) {
                chessBoard[row][iCol] = 0;
                continue;
            } else {
                if (false == Arrange(row + 1, ArrayBound)) {
                    chessBoard[row][iCol] = 0;
                    continue;
                } else
                    return true;
            }
        }

        return false;
    }

    private boolean IsValidLocation(int iRowIndex, int iColumnIndex,
            int ArrayBound) {
        for (int i = iRowIndex - 1; i >= 0; i--) {
            if (chessBoard[i][iColumnIndex] == 1) {
                return false;
            }
        }

        for (int i = iColumnIndex - 1; i >= 0; i--) {
            if (chessBoard[iRowIndex][i] == 1) {
                return false;
            }
        }

        int iIndex = 1;
        while (iRowIndex - iIndex >= 0 && iColumnIndex - iIndex >= 0) {
            if (chessBoard[iRowIndex - iIndex][iColumnIndex - iIndex] == 1) {
                return false;
            }
            iIndex++;
        }

        iIndex = 1;
        while (iRowIndex - iIndex >= 0 && iColumnIndex + iIndex <= ArrayBound) {
            if (chessBoard[iRowIndex - iIndex][iColumnIndex + iIndex] == 1) {
                return false;
            }
            iIndex++;
        }

        return true;
    }

}
