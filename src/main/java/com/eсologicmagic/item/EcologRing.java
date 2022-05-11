package com.eсologicmagic.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;

public class EcologRing extends Item implements ICurioItem {
    public EcologRing() {
        super(new Item.Properties().tab(ECOLOGICALL).stacksTo(1));
    }
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
