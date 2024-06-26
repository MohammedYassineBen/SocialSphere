package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.UserRole;
import ensa.socialsphere.validations.serviceValidation.services.RoleValidationService;
import org.springframework.stereotype.Component;

@Component
public class RoleValidationServiceImpl implements RoleValidationService {
    @Override
    public boolean isValid(UserRole role) {
        return role != null;
    }
}
