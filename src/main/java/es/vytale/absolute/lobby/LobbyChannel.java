package es.vytale.absolute.lobby;

import com.google.gson.Gson;
import es.vytale.absolute.Absolute;
import es.vytale.milanesa.common.redis.data.MilanesaChannel;
import es.vytale.milanesa.common.redis.data.MilanesaMessage;
import lombok.RequiredArgsConstructor;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * don't remove this messages and
 * give me the credits. Arigato! n.n
 */
public class LobbyChannel extends MilanesaChannel {

    private final Absolute absolute;
    private final Gson gson;

    public LobbyChannel(Absolute absolute) {
        super("lobbies::update");
        this.absolute = absolute;
        this.gson = new Gson();
    }

    @Override
    public void handle(MilanesaMessage milanesaMessage) {
        LobbyData lobbyData = gson.fromJson(milanesaMessage.getData(), LobbyData.class);
        absolute.getLobbyManager().getOrCreate(lobbyData.getId()).load(lobbyData);
    }
}
