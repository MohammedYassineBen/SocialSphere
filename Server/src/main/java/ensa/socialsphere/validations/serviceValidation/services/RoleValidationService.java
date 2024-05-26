package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.entities.UserRole;

public interface RoleValidationService {
    boolean isValid(UserRole role);
}
