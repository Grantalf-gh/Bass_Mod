package net.grantalf.bassmod.entity.client;

import com.google.common.collect.Maps;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.ImposterEntity;
import net.grantalf.bassmod.entity.variants.ImposterVariant;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class ImposterRenderer extends GeoEntityRenderer<ImposterEntity> {
    public static final Map<ImposterVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ImposterVariant.class), (map) -> {
                map.put(ImposterVariant.RED,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/imposter.png"));
                map.put(ImposterVariant.BLUE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/blueimposter.png"));
                map.put(ImposterVariant.GREEN,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/greenimposter.png"));
                map.put(ImposterVariant.PINK,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/pinkimposter.png"));
                map.put(ImposterVariant.ORANGE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/orangeimposter.png"));
                map.put(ImposterVariant.YELLOW,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/yellowimposter.png"));
                map.put(ImposterVariant.BLACK,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/blackimposter.png"));
                map.put(ImposterVariant.WHITE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/whiteimposter.png"));
                map.put(ImposterVariant.PURPLE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/purpleimposter.png"));
                map.put(ImposterVariant.BROWN,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/brownimposter.png"));
                map.put(ImposterVariant.CYAN,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/cyanimposter.png"));
                map.put(ImposterVariant.LIME,
                        new Identifier(BassMod.MOD_ID, "textures/entity/imposter/limeimposter.png"));

            });

    public ImposterRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ImposterModel());
    }
    

    @Override
    public Identifier getTextureResource(ImposterEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}