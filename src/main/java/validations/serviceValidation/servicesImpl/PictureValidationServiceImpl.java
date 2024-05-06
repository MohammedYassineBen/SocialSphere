package validations.serviceValidation.servicesImpl;

import entities.Picture;
import validations.serviceValidation.services.PictureValidationService;
import org.springframework.stereotype.Component;

@Component
public class PictureValidationServiceImpl implements PictureValidationService {
    @Override
    public boolean isValid(Picture picture) {
        return picture != null;
    }
}
