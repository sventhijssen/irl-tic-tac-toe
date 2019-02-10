class Game
{
    /**
     * Constructs a new game with a new board.
     */
    Game()
    {
        board = new Board();
    }

    void autoplay()
    {
        System.out.println("Initial state");
        System.out.println(board.toString());
        int player = 0;
        while(!board.game_over())
        {
            if (player % 2 == 0)
            {
                System.out.println("Player O");
                board.placeMark("O");
            }
            else
            {
                System.out.println("Player X");
                board.placeMark("X");
            }
            System.out.println(board.toString());
            player++;
        }

        steps = player;
    }

    /**
     * Returns the number of steps to end the game.
     * @return      The number of steps.
     */
    int getSteps()
    {
        return steps;
    }

    /**
     * Variable registering the number of steps to end the game.
     */
    private int steps;

    /**
     * Variable registering the board.
     */
    private Board board;
}
