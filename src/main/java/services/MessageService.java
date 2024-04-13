package services;

import models.bindingModels.message.MessageCreateBindingModel;
import models.serviceModels.MessageServiceModel;
import models.viewModels.message.MessageFriendsViewModel;

import java.util.List;

public interface MessageService {

    MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception;

    List<MessageServiceModel> getAllMessages(String loggedInUsername, String chatUserId);

    List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername);
}
