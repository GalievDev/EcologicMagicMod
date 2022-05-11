package com.valion.ecologicmagic.item;

import static com.valion.ecologicmagic.setup.ModSetup.ECOLOGICALL;

import net.minecraft.item.Item;

public class PurityEssence extends Item {
    public PurityEssence() {
        super(new Item.Properties().stacksTo(16).tab(ECOLOGICALL));
    }
    
}
