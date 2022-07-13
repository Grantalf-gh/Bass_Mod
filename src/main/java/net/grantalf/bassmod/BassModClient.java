package net.grantalf.bassmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.grantalf.bassmod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class BassModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EBONY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EBONY_TRAPDOOR, RenderLayer.getCutout());
    }
}
