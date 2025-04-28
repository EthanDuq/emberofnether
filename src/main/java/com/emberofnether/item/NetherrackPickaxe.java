package com.emberofnether.item;

import com.emberofnether.materials.ModToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class NetherrackPickaxe extends PickaxeItem {
    private static final Map<Block, Item> BLOCK_MELTING_MAP = Map.of(
        Blocks.STONE,       Items.STONE,
        Blocks.COBBLESTONE, Items.STONE,
        Blocks.COPPER_ORE,  Items.COPPER_INGOT,
        Blocks.IRON_ORE,    Items.IRON_INGOT,
        Blocks.GOLD_ORE,    Items.GOLD_INGOT
    );

    public NetherrackPickaxe() {
        super(ModToolMaterials.NETHERRACK_INGOT, 1, -2.8F, new Item.Settings());
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        // Check if mining is taking place server-side
        if (!world.isClient) {
            Block block = state.getBlock();
            if (BLOCK_MELTING_MAP.containsKey(block)) {
                world.breakBlock(pos, false);
                world.spawnEntity(new ItemEntity(
                        world, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(BLOCK_MELTING_MAP.get(block))
                ));
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
