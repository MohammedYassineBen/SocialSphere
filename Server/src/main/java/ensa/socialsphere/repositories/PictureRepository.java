package ensa.socialsphere.repositories;

import ensa.socialsphere.domain.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {
    List<Picture> findAllByUserId(String userId);
}
