package swedzou.position_show;

import net.fabricmc.api.ClientModInitializer;
import swedzou.position_show.event.KeyInputHandler;

public class Position_showClient implements ClientModInitializer {
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
