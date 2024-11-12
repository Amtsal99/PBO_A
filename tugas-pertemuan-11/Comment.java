import java.util.UUID;

public class Comment {
    private final UUID userId;
    private final String text;

    public Comment(UUID userId, String text) {
        this.userId = userId;
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }
}
