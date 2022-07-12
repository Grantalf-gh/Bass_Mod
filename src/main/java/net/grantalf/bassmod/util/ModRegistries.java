package net.grantalf.bassmod.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.grantalf.bassmod.block.ModBlocks;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
        registerFlammableBlocks();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.EBONY_LOG, ModBlocks.STRIPPED_EBONY_LOG);
        StrippableBlockRegistry.register(ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_WOOD);
    }

    private static void registerFlammableBlocks() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.EBONY_LOG, 5, 5);
        instance.add(ModBlocks.EBONY_WOOD, 5, 5);
        instance.add(ModBlocks.EBONY_PLANKS, 5, 20);
        instance.add(ModBlocks.STRIPPED_EBONY_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_EBONY_WOOD, 5, 5);
    }

}
