package services;

import models.bindingModels.post.PostCreateBindingModel;
import models.serviceModels.PostServiceModel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PostService {
    boolean createPost(PostCreateBindingModel postCreateBindingModel) throws Exception;

    List<PostServiceModel> getAllPosts(String timelineUserId);

    CompletableFuture<Boolean> deletePost(String loggedInUserId, String postToRemoveId) throws Exception;
}
