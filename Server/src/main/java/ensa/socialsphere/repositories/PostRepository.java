package ensa.socialsphere.repositories;

import ensa.socialsphere.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findAllByTimelineUserIdOrderByTimeDesc(String timelineUserId);
}
