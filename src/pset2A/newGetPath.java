package pset2A;

import java.util.ArrayList;

public class newGetPath {
    private static int x = 0;
    private static int y = 0;

    //Fill in your answer for this method
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        if (r == 0 && c == 0){
            Point p = new Point(0,0);
            path.add(p);
            return true;
        }
        if (r<0||c<0||grid[r][c] == 1){
            return false;
        }
        if (getPath(r, c-1, path, grid) || getPath(r-1, c, path, grid)){
            Point m = new Point(r,c);
            path.add(m);
            return true;
        }
        return false;
    }
}

//You do not need to change any code below.
class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
