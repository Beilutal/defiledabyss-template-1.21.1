package com.beilutal.defiledabyss.block;

import com.beilutal.defiledabyss.DefiledAbyss;
import com.beilutal.defiledabyss.item.DefiledAbyssItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DefiledAbyssBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(DefiledAbyss.MODID);

    public static final DeferredBlock<Block> RAW_GLUTTONYORE = registerBlock("raw_gluttonyore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(3f) // 硬度3
                    .requiresCorrectToolForDrops() // 需要正确工具
                    .sound(SoundType.STONE)
                    .lightLevel(state -> 5) // 亮度5
                    .noOcclusion() // 允许光线穿透//
                    ));

    public static final DeferredBlock<Block> GLUTTONYSTONE = registerBlock("gluttonystone",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(3f) // 硬度3
                    .requiresCorrectToolForDrops() // 需要正确工具
                    .sound(SoundType.STONE)
                    .lightLevel(state -> 0) // 亮度0
                    .noOcclusion() // 允许光线穿透//
            ));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DefiledAbyssItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
