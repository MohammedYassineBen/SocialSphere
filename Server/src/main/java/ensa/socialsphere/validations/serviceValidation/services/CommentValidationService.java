package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.entities.Comment;
import ensa.socialsphere.domain.models.bindingModels.comment.CommentCreateBindingModel;

public interface CommentValidationService {
    boolean isValid(Comment comment);

    boolean isValid(CommentCreateBindingModel commentCreateBindingModel);
}
