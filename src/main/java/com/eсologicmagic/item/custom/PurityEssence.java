package com.eсologicmagic.item.custom;

import com.eсologicmagic.util.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;

public class PurityEssence extends Item {
    public PurityEssence() {
        super(new Item.Properties().stacksTo(16).tab(ECOLOGICALL));
    }
    
}
