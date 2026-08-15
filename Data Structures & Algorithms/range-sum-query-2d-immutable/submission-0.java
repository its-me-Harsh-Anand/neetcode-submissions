class NumMatrix {
    private int[][] sumMatrix;
    // sumMatrix[i][j] = prefix sum till jth col of ith row + jth col of i-1st row => this will store sum from 0,0 to i,j in sumMatrix[i][j]
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sumMatrix = new int[row][col];

        for(int i=0; i<row; i++){
            int sum = 0;
            for(int j=0; j<col; j++){
                sum += matrix[i][j];
                sumMatrix[i][j] = (i==0 ? 0 : sumMatrix[i-1][j]) + sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumTotal = sumMatrix[row2][col2];
        int sumTop = (row1 == 0 ? 0 : sumMatrix[row1-1][col2]);
        int sumLeft = (col1==0 ? 0 :sumMatrix[row2][col1-1]);
        int commonCell = ((row1==0 || col1==0) ? 0 : sumMatrix[row1-1][col1-1]);

        return sumTotal - sumTop -sumLeft + commonCell;
    }
}
