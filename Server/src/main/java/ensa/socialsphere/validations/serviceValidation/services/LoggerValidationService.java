package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.models.serviceModels.LoggerServiceModel;

public interface LoggerValidationService {
    boolean isValid(LoggerServiceModel loggerServiceModel);

    boolean isValid(String method, String principal, String tableName, String action);

    boolean isValid(String username);
}
