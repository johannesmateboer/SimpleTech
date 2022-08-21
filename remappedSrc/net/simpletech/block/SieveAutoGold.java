package net.simpletech.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.simpletech.entity.SieveAutoGoldEntity;
import net.simpletech.init.SieveBlocks;
import org.jetbrains.annotations.Nullable;

public class SieveAutoGold extends SieveAuto{

    public SieveAutoGold(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SieveAutoGoldEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, SieveBlocks.SIEVE_AUTO_GOLD_ENTITY, SieveAutoGoldEntity::tick);
    }

}
