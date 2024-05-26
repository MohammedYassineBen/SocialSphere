package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.models.bindingModels.message.MessageCreateBindingModel;
import ensa.socialsphere.validations.serviceValidation.services.MessageValidationService;
import org.junit.Before;
import org.junit.Test;

import ensa.socialsphere.testUtils.MessagesUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MessageValidationServiceTests {
    private MessageValidationService messageValidationService;

    @Before
    public void setupTest(){
        messageValidationService = new MessageValidationServiceImpl();
    }

    @Test
    public void isValidWithMessageCreateBindingModel_whenValid_true(){
        MessageCreateBindingModel messageCreateBindingModel = MessagesUtils.getMessageCreateBindingModel();
        boolean result = messageValidationService.isValid(messageCreateBindingModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithMessageCreateBindingModel_whenNull_false(){
        MessageCreateBindingModel messageCreateBindingModel =  null;
        boolean result = messageValidationService.isValid(messageCreateBindingModel);
        assertFalse(result);
    }

}
