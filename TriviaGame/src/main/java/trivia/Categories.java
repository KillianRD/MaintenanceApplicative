package trivia;

enum Categories {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock"),
    GEOGRAPHIE("Géographie"),
    ;

    private final String stringValue;

    Categories(final String string) {
        stringValue = string;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
