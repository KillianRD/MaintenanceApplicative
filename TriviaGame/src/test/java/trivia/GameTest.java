
package trivia;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
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
        Game game = new Game();
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
        Game game = new Game();
    }

    @Test
    @DisplayName("Minimum de joueurs pour lancer une partie : 2")
    public void minPlayer() {
        Game game = new Game();
        assertTrue(game.add("Killian"));
        assertFalse(game.canStart());
        assertTrue(game.add("Célèna"));
        assertTrue(game.canStart());
    }

    @Test
    @DisplayName("Ajouter des joueurs après le début de la partie")
    public void ajoutApresDebutPartie() {
        Game game = new Game();
        assertTrue(game.add("Killian"));
        assertTrue(game.add("Célèna"));
        assertTrue(game.canStart());
        game.roll(2);
        assertFalse(game.add("Luc"));
    }

    @Test
    @DisplayName("Ajout de 2 joueurs avec le meme nom")
    public void ajout2JoueurMemeNom() {
        IGame game = new Game();
        assertTrue(game.add("Killian"));
        assertFalse(game.add("Killian"));
    }

}
