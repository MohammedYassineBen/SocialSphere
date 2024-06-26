package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.UserRole;
import ensa.socialsphere.validations.serviceValidation.services.RoleValidationService;
import org.junit.Before;
import org.junit.Test;

import ensa.socialsphere.testUtils.RolesUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RoleValidationServiceTests {
    private RoleValidationService roleValidationService;

    @Before
    public void setupTest(){
        roleValidationService = new RoleValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true(){
        UserRole userRole = RolesUtils.createUserRole();
        boolean result = roleValidationService.isValid(userRole);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false(){
        UserRole userRole =  null;
        boolean result = roleValidationService.isValid(userRole);
        assertFalse(result);
    }
}
