package com.valion.eсologicmagic.block;

import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OreBlocks extends OreBlock {
    public OreBlocks() {
        super(Properties.of(Material.STONE).strength(3f, 3f)
            .harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());
    }
}
