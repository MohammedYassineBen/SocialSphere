package ensa.socialsphere.testUtils;

import ensa.socialsphere.domain.entities.Like;
import ensa.socialsphere.domain.entities.Post;
import ensa.socialsphere.domain.entities.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LikesUtils {
    public static Like createLike(User loggedInUser, Post post) {
        return new Like() {{
            setId("1");
            setUser(loggedInUser);
            setPost(post);
            setCount(0L);
        }};
    }

    public static List<Like> getLikes(int count, User loggedInUser, Post post) {
        return IntStream.range(0, count)
                .mapToObj(index -> new Like() {{
                    setId(String.valueOf(index + 1));
                    setUser(loggedInUser);
                    setPost(post);
                    setCount(0L);
                }})
                .collect(Collectors.toList());
    }

}
