package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.User;
import ensa.socialsphere.domain.entities.UserRole;
import ensa.socialsphere.domain.models.bindingModels.user.UserRegisterBindingModel;
import ensa.socialsphere.domain.models.bindingModels.user.UserUpdateBindingModel;
import ensa.socialsphere.domain.models.serviceModels.UserServiceModel;
import ensa.socialsphere.services.UserService;
import ensa.socialsphere.validations.serviceValidation.services.UserValidationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import ensa.socialsphere.testUtils.RolesUtils;
import ensa.socialsphere.testUtils.UsersUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserValidationServiceTests {
    private UserValidationService userValidationService;

    @Before
    public void setupTest() {
        userValidationService = new UserValidationServiceImpl();
    }

    @Test
    public void isValidWithUser_whenValid_true() {
        User user = UsersUtils.createUser();
        boolean result = userValidationService.isValid(user);
        assertTrue(result);
    }

    @Test
    public void isValidWithUser_whenNull_false() {
        User user = null;
        boolean result = userValidationService.isValid(user);
        assertFalse(result);
    }

    @Test
    public void isValidWithUserServiceModel_whenValid_true() {
        UserRole userRole = RolesUtils.createUserRole();
        UserServiceModel userServiceModel = UsersUtils.getUserServiceModels(1, userRole).get(0);
        boolean result = userValidationService.isValid(userServiceModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithUserServiceModel_whenNull_false() {
        UserServiceModel userServiceModel = null;
        boolean result = userValidationService.isValid(userServiceModel);
        assertFalse(result);
    }

    @Test
    public void isValidWithUserRegisterBindingModel_whenValid_true() {
        UserRegisterBindingModel userRegisterBindingModel = UsersUtils.getUserRegisterBindingModel();
        boolean result = userValidationService.isValid(userRegisterBindingModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithUserRegisterBindingModel_whenNull_false() {
        UserRegisterBindingModel userRegisterBindingModel = null;
        boolean result = userValidationService.isValid(userRegisterBindingModel);
        assertFalse(result);
    }

    @Test
    public void isValidWithUserRegisterBindingModel_whenPasswordsDontMatch_false() {
        UserRegisterBindingModel userRegisterBindingModel = UsersUtils.getUserRegisterBindingModel();
        userRegisterBindingModel.setConfirmPassword("wrong_password");
        boolean result = userValidationService.isValid(userRegisterBindingModel);
        assertFalse(result);
    }

    @Test
    public void isValidWithPasswordAndConfirmPassword_whenPasswordsMatch_true() {
        String password = "1111";
        String confirmPassword = "1111";
        boolean result = userValidationService.isValid(password, confirmPassword);
        assertTrue(result);
    }

    @Test
    public void isValidWithPasswordAndConfirmPassword_whenPasswordsDontMatch_false() {
        String password = "1111";
        String confirmPassword = "wrong_password";
        boolean result = userValidationService.isValid(password, confirmPassword);
        assertFalse(result);
    }

    @Test
    public void isValidWithUserUpdateBindingModel_whenValid_true() {
        UserUpdateBindingModel userUpdateBindingModel = UsersUtils.getUserUpdateBindingModel();
        boolean result = userValidationService.isValid(userUpdateBindingModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithUserUpdateBindingModel_whenNull_false() {
        UserUpdateBindingModel userUpdateBindingModel = null;
        boolean result = userValidationService.isValid(userUpdateBindingModel);
        assertFalse(result);
    }

    @Test
    public void isValidWithUserDetails_whenValid_true() {
        UserDetails user = UsersUtils.createUser();
        boolean result = userValidationService.isValid(user);
        assertTrue(result);
    }

    @Test
    public void isValidWithUserDetails_whenNull_false() {
        UserDetails user = null;
        boolean result = userValidationService.isValid(user);
        assertFalse(result);
    }
}
