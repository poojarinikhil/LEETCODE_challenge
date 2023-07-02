package Arrays.medium;

import java.util.Arrays;
//----------------------------------------------------------------
//question
//        You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
//
//        You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
//
//        Return an array of coordinates representing the positions of the grid in the order you visited them.
//
//
//
//        Example 1:
//
//
//        Input: rows = 1, cols = 4, rStart = 0, cStart = 0
//        Output: [[0,0],[0,1],[0,2],[0,3]]
public class spiral_matrix_III {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(4, 2, 0, 0)));
    }
    public int[][] spiralMatrixIII(int R, int C, int x, int y) {
        int[][] res = new int[R * C][2];
        int dx = 0, dy = 1, n = 0, tmp;
        for (int j = 0; j < R * C; ++n) {
            for (int i = 0; i < n / 2 + 1; ++i) {
                if (0 <= x && x < R && 0 <= y && y < C)
                    res[j++] = new int[] {x, y};
                x += dx;
                y += dy;
            }
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }
        return res;
    }
}
//-----------------------------------------------------
//Explaination
//Take steps one by one.
//        If the location is inside of grid, add it to res.
//        But how to simulate the path?
//
//        It seems to be annoying, but if we observer the path:
//
//        move right 1 step, turn right
//        move down 1 step, turn right
//        move left 2 steps, turn right
//        move top 2 steps, turn right,
//        move right 3 steps, turn right
//        move down 3 steps, turn right
//        move left 4 steps, turn right
//        move top 4 steps, turn right,
//
//        we can find the sequence of steps: 1,1,2,2,3,3,4,4,5,5....
//
//        So there are two thing to figure out:
//
//        how to generate sequence 1,1,2,2,3,3,4,4,5,5
//        how to turn right?
//        Generate sequence 1,1,2,2,3,3,4,4,5,5
//        Let n be index of this sequence.
//        Then A0 = 1, A1 = 1, A2 = 2 ......
//        We can find that An = n / 2 + 1
//
//
//        How to turn right?
//        By cross product:
//        Assume current direction is (x, y) in plane, which is (x, y, 0) in space.
//        Then the direction after turn right (x, y, 0) × (0, 0, 1) = (y, -x, 0)
//        Translate to code: tmp = x; x = y; y = -tmp;
//
//        By arrays of arrays:
//        The directions order is (0,1),(1,0),(0,-1),(-1,0), then repeat.
//        Just define a variable.
//The code snippet you provided performs a simple 2D transformation known as a "right turn" or a "90-degree clockwise rotation" in the plane.
//
//        Let's break down what each line of code does:
//
//        tmp = x;
//        This line creates a temporary variable tmp and assigns it the value of x. This is done to store the original value of x before it is overwritten in the subsequent lines.
//
//        x = y;
//        This line assigns the value of y to x. As a result, the x variable now represents the new x-coordinate after the right turn.
//
//        y = -tmp;
//        This line assigns the negation of the temporary variable tmp to y. Since tmp holds the original value of x, this effectively assigns the negation of the original x-coordinate to y. The negative sign (-) inverts the sign of the value.
//
//        Therefore, after executing these three lines of code, the (x, y) coordinates are transformed by a 90-degree clockwise rotation in the plane. The new values of x and y represent the direction after the turn to the right.
//
//
//
//
