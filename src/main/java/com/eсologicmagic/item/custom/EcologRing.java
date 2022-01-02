package com.eсologicmagic.item.custom;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.server.permission.context.IContext;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Objects;

import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;
import static io.netty.util.ResourceLeakDetector.isEnabled;

public class EcologRing extends Item implements ICurioItem {
    public EcologRing() {
        super(new Item.Properties().tab(ECOLOGICALL).stacksTo(1));
    }
    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
    {
        if(!livingEntity.hasEffect(Effects.REGENERATION)) {
            EffectInstance effectInstance = new EffectInstance(Effects.REGENERATION, Integer.MAX_VALUE, 2, false, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
        }
    }

    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity, ItemStack stack)
    {
            return livingEntity.removeEffect(Effects.REGENERATION);
    }
}
