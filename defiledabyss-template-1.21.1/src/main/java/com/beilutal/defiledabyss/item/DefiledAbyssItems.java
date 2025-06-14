package com.beilutal.defiledabyss.item;

import com.beilutal.defiledabyss.DefiledAbyss;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DefiledAbyssItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DefiledAbyss.MODID);

    public static final DeferredItem<Item> GLUTTONYORE = ITEMS.register("gluttonyore",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
