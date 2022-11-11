package leetcode;

class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        final int I = matrix.length;
        if (I == 0) return 0;
        final int J = matrix[0].length;
        final int[] heights = new int[J];
        int maxArea = 0;
        for (int i = 0; i < I; i++) {
            final char[] row = matrix[i];
            for (int j = 0; j < J; j++) {
                heights[j] = (row[j] == '0') ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, LargestRectangleArea.largestRectangleArea(heights));
        }
        return maxArea;
    }
}
