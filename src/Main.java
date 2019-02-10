import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Integer> steps = new HashMap<>();

        // A minimum of five steps is needed and a maximum of nine steps can be performed.
        for(int i = 5; i <= 9; i++)
        {
            steps.put(i, 0);
        }

        int N = 10000;

        // Play N games.
        for(int i = 0; i < N; i++)
        {
            Game game = new Game();
            game.autoplay();
            Integer value = steps.get(game.getSteps());
            steps.put(game.getSteps(), value+1); // Increment the value by one
        }

        //
        for (Map.Entry<Integer, Integer> entry : steps.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + (double) value/N*100);
        }
    }
}

