package com.beilutal.defiledabyss.item;

import com.beilutal.defiledabyss.DefiledAbyss;
import com.beilutal.defiledabyss.block.DefiledAbyssBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DefiledAbyssCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DefiledAbyss.MODID);

            public static final Supplier<CreativeModeTab> ABYSS_MATERIALS_TAB = CREATIVE_MODE_TAB.register("abyss_items_tab",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(DefiledAbyssItems.PROFANE_SHARD.get()))
                        .title(Component.translatable("creativetab.defiledabyss.abyss_materials"))
                        .displayItems(((itemDisplayParameters, output) -> {
                            output.accept(DefiledAbyssItems.PROFANE_SHARD);
                            output.accept(DefiledAbyssItems.ABYSSIRON_INGOT);
                            output.accept(DefiledAbyssItems.CARRION_CROW_FEATHER);
                            output.accept(DefiledAbyssItems.ABYSSRAG);
                            output.accept(DefiledAbyssItems.GLUTTONYORE);
                            output.accept(DefiledAbyssItems.PROFANE_SHARD);
                        } )).build());

    public static final Supplier<CreativeModeTab> ABYSS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("abyss_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DefiledAbyssBlocks.RAW_GLUTTONYORE))
                    .title(Component.translatable("creativetab.defiledabyss.abyss_blocks"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(DefiledAbyssBlocks.GLUTTONYSTONE);
                        output.accept(DefiledAbyssBlocks.RAW_GLUTTONYORE);
                    } )).build());

    public static final Supplier<CreativeModeTab> ABYSS_FOODS_TAB = CREATIVE_MODE_TAB.register("abyss_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DefiledAbyssItems.GREENAPPLE.get()))
                    .title(Component.translatable("creativetab.defiledabyss.abyss_foods"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(DefiledAbyssItems.GREENAPPLE);
                        output.accept(DefiledAbyssItems.ABYSSAL_MUTTON);
                    } )).build());

    public static final Supplier<CreativeModeTab> ABYSS_TOOLS_TAB = CREATIVE_MODE_TAB.register("abyss_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DefiledAbyssItems.ABYSSAL_HORN.get()))
                    .title(Component.translatable("creativetab.defiledabyss.abyss_tools"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(DefiledAbyssItems.ABYSSAL_HORN);

                    } )).build());

            public static void register(IEventBus eventBus){
                CREATIVE_MODE_TAB.register(eventBus);
            }

}
