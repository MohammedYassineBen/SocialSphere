package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.entities.Like;

public interface LikeValidationService {
    boolean isValid(Like like);
}
