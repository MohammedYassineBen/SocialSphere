package validations.serviceValidation.services;

import entities.Relationship;

public interface RelationshipValidationService {
    boolean isValid(Relationship relationship);
}
