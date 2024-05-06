package validations.serviceValidation.servicesImpl;

import entities.Like;
import validations.serviceValidation.services.LikeValidationService;
import org.springframework.stereotype.Component;

@Component
public class LikeValidationServiceImpl implements LikeValidationService {
    @Override
    public boolean isValid(Like like) {
        return like != null;
    }
}
