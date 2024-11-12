import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Network {
    private final Map<UUID, User> users = new HashMap<>();
    private final Map<UUID, Post> posts = new HashMap<>();

    
    public UUID createUser(String username) {
        UUID userId = UUID.randomUUID();
        User user = new User(userId, username);
        users.put(userId, user);
        System.out.println("User created: " + username + " (ID: " + userId + ")");
        return userId;
    }
    
    public UUID createPost(UUID userId, String content) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found!");
            return null;
        }
        
        UUID postId = UUID.randomUUID();
        Post post = new Post(postId, userId, content);
        posts.put(postId, post);
        users.get(userId).addPost(postId);
        System.out.println("Post created by " + users.get(userId).getUsername() + ": " + content);
        return postId;
    }
    
    public void likePost(UUID postId, UUID userId) {
        Post post = posts.get(postId);
        if (post != null && users.containsKey(userId)) {
            post.addLike(userId);
            System.out.println(users.get(userId).getUsername() + " liked post: " + post.getContent());
        } else {
            System.out.println("Post or User not found!");
        }
    }
    
    public void commentPost(UUID postId, UUID userId, String commentText) {
        Post post = posts.get(postId);
        if (post != null && users.containsKey(userId)) {
            Comment comment = new Comment(userId, commentText);
            post.addComment(comment);
            System.out.println(users.get(userId).getUsername() + " commented on post: " + commentText);
        } else {
            System.out.println("Post or User not found!");
        }
    }
    
    public void followUser(UUID followerId, UUID followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        
        if (follower != null && followee != null) {
            follower.follow(followeeId);
            followee.addFollower(followerId);
            System.out.println(follower.getUsername() + " started following " + followee.getUsername());
        } else {
            System.out.println("User not found!");
        }
    }
    
    public void displayPost(UUID postId) {
        Post post = posts.get(postId);
        if (post != null) {
            System.out.println("Post by " + users.get(post.getAuthorId()).getUsername() + ": " + post.getContent());
            System.out.println("Likes: " + post.getLikesCount());
            System.out.println("Comments:");
            for (Comment comment : post.getComments()) {
                System.out.println("- " + users.get(comment.getUserId()).getUsername() + ": " + comment.getText());
            }
        } else {
            System.out.println("Post not found!");
        }
    }
    public static void main(String [] args){
        Network network = new Network();
        UUID user1 = network.createUser("Alice");
        UUID user2 = network.createUser("Bob");
        UUID post1 = network.createPost(user1, "Hello, Bob!");
        UUID post2 = network.createPost(user2, "Hello, Alice!");
        network.likePost(post1, user2);
        network.commentPost(post2, user1, "Hi, Bob!");
        network.followUser(user1, user2);
        network.displayPost(post1);
        network.displayPost(post2);
        
    }
}
