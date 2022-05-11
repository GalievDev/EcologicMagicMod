package com.eсologicmagic.item;

import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;

public class EcologStaff extends MagicItem {
    public EcologStaff() {
        super( new Properties().stacksTo(1).tab(ECOLOGICALL));
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return null;
    }
}
