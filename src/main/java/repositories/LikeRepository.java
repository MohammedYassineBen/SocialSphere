package repositories;

import entities.Like;
import entities.Post;
import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, String> {
    Like findByUserAndPost(User user, Post post);

    List<Like> findAllByPost(Post post);
}