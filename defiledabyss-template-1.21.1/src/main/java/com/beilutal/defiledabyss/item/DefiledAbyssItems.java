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
    public static final DeferredItem<Item> GREENAPPLE = ITEMS.register("greenapple",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ABYSSRAG = ITEMS.register("abyssrag",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ABYSSIRON_INGOT = ITEMS.register("abyssiron_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PROFANE_SHARD = ITEMS.register("profane_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARRION_CROW_FEATHER = ITEMS.register("carrion_crow_feather",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ABYSSAL_HORN = ITEMS.register("abyssal_horn",
            () -> new Item(new Item.Properties().durability(10)));
    public static final DeferredItem<Item> ABYSSAL_MUTTON = ITEMS.register("abyssal_mutton",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ABYSS_TOTEM = ITEMS.register("abyss_totem",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPINECRUSHER_HAFT = ITEMS.register("spinecrusher_haft",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
