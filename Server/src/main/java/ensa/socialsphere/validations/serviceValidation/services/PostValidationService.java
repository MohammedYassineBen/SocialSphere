package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.entities.Post;
import ensa.socialsphere.domain.models.bindingModels.post.PostCreateBindingModel;

public interface PostValidationService {
    boolean isValid(Post post);

    boolean isValid(PostCreateBindingModel postCreateBindingModel);
}
