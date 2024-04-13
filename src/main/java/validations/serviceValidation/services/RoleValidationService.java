package validations.serviceValidation.services;

import entities.UserRole;

public interface RoleValidationService {
    boolean isValid(UserRole role);
}
