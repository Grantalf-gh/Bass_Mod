package net.grantalf.bassmod.entity.client;

import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.BassEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BassRenderer extends GeoEntityRenderer<BassEntity> {
    public BassRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BassModel());
    }

    @Override
    public Identifier getTextureResource(BassEntity entity) {
        return new Identifier(BassMod.MOD_ID, "textures/entity/bass/bass.png");
    }
}
