package net.grantalf.bassmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup BASS = FabricItemGroupBuilder.build(
            new Identifier(BassMod.MOD_ID, "bass"), () -> new ItemStack(ModBlocks.EBONY_PLANKS));
}
