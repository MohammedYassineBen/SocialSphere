package ensa.socialsphere.servicesImpl;

import ensa.socialsphere.domain.entities.Like;
import ensa.socialsphere.domain.entities.Post;
import ensa.socialsphere.domain.entities.User;
import ensa.socialsphere.repositories.LikeRepository;
import ensa.socialsphere.repositories.PostRepository;
import ensa.socialsphere.repositories.UserRepository;
import ensa.socialsphere.services.LikeService;
import ensa.socialsphere.utils.responseHandler.exceptions.CustomException;
import ensa.socialsphere.validations.serviceValidation.services.PostValidationService;
import ensa.socialsphere.validations.serviceValidation.services.UserValidationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ensa.socialsphere.testUtils.LikesUtils;
import ensa.socialsphere.testUtils.PostsUtils;
import ensa.socialsphere.testUtils.UsersUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LikeServiceTests {

    @Autowired
    private LikeService likeService;

    @MockBean
    private LikeRepository mocensaikeRepository;

    @MockBean
    private PostRepository mockPostRepository;

    @MockBean
    private UserRepository mockUserRepository;

    @MockBean
    private PostValidationService mockPostValidationService;

    @MockBean
    private UserValidationService mockUserValidationService;

    private List<Like> likes;

    @Before
    public void setUpTest() {
        likes = new ArrayList<>();
    }

    @Test
    public void getAllLikes_when5Likes_5Likes() throws Exception {
        // Arrange
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        List<Like> likeList = LikesUtils.getLikes(5, user, post);

        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(new Post()));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(true);

        when(mocensaikeRepository.findAllByPost(any()))
                .thenReturn(likeList);

        likes.addAll(likeList);

        // Act
        int actualSize = likeService.getAllLikesForPost("1");

        // Assert
        int expectedSize = likeList.size();

        assertEquals(expectedSize, actualSize);

        verify(mocensaikeRepository).findAllByPost(any());
        verifyNoMoreInteractions(mocensaikeRepository);
    }

    @Test(expected = Exception.class)
    public void getAllLikes_whenPostIsNotValid_throwException() throws Exception {
        // Arrange
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        List<Like> likeList = LikesUtils.getLikes(5, user, post);

        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(new Post()));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(false);

        when(mocensaikeRepository.findAllByPost(any()))
                .thenReturn(likeList);

        likes.addAll(likeList);

        // Act
        int actualSize = likeService.getAllLikesForPost("1");

        // Assert
        int expectedSize = likeList.size();

        assertEquals(expectedSize, actualSize);

        verify(mocensaikeRepository).findAllByPost(any());
        verifyNoMoreInteractions(mocensaikeRepository);
    }

    @Test
    public void addLike_whenUsersAndPostAreValid_addLike() throws Exception {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        // Arrange
        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(post));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(true);

        when(mockUserRepository.findById(any()))
                .thenReturn(java.util.Optional.of(user));

        when(mockUserValidationService.isValid(any(User.class))).thenReturn(true);

        when(mocensaikeRepository.findByUserAndPost(user, post))
                .thenReturn(null);

        // Act
        likeService.addLike("1", "1");

        // Assert
        verify(mocensaikeRepository).save(any());
        verify(mocensaikeRepository, times(1)).save(any());
    }

    @Test(expected = Exception.class)
    public void addLike_whenUserIsNotValid_throwException() throws Exception {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        // Arrange
        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(post));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(true);

        when(mockUserRepository.findById(any()))
                .thenReturn(java.util.Optional.of(user));

        when(mockUserValidationService.isValid(any(User.class)))
                .thenReturn(false);

        when(mocensaikeRepository.findByUserAndPost(user, post))
                .thenReturn(null);

        // Act
        likeService.addLike("1", "1");

        // Assert
        verify(mocensaikeRepository).save(any());
        verify(mocensaikeRepository, times(1)).save(any());
    }

    @Test(expected = Exception.class)
    public void addLike_whenPostIsNotValid_throwException() throws Exception {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        // Arrange
        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(post));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(false);

        when(mockUserRepository.findById(any()))
                .thenReturn(java.util.Optional.of(user));

        when(mockUserValidationService.isValid(any(User.class)))
                .thenReturn(true);

        when(mocensaikeRepository.findByUserAndPost(user, post))
                .thenReturn(null);

        // Act
        likeService.addLike("1", "1");

        // Assert
        verify(mocensaikeRepository).save(any());
        verify(mocensaikeRepository, times(1)).save(any());
    }

    @Test(expected = Exception.class)
    public void addLike_whenUserAndPostAreNotValid_throwException() throws Exception {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);

        // Arrange
        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(post));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(false);

        when(mockUserRepository.findById(any()))
                .thenReturn(java.util.Optional.of(user));

        when(mockUserValidationService.isValid(any(User.class)))
                .thenReturn(false);

        when(mocensaikeRepository.findByUserAndPost(user, post))
                .thenReturn(null);

        // Act
        likeService.addLike("1", "1");

        // Assert
        verify(mocensaikeRepository).save(any());
        verify(mocensaikeRepository, times(1)).save(any());
    }

    @Test(expected = CustomException.class)
    public void addLike_whenUserAlreadyLikedThisPost_throwException() throws Exception {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);
        Like like = LikesUtils.createLike(user, post);

        // Arrange
        when(mockPostRepository.findById(any()))
                .thenReturn(java.util.Optional.of(post));

        when(mockPostValidationService.isValid(any(Post.class)))
                .thenReturn(true);

        when(mockUserRepository.findById(any()))
                .thenReturn(java.util.Optional.of(user));

        when(mockUserValidationService.isValid(any(User.class)))
                .thenReturn(true);

        when(mocensaikeRepository.findByUserAndPost(user, post))
                .thenReturn(like);

        // Act
        likeService.addLike("1", "1");

        // Assert
        verify(mocensaikeRepository).save(any());
        verify(mocensaikeRepository, times(1)).save(any());
    }
}
