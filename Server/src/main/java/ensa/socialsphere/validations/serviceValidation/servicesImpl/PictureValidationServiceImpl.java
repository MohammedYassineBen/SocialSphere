package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.Picture;
import ensa.socialsphere.validations.serviceValidation.services.PictureValidationService;
import org.springframework.stereotype.Component;

@Component
public class PictureValidationServiceImpl implements PictureValidationService {
    @Override
    public boolean isValid(Picture picture) {
        return picture != null;
    }
}
