package swedzou.position_show;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

public class Position_show implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("position_show");
	public static boolean showFPS = true;
	public static boolean showCoordinates = true;
	public static boolean moreFps = false;

	MinecraftClient client = MinecraftClient.getInstance();
	DecimalFormat numberFormat = new DecimalFormat("#.0000");


	@Override
	public void onInitialize() {

		HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
			if (showFPS) {
				if (moreFps) {
					drawContext.drawText(client.textRenderer, "FPS: " + client.getCurrentFps() * 5, 2, 2, 0xFFFFFFFF, false);
				} else {
					drawContext.drawText(client.textRenderer, "FPS: " + client.getCurrentFps(), 2, 2, 0xFFFFFFFF, false);
				}
            };
			if (showCoordinates) {
				String text = "X: " + numberFormat.format(client.player.getX()) + ", Y: " + numberFormat.format(client.player.getY()) + ", Z: " + numberFormat.format(client.player.getZ());
				drawContext.drawText(client.textRenderer, text, 2, 20, 0xFFFFFFFF, false);
			}
		});
	}
}