package net.grantalf.bassmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.block.entity.ModSignTypes;
import net.grantalf.bassmod.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block EBONY_PLANKS = registerBlock("ebony_planks",
        new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(2f)), ModItemGroup.BASS);
    public static final Block EBONY_LOG = registerBlock("ebony_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(2f)), ModItemGroup.BASS);
    public static final Block EBONY_WOOD = registerBlock("ebony_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(2f)), ModItemGroup.BASS);
    public static final Block STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(2f)), ModItemGroup.BASS);
    public static final Block STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).strength(2f)), ModItemGroup.BASS);

    public static final Block EBONY_BUTTON = registerBlock("ebony_button",
            new WoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).strength(2f).noCollision()), ModItemGroup.BASS);
    public static final Block EBONY_PRESSURE_PLATE = registerBlock("ebony_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).strength(2f)), ModItemGroup.BASS);

    public static final Block EBONY_SLAB = registerBlock("ebony_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).strength(2f)),ModItemGroup.BASS);
    public static final Block EBONY_STAIRs = registerBlock("ebony_stairs",
            new StairsBlock(ModBlocks.EBONY_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).strength(2f)),ModItemGroup.BASS);

    public static final Block EBONY_DOOR = registerBlock("ebony_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).strength(2f).nonOpaque()), ModItemGroup.BASS);
    public static final Block EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).strength(2f).nonOpaque()), ModItemGroup.BASS);

    public static final Block EBONY_FENCE = registerBlock("ebony_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).strength(2f)), ModItemGroup.BASS);
    public static final Block EBONY_FENCE_GATE = registerBlock("ebony_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).strength(2f)), ModItemGroup.BASS);

    public static final Block EBONY_WALL_SIGN_BLOCK = registerBlockWithoutItem("ebony_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.EBONY), ModItemGroup.BASS);
    public static final Block EBONY_SIGN_BLOCK = registerBlockWithoutItem("ebony_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.EBONY), ModItemGroup.BASS);

    public static Block registerBlockWithoutItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.BLOCK, new Identifier(BassMod.MOD_ID, name), block);
    }
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
