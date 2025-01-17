package swedzou.position_show;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

public class Position_show implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("position_show");

	MinecraftClient client = MinecraftClient.getInstance();
	DecimalFormat numberFormat = new DecimalFormat("#.000");

	@Override
	public void onInitialize() {

		HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
			drawContext.drawText(client.textRenderer, "FPS: " + client.getCurrentFps(), 2, 2, 0xFFFFFFFF, false);


			String text = "X: " + numberFormat.format(client.player.getX()) + ", Y: " + numberFormat.format(client.player.getY()) + ", Z: " + numberFormat.format(client.player.getZ());

			LOGGER.info(String.valueOf(Math.round(((float) client.getWindow().getWidth() / 2) - ((float) client.textRenderer.getWidth(text) / 2))));
			LOGGER.info(String.valueOf(client.getWindow().getHeight()));

			drawContext.drawText(client.textRenderer, text, Math.round(((float) client.getWindow().getWidth() / 2) - ((float) client.textRenderer.getWidth(text) / 2)), 50, 0xFFFFFFFF, false);
		});
	}
}