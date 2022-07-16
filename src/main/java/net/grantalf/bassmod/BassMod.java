package net.grantalf.bassmod;

import net.fabricmc.api.ModInitializer;
import net.grantalf.bassmod.block.ModBlocks;
import net.grantalf.bassmod.item.ModItems;
import net.grantalf.bassmod.util.ModRegistries;
import net.grantalf.bassmod.world.dimension.ModDimensions;
import net.grantalf.bassmod.world.feature.ModConfiguredFeatures;
import net.grantalf.bassmod.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BassMod implements ModInitializer {
	public static final String MOD_ID = "bassmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModWorldGen.generateModWorldGen();

		ModDimensions.register();
	}
}
