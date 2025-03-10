
package trivia;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameTest {
    @Test
    @DisplayName("Maximum de joueur pour lancer une partie : 6")
    public void maxPlayer() {
        IGame game = new Game();
        assertTrue(game.add("Killian"));
        assertTrue(game.add("Célèna"));
        assertTrue(game.add("Luc"));
        assertTrue(game.add("Baptiste"));
        assertTrue(game.add("Alexis"));
        assertTrue(game.add("Thomas"));
        assertFalse(game.add("Celie"));
    }

    @Test
    @DisplayName("Ajout d'une catégorie : Géographie")
    @Disabled("Pour le moment je ne sais pas comment faire pour tester la nouvelle catégorie")
    public void ajoutGeographie() {
        IGame game = new Game();
    }

    @Test
    @DisplayName("Minimum de joueurs pour lancer une partie : 2")
    public void minPlayer() {
        IGame game = new Game();
        assertTrue(game.add("Killian"));
        assertFalse(game.canStart());
        assertTrue(game.add("Célèna"));
        assertTrue(game.canStart());
    }

    @Test
    @DisplayName("Ajouter des joueurs après le début de la partie")
    public void ajoutApresDebutPartie() {
		IGame game = new Game();
        assertTrue(game.add("Killian"));
        assertTrue(game.add("Célèna"));
        assertTrue(game.canStart());
        game.roll(2);
        assertFalse(game.add("Luc"));
    }

    @Test
    @DisplayName("Ajout de 2 joueurs avec le meme nom")

    private String extractOutput(Random rand, IGame aGame) {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream inmemory = new PrintStream(baos)) {
            // WARNING: System.out.println() doesn't work in this try {} as the sysout is captured and recorded in memory.
            System.setOut(inmemory);

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");

            boolean notAWinner = false;
            do {
                aGame.roll(rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    notAWinner = aGame.wrongAnswer();
                } else {
                    notAWinner = aGame.handleCorrectAnswer();
                }

            } while (notAWinner);
        } finally {
            System.setOut(old);
        }

        return new String(baos.toByteArray());
    }
}
