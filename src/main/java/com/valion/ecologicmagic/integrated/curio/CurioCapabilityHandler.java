package com.valion.ecologicmagic.integrated.curio;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;

public class CurioCapabilityHandler implements ICapabilityProvider {
    private final LazyOptional<ICurio> curioOpt = LazyOptional.of(CurioHandler::new);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
    }
    
}
