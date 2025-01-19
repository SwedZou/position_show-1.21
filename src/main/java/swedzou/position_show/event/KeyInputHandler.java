package swedzou.position_show.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import swedzou.position_show.Position_show;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_TUTORIAL = "key.category.position_show";
    public static final String KEY_SHOW_HIDE_FPS = "key.position_show.show_hide.fps";
    public static final String KEY_SHOW_HIDE_COORDINATES = "key.position_show.show_hide.coordinates";
    public static final String MORE_FPS = "key.position_show.more.fps";

    public static KeyBinding ShowHideFpsKey;
    public static KeyBinding ShowHideCoordinatesKey;
    public static KeyBinding MoreFpsKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (ShowHideFpsKey.wasPressed()) {
                // Toggle the visibility of the FPS display
                Position_show.showFPS = !Position_show.showFPS;
            };
            if (ShowHideCoordinatesKey.wasPressed()) {
                // toggles the visibility of the coordinates display
                Position_show.showCoordinates =!Position_show.showCoordinates;
            };
            if (MoreFpsKey.wasPressed()) {
                Position_show.moreFps = !Position_show.moreFps;
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
        ShowHideCoordinatesKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SHOW_HIDE_COORDINATES,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                KEY_CATEGORY_TUTORIAL
        ));
        MoreFpsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                MORE_FPS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F19,
                KEY_CATEGORY_TUTORIAL
        ));

        registerKeyInputs();
    }

}
