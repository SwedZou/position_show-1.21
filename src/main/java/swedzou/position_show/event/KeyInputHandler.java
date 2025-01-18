package swedzou.position_show.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import swedzou.position_show.Position_show;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_TUTORIAL = "key.category.position_show.tutorial";
    public static final String KEY_SHOW_HIDE_FPS = "key.position_show.show_hide_fps";

    public static KeyBinding ShowHideFpsKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (ShowHideFpsKey.isPressed()) {
                // Toggle the visibility of the FPS display
                Position_show.showFPS = !Position_show.showFPS;
            }
        });
    }

    public static void register() {
        ShowHideFpsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            KEY_SHOW_HIDE_FPS,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            KEY_CATEGORY_TUTORIAL
        ));

        registerKeyInputs();
    }

}
