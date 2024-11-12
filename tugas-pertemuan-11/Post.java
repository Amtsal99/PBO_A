import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class Post {
    private final UUID id;
    private final UUID authorId;
    private final String content;
    private final Set<UUID> likes = new HashSet<>();
    private final List<Comment> comments = new ArrayList<>();

    public Post(UUID id, UUID authorId, String content) {
        this.id = id;
        this.authorId = authorId;
        this.content = content;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    public void addLike(UUID userId) {
        likes.add(userId);
    }
    
    public UUID getId() {
        return id;
    }

    public int getLikesCount() {
        return likes.size();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }
}
