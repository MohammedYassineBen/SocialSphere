package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {

}
