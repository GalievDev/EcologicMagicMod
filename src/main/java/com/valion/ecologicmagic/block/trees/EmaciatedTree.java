package com.valion.ecologicmagic.block.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

import com.valion.ecologicmagic.world.gen.feature.TreeFeature;

import java.util.Random;

public class EmaciatedTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
        return TreeFeature.EMACIATED;
    }
}
