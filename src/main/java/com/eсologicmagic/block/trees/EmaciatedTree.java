package com.eсologicmagic.block.trees;

import com.eсologicmagic.world.gen.feature.TreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class EmaciatedTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
        return TreeFeature.EMACIATED;
    }
}
