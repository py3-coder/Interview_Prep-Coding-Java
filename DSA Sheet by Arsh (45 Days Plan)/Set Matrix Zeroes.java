/*******
Link  :https://leetcode.com/problems/set-matrix-zeroes/
73. Set Matrix Zeroes
Medium
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
Accepted
717,539
Submissions
1,473,431
*******/

/***
Approch 1: Brute Force 
Time Complexity :O((m*n)*(m+n))
Space : O(1)
Code :
***/
class Solution {
    public void setZeroes(int[][] matrix) {
        int MODIFIED = -10000000;
        int m = matrix.length;
        int n= matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                   for(int k=0;k<m;k++){
                       if(matrix[k][j]!=0) {
                           matrix[k][j]=MODIFIED;
                       }
                   }
                    for(int k=0;k<n;k++){
                        if(matrix[i][k]!=0){
                            matrix[i][k] =MODIFIED;
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == MODIFIED){
                    matrix[i][j]=0;
                }
            }
        }
    }
}

/******
Approch 2: Optimal
Time : O(m*n)
Space : O(1)
Code :
*******/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        boolean FirstRowZero = false;
        boolean FirstColZero =false;
        
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                FirstColZero = true;
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                FirstRowZero = true;
                break;
            }
        }
        ///
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    
                }
            }
        }
        //
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] =0;
                }
            }
        }
        if(FirstRowZero){
            for(int j=0;j<n;j++){
                matrix[0][j] =0;
            }
        }
        if(FirstColZero){
            for(int i=0;i<m;i++){
                matrix[i][0] =0;
            }
        }
    }
}
