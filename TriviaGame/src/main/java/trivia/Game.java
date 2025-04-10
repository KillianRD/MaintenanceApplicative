package trivia;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;

// REFACTOR ME
public class Game implements IGame {
    public static final int NB_CASES = 12;
    public static final int WINNER_SCORE = 6;
    public static final int MIN_PLAYER = 2;
    public static final int MAX_PLAYER = 6;

    public boolean gameStarted = false;

    private static final Categories[] CATEGORIES = Categories.values();

    private final ArrayList<Player> players = new ArrayList<>();
    private final Map<Categories, LinkedList<String>> questions = new EnumMap<>(Categories.class);
    private int currentPlayerIndex = 0;
    private boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (Categories category : CATEGORIES) {
            questions.put(category, category.getQuestions());
        }
    }

    public boolean canStart() {
        return players.size() >= MIN_PLAYER;
    }

    public boolean add(String playerName) {
        if (gameStarted) {
            System.out.println("You can't add a player after the start of the game");
            return false;
        }

        if (players.size() < MAX_PLAYER) {
            if (players.contains(new Player(playerName))) {
                return false;
            }
            players.add(new Player(playerName));
            System.out.println(playerName + " was added");
            System.out.println("They are player number " + players.size());
            return true;
        } else {
            System.out.println("Too much players in the game (Maximum 6)");
            return false;
        }
    }

    public void roll(int roll) {
        gameStarted = true;
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

    private void askQuestion() {
        System.out.println(questions.get(currentCategory()).removeFirst());
    }

    public boolean handleCorrectAnswer() {
        Player player = currentPlayer();
        if (player.isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
            nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        player.incrementPurse();
        player.setInPenaltyBox(false);
        System.out.println(player.getName() + " now has " + player.getPurse() + " Gold Coins.");

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

    public void movePlayer(Player player, int roll) {
        player.move(roll);
        System.out.println(player.getName() + "'s new location is " + player.getPlace());
        System.out.println("The category is " + currentCategory());
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private Categories currentCategory() {
        return CATEGORIES[(currentPlayer().getPlace() - 1) % CATEGORIES.length];
    }

    private boolean didPlayerWin() {
        return currentPlayer().getPurse() != WINNER_SCORE;
    }

    public Player getPlayer(String name) {
        for (Player p : players) {
            if(p.getName().equals(name)) return p;
        }
        return null;
    }
}
