package net.grantalf.bassmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.block.ModBlocks;
import net.grantalf.bassmod.entity.ModEntities;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item EBONY_SIGN = registerItem("ebony_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.BASS).maxCount(16),
                    ModBlocks.EBONY_SIGN_BLOCK, ModBlocks.EBONY_WALL_SIGN_BLOCK));

    public static final Item BASS_SPAWN_EGG = registerItem("bass_spawn_egg",
            new SpawnEggItem(ModEntities.BASS, 0x334124, 0xc1d5b5,
                    new FabricItemSettings().group(ModItemGroup.BASS)));

    public static final Item AMONGUS_SPAWN_EGG = registerItem("amongus_spawn_egg",
            new SpawnEggItem(ModEntities.AMONGUS, 0x1d3ce9, 0x00ffe4,
                    new FabricItemSettings().group(ModItemGroup.BASS)));
    public static final Item IMPOSTER_SPAWN_EGG = registerItem("imposter_spawn_egg",
            new SpawnEggItem(ModEntities.IMPOSTER, 0xff1500, 0x00ffe4,
                    new FabricItemSettings().group(ModItemGroup.BASS)));

    public static final Item POOP = registerItem("poop",
            new Item(new FabricItemSettings().group(ModItemGroup.BASS)
                    .food(new FoodComponent.Builder().hunger(20).saturationModifier(1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 4), 1f)
                            .alwaysEdible().build())));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(BassMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BassMod.LOGGER.debug("Registering Mod Items for " + BassMod.MOD_ID);
    }
}
