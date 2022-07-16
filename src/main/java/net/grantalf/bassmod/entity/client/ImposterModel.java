package net.grantalf.bassmod.entity.client;

import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.ImposterEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ImposterModel extends AnimatedGeoModel<ImposterEntity> {
    @Override
    public Identifier getModelResource(ImposterEntity entity) {
        return new Identifier(BassMod.MOD_ID, "geo/imposter.geo.json");
    }

    @Override
    public Identifier getTextureResource(ImposterEntity entity) {
        return ImposterRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public Identifier getAnimationResource(ImposterEntity entity) {
        return new Identifier(BassMod.MOD_ID, "animations/imposter.animation.json");
    }
}
