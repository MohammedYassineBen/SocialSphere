package ensa.socialsphere.services;

import ensa.socialsphere.domain.models.bindingModels.message.MessageCreateBindingModel;
import ensa.socialsphere.domain.models.serviceModels.MessageServiceModel;
import ensa.socialsphere.domain.models.viewModels.message.MessageFriendsViewModel;

import java.util.List;

public interface MessageService {

    MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception;

    List<MessageServiceModel> getAllMessages(String loggedInUsername, String chatUserId);

    List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername);
}
