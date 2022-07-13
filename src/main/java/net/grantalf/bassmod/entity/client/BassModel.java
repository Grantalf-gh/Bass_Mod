package net.grantalf.bassmod.entity.client;

import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.BassEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BassModel extends AnimatedGeoModel<BassEntity> {
    @Override
    public Identifier getModelResource(BassEntity entity) {
        return new Identifier(BassMod.MOD_ID, "geo/bass.geo.json");
    }

    @Override
    public Identifier getTextureResource(BassEntity entity) {
        return new Identifier(BassMod.MOD_ID, "textures/entity/bass/bass.png");
    }

    @Override
    public Identifier getAnimationResource(BassEntity entity) {
        return new Identifier(BassMod.MOD_ID, "animations/bass.animation.json");
    }
}
