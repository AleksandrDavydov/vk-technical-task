package com.home.davydov.ti.vk.utilities.api;

import com.home.davydov.ti.vk.model.dto.conversation.CreateConversationDTO;
import com.home.davydov.ti.vk.model.dto.conversation.RootConversationDTO;

import static com.home.davydov.ti.vk.utilities.api.RestApiClient.*;
import static com.home.davydov.ti.vk.utilities.api.RestApiHelper.*;

public class MessengerRestApiClient {

    public static RootConversationDTO getAllConversation(String accessToken) {
        var url = getMessengerGetUrl();
        return postForGetMessages(url, accessToken, RootConversationDTO.class);
    }

    public static void deleteChatByPeerId(String accessToken, int peerId) {
        var url = getDeleteMessengerUrl();
        postForDeleteChat(url, accessToken, peerId);
    }

    public static CreateConversationDTO createConversation(String accessToken, String title) {
        var url = getCreateChatUrl();
        return postForCreateChat(url, accessToken, title, CreateConversationDTO.class);
    }
}
