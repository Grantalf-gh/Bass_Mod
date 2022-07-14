package net.grantalf.bassmod.entity.client;

import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.AmongusEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AmongusModel extends AnimatedGeoModel<AmongusEntity> {
    @Override
    public Identifier getModelResource(AmongusEntity entity) {
        return new Identifier(BassMod.MOD_ID, "geo/amongus.geo.json");
    }

    @Override
    public Identifier getTextureResource(AmongusEntity entity) {
        return AmongusRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public Identifier getAnimationResource(AmongusEntity entity) {
        return new Identifier(BassMod.MOD_ID, "animations/amongus.animation.json");
    }
}
