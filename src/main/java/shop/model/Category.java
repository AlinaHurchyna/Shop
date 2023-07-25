package shop.model;

public record Category(int id, String name) {
    public Category {
        validateName();
    }

    private void validateName() {
        if (name == null || !name.matches("^[a-zA-Z]{1,50}")) {
            throw new IllegalArgumentException();
        }
    }
}
