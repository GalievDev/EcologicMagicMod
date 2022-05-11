package com.valion.eсologicmagic.item;

import net.minecraft.item.ItemStack;

import static com.valion.eсologicmagic.setup.ModSetup.ECOLOGICALL;

import java.util.function.Predicate;

public class EcologStaff extends MagicItem {
    public EcologStaff() {
        super( new Properties().stacksTo(1).tab(ECOLOGICALL));
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return null;
    }
}
