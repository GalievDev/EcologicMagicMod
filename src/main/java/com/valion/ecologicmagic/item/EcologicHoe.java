package com.valion.ecologicmagic.item;


import static com.valion.ecologicmagic.item.tiers.ModItemTier.PROSPERITY_STONE;
import static com.valion.ecologicmagic.setup.ModSetup.ECOLOGICALL;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;

public class EcologicHoe extends HoeItem {
    public static boolean skip = false;


    public EcologicHoe() {
        super(PROSPERITY_STONE, 10, 3F, new Properties().fireResistant().tab(ECOLOGICALL));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        return true;
    }
}

