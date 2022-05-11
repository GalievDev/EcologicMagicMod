package com.valion.ecologicmagic.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.util.Hand;

import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public abstract class MagicItem extends Item {
    public static final Predicate<ItemStack> MAGIC_ONLY =
            (magic_only) -> magic_only.getItem().is((ITag<Item>) EntityType.FIREBALL);

    public static final Predicate<ItemStack> ARROW_OR_FIREWORK = MAGIC_ONLY.or(
            (magic_only) -> magic_only.getItem() == Items.FIREWORK_ROCKET
    );

    public MagicItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return this.getAllSupportedProjectiles();
    }

    public abstract Predicate<ItemStack> getAllSupportedProjectiles();

    public static ItemStack getHeldProjectile(LivingEntity p_220005_0_, Predicate<ItemStack> p_220005_1_) {
        if (p_220005_1_.test(p_220005_0_.getItemInHand(Hand.OFF_HAND))) {
            return p_220005_0_.getItemInHand(Hand.OFF_HAND);
        } else {
            return p_220005_1_.test(p_220005_0_.getItemInHand(Hand.MAIN_HAND)) ? p_220005_0_.getItemInHand(Hand.MAIN_HAND) : ItemStack.EMPTY;
        }
    }

    public int getEnchantmentValue() {
        return 1;
    }

    public int getDefaultProjectileRange() {
        return 0;
    }
}
