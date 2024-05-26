package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.Post;
import ensa.socialsphere.domain.models.bindingModels.post.PostCreateBindingModel;
import ensa.socialsphere.validations.serviceValidation.services.PostValidationService;
import org.springframework.stereotype.Component;

@Component
public class PostValidationServiceImpl implements PostValidationService {
    @Override
    public boolean isValid(Post post) {
        return post != null;
    }

    @Override
    public boolean isValid(PostCreateBindingModel postCreateBindingModel) {
        return postCreateBindingModel != null;
    }
}
