class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = i == n ? 0 : heights[i];

            while (top >= 0 && heights[stack[top]] > currHeight) {
                int height = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack[++top] = i;
        }

        return maxArea;
    }
}