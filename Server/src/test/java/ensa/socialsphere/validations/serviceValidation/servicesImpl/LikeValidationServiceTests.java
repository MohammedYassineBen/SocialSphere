package ensa.socialsphere.validations.serviceValidation.servicesImpl;

import ensa.socialsphere.domain.entities.Like;
import ensa.socialsphere.domain.entities.Post;
import ensa.socialsphere.domain.entities.User;
import ensa.socialsphere.validations.serviceValidation.services.LikeValidationService;
import org.junit.Before;
import org.junit.Test;

import ensa.socialsphere.testUtils.LikesUtils;
import ensa.socialsphere.testUtils.PostsUtils;
import ensa.socialsphere.testUtils.UsersUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LikeValidationServiceTests {
    private LikeValidationService likeValidationService;

    @Before
    public void setupTest() {
        likeValidationService = new LikeValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true() {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);
        Like like = LikesUtils.createLike(user, post);

        boolean result = likeValidationService.isValid(like);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false() {
        Like like = null;
        boolean result = likeValidationService.isValid(like);
        assertFalse(result);
    }
}
