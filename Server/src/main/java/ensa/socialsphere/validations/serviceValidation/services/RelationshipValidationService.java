package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.entities.Relationship;

public interface RelationshipValidationService {
    boolean isValid(Relationship relationship);
}
