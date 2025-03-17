package trivia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

enum Categories {
    POP("Pop", "src/main/resources/questions/pop.properties"),
    SCIENCE("Science", "src/main/resources/questions/science.properties"),
    SPORTS("Sports", "src/main/resources/questions/sports.properties"),
    ROCK("Rock", "src/main/resources/questions/rock.properties"),
    GEOGRAPHIE("Géographie", "src/main/resources/questions/geographie.properties"),
    ;

    private final String name;
    private LinkedList<String> questions;

    Categories(final String string, final String filePath) {
        name = string;
        questions = new LinkedList<>();

        loadQuestions(filePath);
    }

    private void loadQuestions(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.addLast(line);
            }

        } catch (IOException eio) {
            System.exit(1);
        }
    }

    public LinkedList<String> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return name;
    }
}
