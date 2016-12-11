package miscs;

public class ShortestPath {

    int path_num = 0;  //how many path is the shortest.
    int rows = 8; //this is a 8*8 grid board;
    int step = 0;
    int[][] grid;

    void ShortestPath(int[][] initgrid, int rownumber)
    {
        grid = initgrid;
        rows = rownumber;
    }

    public void shortestPathNumber(int row, int col) {
        if (row > 8 || col > 8 || grid[row][col] == 1 || step > 16) {
            return;
        }
        if (row == 8 && col == 8) {
            if (step == 16)  //已到达B点，且等于最短路径16，就累加
            {
                path_num++;
            }
        } else {
            grid[row][col] = 1; //标记该点已访问
            step++;
            shortestPathNumber(row, col + 1);
            shortestPathNumber(row + 1, col);
            grid[row][col] = 0; //回溯
            step--;
        }
    }

    public static void main(String[] args) {

        int[][] grid = new int[9][9];
        for (int i = 0; i< 9; i++)
            for(int j = 0; j < 9; j++)
                grid[i][j] = 0;

        ShortestPath sp = new ShortestPath();
        sp.grid = grid;
        sp.rows = 8;
        sp.shortestPathNumber(0, 0); //从A点开始搜索
        System.out.println("paths numner: " + sp.path_num);
        return;
    }
}