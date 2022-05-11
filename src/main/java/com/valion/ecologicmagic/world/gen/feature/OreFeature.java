package com.valion.ecologicmagic.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;

public class OreFeature implements IFeatureConfig {
    public static final Codec<OreFeature> CODEC = RecordCodecBuilder.create((p_236568_0_)
            -> p_236568_0_.group(RuleTest.CODEC.fieldOf("target").forGetter((p_236570_0_)
            -> p_236570_0_.target), BlockState.CODEC.fieldOf("state").forGetter((p_236569_0_)
            -> p_236569_0_.state), Codec.intRange(0, 64).fieldOf("size").forGetter((p_236567_0_)
            -> p_236567_0_.size)).apply(p_236568_0_, OreFeature::new)
    );
    public final RuleTest target;
    public final int size;
    public final BlockState state;

    public OreFeature(RuleTest test, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = test;
    }

    public static final class BlockFiller {
        public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
    }
}