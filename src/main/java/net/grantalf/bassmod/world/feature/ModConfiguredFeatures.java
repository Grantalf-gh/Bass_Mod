package net.grantalf.bassmod.world.feature;

import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> EBONY_TREE =
            ConfiguredFeatures.register("ebony_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.EBONY_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.EBONY_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());


    public static final RegistryEntry<PlacedFeature> EBONY_CHECKED =
            PlacedFeatures.register("ebony_checked", EBONY_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.EBONY_SAPLING));


    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> EBONY_SPAWN =
            ConfiguredFeatures.register("ebony_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(EBONY_CHECKED, 0.5f)),
                            EBONY_CHECKED));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + BassMod.MOD_ID);
    }
}
