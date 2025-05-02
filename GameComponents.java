// GameComponents.java

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}

class Ladder {
    private int start;
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int position) {
        for (Snake snake : snakes) {
            if (snake.getHead() == position) {
                System.out.println("Oops! Bitten by a snake.. ");
                return snake.getTail();
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                System.out.println("Yay! Climbed a ladder ..");
                return ladder.getEnd();
            }
        }

        return position;
    }
}

class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Everyone starts before square 1
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

class Game {
    private Board board;
    private Queue<Player> players;
    private Random dice;

    public Game(Board board, List<Player> playerList) {
        this.board = board;
        this.players = new LinkedList<>(playerList);
        this.dice = new Random();
    }

    public void start() {
        while (true) {
            Player currentPlayer = players.poll();
            int diceRoll = dice.nextInt(6) + 1;
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);

            int newPosition = currentPlayer.getPosition() + diceRoll;
            if (newPosition >= board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            newPosition = board.getNextPosition(newPosition);
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved to " + newPosition);

            players.offer(currentPlayer); // Add player back to queue
        }
    }
}
