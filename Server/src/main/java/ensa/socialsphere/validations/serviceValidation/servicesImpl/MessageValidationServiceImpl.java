package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.models.bindingModels.message.MessageCreateBindingModel;
import ensa.socialsphere.validations.serviceValidation.services.MessageValidationService;
import org.springframework.stereotype.Component;

@Component
public class MessageValidationServiceImpl implements MessageValidationService {

    @Override
    public boolean isValid(MessageCreateBindingModel messageCreateBindingModel) {
        return messageCreateBindingModel != null;
    }
}
