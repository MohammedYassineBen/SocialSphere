package ensa.socialsphere.repositories;

import ensa.socialsphere.domain.entities.Like;
import ensa.socialsphere.domain.entities.Post;
import ensa.socialsphere.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, String> {
    Like findByUserAndPost(User user, Post post);

    List<Like> findAllByPost(Post post);
}
