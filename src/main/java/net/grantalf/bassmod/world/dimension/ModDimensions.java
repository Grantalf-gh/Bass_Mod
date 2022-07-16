package net.grantalf.bassmod.world.dimension;

import net.grantalf.bassmod.BassMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> SUSDIM_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(BassMod.MOD_ID, "susdim"));
    public static final RegistryKey<DimensionType> SUSDIM_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            SUSDIM_DIMENSION_KEY.getValue());

    public static void register() {
        BassMod.LOGGER.debug("Registering ModDimensions for " + BassMod.MOD_ID);
    }
}
