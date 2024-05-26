package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.models.bindingModels.message.MessageCreateBindingModel;

public interface MessageValidationService {
    boolean isValid(MessageCreateBindingModel messageCreateBindingModel);
}
