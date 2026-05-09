class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for(int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            for(int j = left; j <= right; j++) {
                elements.add(grid[top][j]);
            }

            for(int i = top + 1; i <= bottom - 1; i++) {
                elements.add(grid[i][right]);
            }

            for(int j = right; j >= left; j--) {
                elements.add(grid[bottom][j]);
            }

            for(int i = bottom - 1; i >= top + 1; i--) {
                elements.add(grid[i][left]);
            }
            int size = elements.size();
            int rotate = k % size;
            List<Integer> rotated = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                rotated.add(elements.get((i + rotate) % size));
            }
            int index = 0;

            for(int j = left; j <= right; j++) {
                grid[top][j] = rotated.get(index++);
            }

            for(int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = rotated.get(index++);
            }

            for(int j = right; j >= left; j--) {
                grid[bottom][j] = rotated.get(index++);
            }

            for(int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = rotated.get(index++);
            }
        }
        return grid;
    }
}