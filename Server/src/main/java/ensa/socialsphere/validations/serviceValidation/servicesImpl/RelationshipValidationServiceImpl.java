package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.Relationship;
import ensa.socialsphere.validations.serviceValidation.services.RelationshipValidationService;
import org.springframework.stereotype.Component;

@Component
public class RelationshipValidationServiceImpl implements RelationshipValidationService {
    @Override
    public boolean isValid(Relationship relationship) {
        return relationship != null;
    }
}
