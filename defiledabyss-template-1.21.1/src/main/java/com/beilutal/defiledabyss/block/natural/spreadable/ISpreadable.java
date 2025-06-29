package com.beilutal.defiledabyss.block.natural.spreadable;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Map;

public interface ISpreadable {
    // 代表是否还能继续扩散
    BooleanProperty STILL_ALIVE = BooleanProperty.create("still_alive");

    Type getType();

    // 默认扩散逻辑
    default void spread(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!state.getValue(STILL_ALIVE)) return;

        for (Direction dir : Direction.values()) {
            BlockPos targetPos = pos.relative(dir);
            BlockState targetState = world.getBlockState(targetPos);
            Block targetBlock = getType().blockMap.get(targetState.getBlock());
            if (targetBlock != null) {
                world.setBlockAndUpdate(targetPos, targetBlock.defaultBlockState());
            }
        }

        // 蔓延后有一定几率停止扩散
        if (random.nextFloat() < 0.3f) {
            world.setBlockAndUpdate(pos, state.setValue(STILL_ALIVE, false));
        }
    }

    /**
     * 类型描述器，包含从哪些方块能蔓延到哪些方块
     */
    class Type {
        public final String id;
        public final Map<Block, Block> blockMap;

        public Type(String id, Block targetBlock, Block... replaceable) {
            this.id = id;
            ImmutableMap.Builder<Block, Block> builder = ImmutableMap.builder();
            for (Block replace : replaceable) {
                builder.put(replace, targetBlock);
            }
            this.blockMap = builder.build();
        }

        public Type(String id, Map<Block, Block> blockMap) {
            this.id = id;
            this.blockMap = blockMap;
        }
    }
}
