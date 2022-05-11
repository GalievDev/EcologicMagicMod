package com.valion.eсologicmagic.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class EcologicRingCurio implements ICurioItem {
    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        if(!livingEntity.hasEffect(Effects.REGENERATION)) {
            EffectInstance effectInstance = new EffectInstance(Effects.REGENERATION, Integer.MAX_VALUE, 2, false, false);

            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            
            livingEntity.addEffect(effectInstance);
        }
    }

    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity, ItemStack stack){
            return livingEntity.removeEffect(Effects.REGENERATION);
    }
}
