package com.valion.ecologicmagic.item;

import net.minecraft.item.ItemStack;

import static com.valion.ecologicmagic.setup.ModSetup.ECOLOGICALL;

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
