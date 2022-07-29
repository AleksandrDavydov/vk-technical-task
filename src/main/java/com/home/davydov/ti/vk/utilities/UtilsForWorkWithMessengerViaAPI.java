package com.home.davydov.ti.vk.utilities;

import com.home.davydov.ti.vk.model.dto.conversation.CreateConversationDTO;
import com.home.davydov.ti.vk.model.dto.conversation.Item;

import java.util.List;

import static com.home.davydov.ti.vk.utilities.api.MessengerRestApiClient.*;
import static com.home.davydov.ti.vk.utilities.localstoreg.UtilsForLocalStorage.getAccessToken;

public class UtilsForWorkWithMessengerViaAPI {

    public static void deleteLastChat() {
        String accessToken = getAccessToken();
        int id = getAllConversation(accessToken).response.items.get(0).conversation.peer.id;
        deleteChatByPeerId(accessToken, id);
    }

    public static void deleteChatById(int id) {
        int peerId;
        String accessToken = getAccessToken();
        if (id < 2000000000) {
            peerId = 2000000000 + id;
        } else {
            peerId = id;
        }
        deleteChatByPeerId(accessToken, peerId);
    }

    public static CreateConversationDTO createNewChatViaAPI(String title) {
        String accessToken = getAccessToken();
        return createConversation(accessToken, title);
    }

    public static int getIdOfChatByTitle(String title) {
        String accessToken = getAccessToken();
        List<Item> items = getAllConversation(accessToken).response.items;
        List<Item> testChat = items.stream().filter(x -> x.conversation.chat_settings.title.equals(title)).toList();
        return testChat.get(0).conversation.peer.id;
    }
}
