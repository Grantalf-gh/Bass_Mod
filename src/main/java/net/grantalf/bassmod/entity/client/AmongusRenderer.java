package net.grantalf.bassmod.entity.client;

import com.google.common.collect.Maps;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.entity.custom.AmongusEntity;
import net.grantalf.bassmod.entity.variants.AmongusVariant;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class AmongusRenderer extends GeoEntityRenderer<AmongusEntity> {
    public static final Map<AmongusVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AmongusVariant.class), (map) -> {
                map.put(AmongusVariant.RED,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/amongus.png"));
                map.put(AmongusVariant.BLUE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/blueamongus.png"));
                map.put(AmongusVariant.GREEN,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/greenamongus.png"));
                map.put(AmongusVariant.PINK,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/pinkamongus.png"));
                map.put(AmongusVariant.ORANGE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/orangeamongus.png"));
                map.put(AmongusVariant.YELLOW,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/yellowamongus.png"));
                map.put(AmongusVariant.BLACK,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/blackamongus.png"));
                map.put(AmongusVariant.WHITE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/whiteamongus.png"));
                map.put(AmongusVariant.PURPLE,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/purpleamongus.png"));
                map.put(AmongusVariant.BROWN,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/brownamongus.png"));
                map.put(AmongusVariant.CYAN,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/cyanamongus.png"));
                map.put(AmongusVariant.LIME,
                        new Identifier(BassMod.MOD_ID, "textures/entity/amongus/limeamongus.png"));
            });

    public AmongusRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AmongusModel());
    }
    

    @Override
    public Identifier getTextureResource(AmongusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}