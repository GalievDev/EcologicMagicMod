package com.valion.ecologicmagic.item;

import com.valion.ecologicmagic.integrated.IntegrationHandler;
import com.valion.ecologicmagic.setup.ModSetup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;

public class EcologicRing extends Item {
    public EcologicRing() {
        super(new Item.Properties().tab(ModSetup.ECOLOGICALL).stacksTo(1));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        if (ModList.get().isLoaded("curios")) {
            return IntegrationHandler.loadCurioCapability();
        }
        return super.initCapabilities(stack, nbt);
    }
}
