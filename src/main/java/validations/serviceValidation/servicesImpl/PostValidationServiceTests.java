package validations.serviceValidation.servicesImpl;

import entities.Post;
import entities.User;
import models.bindingModels.post.PostCreateBindingModel;
import testUtils.PostsUtils;
import testUtils.UsersUtils;
import validations.serviceValidation.services.PostValidationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PostValidationServiceTests {
    private PostValidationService postValidationService;

    @Before
    public void setupTest(){
        postValidationService = new PostValidationServiceImpl();
    }

    @Test
    public void isValidWithPost_whenValid_true(){
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        boolean result = postValidationService.isValid(post);
        assertTrue(result);
    }

    @Test
    public void isValidWithPost_whenNull_false(){
        Post post =  null;
        boolean result = postValidationService.isValid(post);
        assertFalse(result);
    }

    @Test
    public void isValidWithPostCreateBindingModel_whenValid_true(){
        PostCreateBindingModel postCreateBindingModel = PostsUtils.getPostCreateBindingModels(1).get(0);
        boolean result = postValidationService.isValid(postCreateBindingModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithPostCreateBindingModel_whenNull_false(){
        PostCreateBindingModel postCreateBindingModel =   null;
        boolean result = postValidationService.isValid(postCreateBindingModel);
        assertFalse(result);
    }
}
