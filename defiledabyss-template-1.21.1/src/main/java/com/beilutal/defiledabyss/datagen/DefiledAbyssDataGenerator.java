package com.beilutal.defiledabyss.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DefiledAbyssDataGenerator {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();

        // 在这里添加具体的数据生成器
        // 例如，生成块标签、物品模型等
        // generator.addProvider(true, new ModBlockTagProvider(output, lookupProvider, existingFileHelper));
    }
}