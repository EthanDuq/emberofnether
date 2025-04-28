package com.emberofnether.item;

import com.emberofnether.materials.ModToolMaterials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class NetherrackSword extends SwordItem {

    private static final int FIRE_DURATION = 6;

    public NetherrackSword() {
        super(ModToolMaterials.NETHERRACK_INGOT, 3, -2.4F, new Item.Settings());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(FIRE_DURATION);
        return super.postHit(stack, target, attacker);
    }
}
