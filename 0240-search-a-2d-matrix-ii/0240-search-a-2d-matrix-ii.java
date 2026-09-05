class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;
        while(row < m && col >= 0){
            int value = matrix[row][col];
            if(value == target) return true;
            else if(value > target) col--;
            else row++;
        }
        return false;
    }
}