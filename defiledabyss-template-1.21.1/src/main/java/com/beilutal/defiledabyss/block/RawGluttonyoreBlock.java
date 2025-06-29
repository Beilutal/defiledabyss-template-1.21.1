package com.beilutal.defiledabyss.block;

import com.beilutal.defiledabyss.block.natural.spreadable.ISpreadable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;


import java.util.Map;

/**
 * RawGluttonyore 原矿方块，实现了 ISpreadable 蔓延逻辑：
 *  - 硬度 3，需钻石镐采掘
 *  - 光照等级 8，遮光度保持默认（15）
 *  - 随机刻触发蔓延：向一格内的石头、深板岩、花岗岩、闪长岩、安山岩方块蔓延
 *  - 当半径 3 格内同类方块数量 ≥ 10 时停止蔓延
 */
public class RawGluttonyoreBlock extends Block implements ISpreadable {
    public RawGluttonyoreBlock() {
        super(BlockBehaviour.Properties
                .of()
                .strength(3f)                          // 硬度 3f
                .requiresCorrectToolForDrops()         // 需正确工具（钻石镐）
                .sound(net.minecraft.world.level.block.SoundType.STONE)
                .lightLevel(state -> 8)               // 亮度 8
                .randomTicks()                        // 支持随机 Tick
        );
        // 默认开启 STILL_ALIVE=true
        this.registerDefaultState(this.defaultBlockState().setValue(ISpreadable.STILL_ALIVE, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        // 添加 STILL_ALIVE 属性
        builder.add(ISpreadable.STILL_ALIVE);
    }

    @Override
    public ISpreadable.Type getType() {
        // 定义可替换的方块类型映射
        return new ISpreadable.Type("raw_gluttonyore", Map.of(
                Blocks.STONE, this,
                Blocks.DEEPSLATE, this,
                Blocks.GRANITE, this,
                Blocks.DIORITE, this,
                Blocks.ANDESITE, this
        ));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        // 只在 STILL_ALIVE=true 时尝试蔓延
        if (!state.getValue(ISpreadable.STILL_ALIVE)) return;

        // 统计 7×7×7 立方内同类方块数量
        int count = 0;
        for (BlockPos target : BlockPos.betweenClosed(pos.offset(-3, -3, -3), pos.offset(3, 3, 3))) {
            if (world.getBlockState(target).getBlock() == this) {
                if (++count >= 10) {
                    // 达到阈值，不再蔓延
                    return;
                }
            }
        }

        // 阈值未达，执行默认蔓延逻辑
        spread(state, world, pos, random);
    }
}
