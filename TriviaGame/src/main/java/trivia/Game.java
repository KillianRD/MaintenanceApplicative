package trivia;

import java.util.*;

// REFACTOR ME
public class Game implements IGame {
    private static final Categories[] CATEGORIES = Categories.values();

    private ArrayList<Player> players;
    private Map<Categories, Deque<String>> questions = new EnumMap<>(Categories.class);
    private int currentPlayerIndex = 0;
    private boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (Categories category : CATEGORIES) {
            questions.put(category, new LinkedList<>());

            questions.get(category).addLast(category + " Question ");
        }
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        Player player = currentPlayer();
        System.out.println(player.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (player.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(player.getName() + " is getting out of the penalty box");
                movePlayer(player, roll);
                askQuestion();
            } else {
                System.out.println(player.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            movePlayer(player, roll);
            askQuestion();
        }

    }

    public void movePlayer(Player player, int roll) {
        player.move(roll);
        System.out.println(player.getName() + "'s new location is " + player.getPlace());
        System.out.println("The category is " + currentCategory());
    }

    private void askQuestion() {
        System.out.println(questions.get(currentCategory()).removeFirst());
    }


    private Categories currentCategory() {
        return CATEGORIES[(currentPlayer().getPlace() - 1) % CATEGORIES.length];
    }

    public boolean handleCorrectAnswer() {
        Player player = currentPlayer();
        if (player.isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
            nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        currentPlayer().incrementPurse();
        System.out.println(currentPlayer().getName() + " now has " + currentPlayer().getPurse() + " Gold Coins.");

        boolean winner = didPlayerWin();
        nextPlayer();
        return winner;
    }


    public boolean wrongAnswer() {
        Player player = currentPlayer();
        System.out.println("Question was incorrectly answered");
        System.out.println(player.getName() + " was sent to the penalty box");

        player.setInPenaltyBox(true);

        nextPlayer();
        return true;
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }


    private boolean didPlayerWin() {
        return currentPlayer().getPurse() != 6;
    }
}
