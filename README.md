# Snake-and-Ladder

I used an Object-Oriented approach for this.
I created the following classes :
  1. Player: stores player name and current position
  2. Snake / Ladder: define snake or ladder positions on the board
  3. Board: holds the game layout and snake/ladder logic
  4. Game: contains the main game loop and manages turns

🧱 1. Player class
     . Stores player's name and current position
     . Starts at position 0
     . Provides get and set methods to access/update player's position

🐍 2. Snake class
    . Represents a snake from head (high square) to tail (low square)
    . If you land on the head, you "fall" to the tail

🪜 3. Ladder class
    . Represents a ladder from start (low square) to end (high square)
    . Landing on start lets you "climb" to end

🎲 4. Board class
     . Stores board size (like 100)
     . Holds snakes and ladders
     . The method getNextPosition() checks:
            > If landed on a snake head → send to tail
            > If landed on a ladder base → climb to top

🎮 5. Game class
      . Uses a queue to rotate through players
      . Each turn:
          > Player rolls dice
          > Moves forward by dice roll
          > Checks for snakes/ladders
          > Updates position
          > If they win (reach last square), game ends
          > Otherwise, their turn goes to the back of the queue

 🏁 6. Main method: to run the game
       . Sets up the game:
         > Snakes and ladders
         > Board size (100)
         > 2 players
       . Starts the game loop
       
✅ Summary of Game Flow:
Initialize players → Roll dice → Move forward → Snake/ladder check → Win check → Repeat next player's turn





