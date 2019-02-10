import java.util.Objects;
import java.util.Random;

public class Board
{
    /**
     * Constructs an empty grid with size 3 x 3.
     */
    Board()
    {
        this(3, 3);
    }

    /**
     * Constructs an empty grid with size width x height.
     * @param width     The given width.
     * @param height    The given height.
     */
    private Board(int width, int height)
    {
        grid = new String[width][height];
    }

    /**
     * Places the given mark at a random (empty) position on the grid.
     * @param mark  The given mark.
     */
    void placeMark(String mark)
    {
        Random ran = new Random();
        int j = ran.nextInt(getHeight()-1);
        int i = ran.nextInt(getWidth()-1);
        while(grid[j][i] != null)
        {
            j = ran.nextInt(getHeight());
            i = ran.nextInt(getWidth());
        }
        grid[j][i] = mark;
    }

    /**
     * Returns whether the game has been has_won.
     * @return      True if and only if three in-line positions (horizontally, vertically or diagonally)
     *              have the same mark.
     */
    private boolean has_won()
    {
        for(int j = 0; j < getHeight(); j++)
        {
            for (int i = 0; i < getWidth(); i++)
            {
                if (won_horizontal(j, i) || won_vertical(j, i) || won_diagonal(j, i))
                    return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the grid has been filled.
     * @return      True if and only if all positions differ from null.
     */
    private boolean is_filled()
    {
        for(int j = 0; j < getHeight(); j++)
        {
            for (int i = 0; i < getWidth(); i++)
            {
                if (grid[j][i] == null)
                    return false;
            }
        }
        return true;
    }

    /**
     * Returns whether the game is over or not.
     * @return      True if and only if the game is has_won and/or the grid is completely filled.
     */
    boolean game_over()
    {
        return has_won() || is_filled();
    }

    private boolean won_horizontal(int j, int i)
    {
        if (!within_boundaries(j, i+2))
            return false;
        return  (Objects.equals(grid[j][i], "O") && Objects.equals(grid[j][i + 1], "O") && Objects.equals(grid[j][i + 2], "O"))
                ||
                (Objects.equals(grid[j][i], "X") && Objects.equals(grid[j][i + 1], "X") && Objects.equals(grid[j][i + 2], "X"));
    }

    private boolean won_vertical(int j, int i)
    {
        if (!within_boundaries(j+2, i))
            return false;
        return  (Objects.equals(grid[j][i], "O") && Objects.equals(grid[j + 1][i], "O") && Objects.equals(grid[j + 2][i], "O"))
                ||
                (Objects.equals(grid[j][i], "X") && Objects.equals(grid[j + 1][i], "X") && Objects.equals(grid[j + 2][i], "X"));
    }

    private boolean won_diagonal(int j, int i)
    {
        if (!within_boundaries(j+2, i+2))
            return false;
        return  (Objects.equals(grid[j][i], "O") && Objects.equals(grid[j + 1][i + 1], "O") && Objects.equals(grid[j + 2][i + 2], "O"))
                ||
                (Objects.equals(grid[j][i], "X") && Objects.equals(grid[j + 1][i + 1], "X") && Objects.equals(grid[j + 2][i + 2], "X"));
    }

    /**
     * Returns whether the given position (j, i) is within the boundaries of the grid.
     * @param j
     * @param i
     * @return
     */
    private boolean within_boundaries(int j, int i)
    {
        return (j < getHeight() && i < getWidth());
    }

    @Override
    public String toString()
    {
        String s = "";
        for (int j = 0; j < this.getHeight(); j++)
        {
            for (int i = 0; i < this.getWidth(); i++)
            {
                String v = grid[j][i];
                if (v == null)
                    s += "_";
                else
                    s += v;
                if ((i+1) % getWidth() == 0)
                    s += "\n";
                else
                    s += "\t";
            }
        }
        return s;
    }

    /**
     * Returns the height of the grid.
     * @return
     */
    private int getHeight()
    {
        return grid.length;
    }

    /**
     * Returns the width of the grid.
     * @return
     */
    private int getWidth()
    {
        return grid[0].length;
    }

    /**
     * Variable registering the grid.
     */
    private String[][] grid;
}
