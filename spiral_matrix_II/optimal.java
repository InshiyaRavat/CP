class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;

        while(left<=right && top<=bottom){
            for(int j=left; j<=right; j++){
                matrix[top][j] = num++;
            }
            top++;

            for(int i=top; i<=bottom; i++){
                matrix[i][right] = num++;
            }
            right--;

            if(top <= bottom){
                for(int j=right; j>=left; j--){
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }

            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}
