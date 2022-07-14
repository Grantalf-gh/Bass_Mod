package net.grantalf.bassmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.AmongusEntity;
import net.grantalf.bassmod.entity.custom.BassEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<BassEntity> BASS = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BassMod.MOD_ID, "bass"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, BassEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 0.5f)).build());

    public static final EntityType<AmongusEntity> AMONGUS = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BassMod.MOD_ID, "amongus"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AmongusEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.4f)).build());
}
