package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.Like;
import ensa.socialsphere.validations.serviceValidation.services.LikeValidationService;
import org.springframework.stereotype.Component;

@Component
public class LikeValidationServiceImpl implements LikeValidationService {
    @Override
    public boolean isValid(Like like) {
        return like != null;
    }
}
