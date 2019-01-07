package secondVersionCRUD.ENUM;

public enum Choices {
    option1("1"),
    option2("2"),
    option3("3"),
    option4("4");

    private final String name;

    Choices(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
