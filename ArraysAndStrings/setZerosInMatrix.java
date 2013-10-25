// Q: 2) Given an M*N matrix, find all elements which are zero, when found it, set all the elements in that row and column to zero.

public static int[][] getModifiedMatrix(int[][] matrix) {
    if (matrix == null) {
        throw new InvalidParamentException();
    }
    
    int numOfRow = matrix.length;
    int numOfCol = matrix[0].length;
    
    if (numOfRow == 1 && numOfCol == 1) {
        return matrix;
    }
    
    boolean firstRowIsZero = false;
    boolean firstColIsZero = false;
        
    // scan the first row
    for (int row = 0; row < numOfRow; row++) {
        if (matrix[row][0] == 0) {
            firstRowIsZero = true;
            break;
        }
    }
    
    // san the first column
    for (int col = 0; col < numOfCol; col++) {            
        if (matrix[0][col] == 0) {
            firstColIsZero = true;
            break;
        }
    }

    // change the values of the first row and the first column cells
    for (int row = 1; row < numOfRow; row++) {
        for (int col = 1; col < numOfCol; col++) {
            if (matrix[row][col] == 0) {
                if (matrix[row][0] != 0) matrix[row][0] = 0;
                if (matrix[0][col] != 0) matrix[0][col] = 0;
            }
        }
    
    }
    
    // change the values of the inside cells based on the values of the first row and the first column cells
    for (int row = 1; row < numOfRow; row++) {
        for (int col = 1; col < numOfCol; col++) {
            if (matrix[row][0] == 0 || matrix[col][0] == 0) {
                if (matrix[row][col] != 0) matrix[row][col] = 0;
            }
        }
    
    }
    
    if (firstRowIsZero ){
        // set the first row to 0
        for (int row = 0; row < numOfRow; row++) {
            if (matrix[row][0] != 0) matrix[row][0] = 0;
        }
    }
        
    if (firstColIsZero ){
        // set the first column to 0
        for (int col = 0; col < numOfCol; col++) {
            if (matrix[0][col] != 0) matrix[0][col] = 0;
        }
    }
    
    return matrix;

} 
