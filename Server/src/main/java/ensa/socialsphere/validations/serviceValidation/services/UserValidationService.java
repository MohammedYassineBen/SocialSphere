package ensa.socialsphere.validations.serviceValidation.services;

import ensa.socialsphere.domain.entities.User;
import ensa.socialsphere.domain.models.bindingModels.user.UserRegisterBindingModel;
import ensa.socialsphere.domain.models.bindingModels.user.UserUpdateBindingModel;
import ensa.socialsphere.domain.models.serviceModels.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserValidationService {
    boolean isValid(User user);

    boolean isValid(UserServiceModel userServiceModel);

    boolean isValid(UserRegisterBindingModel userRegisterBindingModel);

    boolean isValid(String firstParam, String secondParam);

    boolean isValid(UserUpdateBindingModel userUpdateBindingModel);

    boolean isValid(UserDetails userData);
}
