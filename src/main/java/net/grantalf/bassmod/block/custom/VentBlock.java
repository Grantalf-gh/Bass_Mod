package net.grantalf.bassmod.block.custom;

import net.grantalf.bassmod.BassMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class VentBlock extends Block {
    public static final DirectionProperty FACING = Properties.HOPPER_FACING;

    public VentBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(1, 1, 2.5, 2, 2, 13.5),
            Block.createCuboidShape(14, 1, 2.5, 15, 2, 13.5),
            Block.createCuboidShape(2, 1, 4.5, 14, 2, 5.5),
            Block.createCuboidShape(2, 1, 10.5, 14, 2, 11.5),
            Block.createCuboidShape(2, 1, 8.5, 14, 2, 9.5),
            Block.createCuboidShape(2, 1, 6.5, 14, 2, 7.5),
            Block.createCuboidShape(2, 1, 12.5, 14, 2, 13.5),
            Block.createCuboidShape(2, 1, 2.5, 14, 2, 3.5),
            Block.createCuboidShape(0, 0, 1.5, 16, 1, 14.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(2.5, 1, 1, 13.5, 2, 2),
            Block.createCuboidShape(2.5, 1, 14, 13.5, 2, 15),
            Block.createCuboidShape(10.5, 1, 2, 11.5, 2, 14),
            Block.createCuboidShape(4.5, 1, 2, 5.5, 2, 14),
            Block.createCuboidShape(6.5, 1, 2, 7.5, 2, 14),
            Block.createCuboidShape(8.5, 1, 2, 9.5, 2, 14),
            Block.createCuboidShape(2.5, 1, 2, 3.5, 2, 14),
            Block.createCuboidShape(12.5, 1, 2, 13.5, 2, 14),
            Block.createCuboidShape(1.5, 0, 0, 14.5, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(14, 1, 2.5, 15, 2, 13.5),
            Block.createCuboidShape(1, 1, 2.5, 2, 2, 13.5),
            Block.createCuboidShape(2, 1, 10.5, 14, 2, 11.5),
            Block.createCuboidShape(2, 1, 4.5, 14, 2, 5.5),
            Block.createCuboidShape(2, 1, 6.5, 14, 2, 7.5),
            Block.createCuboidShape(2, 1, 8.5, 14, 2, 9.5),
            Block.createCuboidShape(2, 1, 2.5, 14, 2, 3.5),
            Block.createCuboidShape(2, 1, 12.5, 14, 2, 13.5),
            Block.createCuboidShape(0, 0, 1.5, 16, 1, 14.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(2.5, 1, 14, 13.5, 2, 15),
            Block.createCuboidShape(2.5, 1, 1, 13.5, 2, 2),
            Block.createCuboidShape(4.5, 1, 2, 5.5, 2, 14),
            Block.createCuboidShape(10.5, 1, 2, 11.5, 2, 14),
            Block.createCuboidShape(8.5, 1, 2, 9.5, 2, 14),
            Block.createCuboidShape(6.5, 1, 2, 7.5, 2, 14),
            Block.createCuboidShape(12.5, 1, 2, 13.5, 2, 14),
            Block.createCuboidShape(2.5, 1, 2, 3.5, 2, 14),
            Block.createCuboidShape(1.5, 0, 0, 14.5, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }


    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0f, DamageSource.FALL);
        }
    }
    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if(entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.teleport(entity);
        }

        super.onEntityLand(world, entity);
    }

    public void teleport(Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.teleport(-86, 80, 286);
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
