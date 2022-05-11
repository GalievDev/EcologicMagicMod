package com.valion.eсologicmagic.item;

import static com.valion.eсologicmagic.setup.ModSetup.ECOLOGICALL;

import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;

public class EcologRing extends Item {
    public EcologRing() {
        super(new Item.Properties().tab(ECOLOGICALL).stacksTo(1));

        if (ModList.get().isLoaded("curios")) new EcologicRingCurio();
    }
}
