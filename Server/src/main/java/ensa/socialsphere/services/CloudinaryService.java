package ensa.socialsphere.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {
    Map uploadImage(MultipartFile multipartFile, String uuid) throws Exception;

    boolean deleteImage(String cloudinaryPublicId) throws Exception;
}