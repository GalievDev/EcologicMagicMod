package com.eсologicmagic.item;

import net.minecraft.item.Item;

import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;

public class PurityEssence extends Item {
    public PurityEssence() {
        super(new Item.Properties().stacksTo(16).tab(ECOLOGICALL));
    }
    
}
