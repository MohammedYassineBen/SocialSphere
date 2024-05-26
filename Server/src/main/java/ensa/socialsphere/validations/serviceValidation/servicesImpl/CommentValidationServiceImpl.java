package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.Comment;
import ensa.socialsphere.domain.models.bindingModels.comment.CommentCreateBindingModel;
import ensa.socialsphere.validations.serviceValidation.services.CommentValidationService;
import org.springframework.stereotype.Component;

@Component
public class CommentValidationServiceImpl implements CommentValidationService {
    @Override
    public boolean isValid(Comment comment) {
        return comment != null;
    }

    @Override
    public boolean isValid(CommentCreateBindingModel commentCreateBindingModel) {
        return commentCreateBindingModel != null;
    }
}
