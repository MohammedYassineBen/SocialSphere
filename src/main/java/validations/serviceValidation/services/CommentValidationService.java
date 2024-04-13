package validations.serviceValidation.services;

import entities.Comment;
import models.bindingModels.comment.CommentCreateBindingModel;

public interface CommentValidationService {
    boolean isValid(Comment comment);

    boolean isValid(CommentCreateBindingModel commentCreateBindingModel);
}
