package com.valion.ecologicmagic.integrated.curio;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CurioHandler implements ICurio {
    @Override
    public boolean canEquipFromUse(SlotContext slotContext) {
        return true;
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity) {
        if (!livingEntity.hasEffect(Effects.REGENERATION)) {
            EffectInstance regen = new EffectInstance(Effects.REGENERATION, Integer.MAX_VALUE, 2, false, false);
            livingEntity.addEffect(regen);
        }
    }

    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity) {
        return livingEntity.removeEffect(Effects.REGENERATION);
    }
}
