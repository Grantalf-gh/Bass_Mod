package net.grantalf.bassmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block EBONY_PLANKS = registerBlock("ebony_planks",
        new Block(FabricBlockSettings.of(Material.WOOD).strength(4f).requiresTool()), ModItemGroup.BASS);

    public static final Block EBONY_LOG = registerBlock("ebony_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4f).requiresTool()), ModItemGroup.BASS);

    public static final Block EBONY_WOOD = registerBlock("ebony_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(4f).requiresTool()), ModItemGroup.BASS);

    public static final Block STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f).requiresTool()), ModItemGroup.BASS);

    public static final Block STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f).requiresTool()), ModItemGroup.BASS);



    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(BassMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(BassMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks() {
        BassMod.LOGGER.debug("Registering MobBlocks for " + BassMod.MOD_ID);
    }
}
