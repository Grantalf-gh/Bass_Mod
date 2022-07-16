package net.grantalf.bassmod.entity.custom;

import net.grantalf.bassmod.entity.variants.ImposterVariant;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class ImposterEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(ImposterEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public ImposterEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
        this.experiencePoints = 8;
        }

    public boolean isAngryAt(PlayerEntity player) {
        return true;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    public void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(4, new AttackGoal(this));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.targetSelector.add(1, new TargetGoal(this, PlayerEntity.class));
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        return null;
    }


    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty,
                                 SpawnReason spawnReason, @Nullable EntityData entityData,
                                 @Nullable NbtCompound entityNbt) {
        ImposterVariant variant = Util.getRandom(ImposterVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    private static class TargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {

        public TargetGoal(ImposterEntity imposter, Class<T> targetClass) {
            super(imposter, targetClass, true);
        }

    }





    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    public ImposterVariant getVariant() {
        return ImposterVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound p_21815_) {
        super.readCustomDataFromNbt(p_21815_);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, p_21815_.getInt("Variant"));
    }

    private void setVariant(ImposterVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }
}
