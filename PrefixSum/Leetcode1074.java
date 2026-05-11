package PrefixSum;

import java.util.HashMap;

public class Leetcode1074 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int [][] prefix;
            prefix   = new int [ matrix .length + 1][ matrix[0].length + 1 ];
            for ( int i = 1 ; i< prefix.length ; i++ )
                for( int j = 1 ; j< prefix [0].length ; j++ )
                    prefix[ i ][ j ] =
                            prefix[ i-1 ][ j ] +
                                    prefix[ i ][ j-1 ] -
                                    prefix [ i-1 ][ j -1 ] +
                                    matrix[ i-1 ][ j-1 ];

            HashMap< Integer, Integer> map;
            //  map.put( 0 , 1 );
            // My apparoach
            int sum ;
            int count = 0;
            for (int r1 = 0; r1 < matrix.length; r1++) {
                //map = new HashMap<>();
                for (int r2 = r1; r2 < matrix.length; r2++) {
                    map = new HashMap<>();
                    map.put(0, 1);
                    sum = 0;
                    for (int col = 0; col < matrix[0].length ; col++) {
                        sum = sumRegion(r1, 0, r2, col, prefix);
                        count += map.getOrDefault(sum - target, 0);
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                    }
                }
            }
            return count;
        }


        public int sumRegion(int row1, int col1, int row2, int col2, int [][] prefix) {
            return
                    prefix [ row2+1 ][ col2 +1 ] -
                            prefix [ row1 ][ col2+1 ] -
                            prefix[ row2+1 ][ col1 ] +
                            prefix [ row1 ][ col1 ];
            // reason row +1 is used becsued of the relation it is same like ith index == i+1 th index in the prefix sum
        }
    }
/*
Clude's Approach
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefix = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= cols; j++)
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1]
                              - prefix[i-1][j-1] + matrix[i-1][j-1];

        int count = 0;

        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int col = 0; col < cols; col++) {
                    sum += prefix[r2+1][col+1] - prefix[r1][col+1];
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
*/
}
