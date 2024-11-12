import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class User {
    private final UUID id;
    private final String username;
    private final Set<UUID> posts = new HashSet<>();
    private final Set<UUID> followers = new HashSet<>();
    private final Set<UUID> following = new HashSet<>();

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void addPost(UUID postId) {
        posts.add(postId);
    }

    public void addFollower(UUID followerId) {
        followers.add(followerId);
    }

    public void follow(UUID followeeId) {
        following.add(followeeId);
    }
}