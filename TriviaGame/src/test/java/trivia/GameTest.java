
package trivia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GameTest {
	@Test
	@DisplayName("Max Player : 6")
	public void maxPlayer() {
		// runs 10.000 "random" games to see the output of old and new code mathces
		for (int seed = 1; seed < 10_000; seed++) {
			testSeed(seed, false);
		}
	}

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
