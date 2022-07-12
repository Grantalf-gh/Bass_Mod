package net.grantalf.bassmod;

import net.fabricmc.api.ModInitializer;
import net.grantalf.bassmod.block.ModBlocks;
import net.grantalf.bassmod.item.ModItems;
import net.grantalf.bassmod.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BassMod implements ModInitializer {
	public static final String MOD_ID = "bassmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
	}
}
