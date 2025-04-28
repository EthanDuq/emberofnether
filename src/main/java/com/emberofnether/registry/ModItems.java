package com.emberofnether.registry;

import com.emberofnether.EmberOfNether;
import com.emberofnether.item.NetherrackPickaxe;
import com.emberofnether.item.NetherrackSword;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item NETHERRACK_SWORD = register("netherrack_sword", new NetherrackSword());
    public static final Item NETHERRACK_PICKAXE = register("netherrack_pickaxe", new NetherrackPickaxe());
    public static final Item NETHERRACK_INGOT = register("netherrack_ingot", new Item(new Item.Settings()));
    public static final Item NETHERRACK_DUST = register("netherrack_dust", new Item(new Item.Settings()));

    private static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(EmberOfNether.MOD_ID, name), item);
    }

    public static void registerItems() {
        EmberOfNether.LOGGER.info("Registering Mod Items for " + EmberOfNether.MOD_ID);

        // Adding items to itemGroups COMBAT
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(NETHERRACK_SWORD);
        });

        // Adding items to itemGroups TOOLS
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(NETHERRACK_PICKAXE);
        });

        // Adding items to itemGroups INGREDIENTS
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(NETHERRACK_INGOT);
            entries.add(NETHERRACK_DUST);
        });
    }
}
