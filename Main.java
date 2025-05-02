// Main.java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create snakes
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(14, 7));
        snakes.add(new Snake(31, 18));
        snakes.add(new Snake(40, 3));
        snakes.add(new Snake(63, 36));
        snakes.add(new Snake(92, 63));

        // Create ladders
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(3, 22));
        ladders.add(new Ladder(5, 8));
        ladders.add(new Ladder(11, 26));
        ladders.add(new Ladder(20, 29));
        ladders.add(new Ladder(27, 56));

        // Create board
        Board board = new Board(100, snakes, ladders);

        // Create players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        // Start the game
        Game game = new Game(board, players);
        game.start();
    }
}
