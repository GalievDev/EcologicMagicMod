package com.valion.eсologicmagic.item;

import static com.valion.eсologicmagic.setup.ModSetup.ECOLOGICALL;

import net.minecraft.item.Item;

public class PurityEssence extends Item {
    public PurityEssence() {
        super(new Item.Properties().stacksTo(16).tab(ECOLOGICALL));
    }
    
}
