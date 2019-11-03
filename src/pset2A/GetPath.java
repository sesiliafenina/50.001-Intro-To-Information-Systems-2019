package pset2A;

/*
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetPath {
    private static int x = 0;
    private static int y = 0;
    private static Point branch = null;
    private static ArrayList<Point> backuppath;

    //Fill in your answer for this method
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) { // r == y, c == x
        if (r == y && c == x){
            x = 0;
            y = 0;
            return true;
        }
        // check if x and y doesnt not exceed grid length and width
        if (y + 2 <= grid.length && x + 2 <= grid[x].length) {
            // check if it can move left AND right and add the coordinate to branch
            if (grid[y + 1][x] != 1 && grid[y][x + 1] != 1) {
                //System.out.println(x);
                //System.out.println(y);
                int newx = x + 1;
                branch = new Point(y, newx); // move right
                //System.out.println("branch");
                //System.out.println(branch);
                backuppath = new ArrayList<>(path);
                backuppath.add(branch);
            }
            // check if it can move down
            if (grid[y + 1][x] != 1) {
                y += 1;
                Point p = new Point(y, x);
                //System.out.println("moves down");
                //System.out.println(p);
                path.add(p);
                //System.out.println("pathleft");
                //System.out.println(path);
                return getPath(r, c, path, grid);
            }
            // check if it can move right
            if (grid[y][x + 1] != 1) {
                x += 1;
                Point p = new Point(y, x);
                //System.out.println("moves right");
                //System.out.println(p);
                path.add(p);
                //System.out.println("pathright");
                //System.out.println(path);
                return getPath(r, c, path, grid);
            }
            // if it cannot move down or right, jump to branch and move down
            // if branch is null return false
            if (branch != null){
                path.clear();
                path.addAll(backuppath);
                //System.out.println("pathbranch1");
                //System.out.println(path);
                x = branch.x;
                y = branch.y;
                branch = null;
                return getPath(r, c, path, grid);
            }
            return false;
        }
        // if it exceeds and branch exist jump to branch
        if (branch != null) {
            path.clear();
            path.addAll(backuppath);
            //System.out.println("pathbranch2");
            //System.out.println(path);
            x = branch.x;
            y = branch.y;
            branch = null;
            return getPath(r, c, path, grid);
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
}*/
