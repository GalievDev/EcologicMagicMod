package com.eсologicmagic.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModBlocks extends Block {
    public ModBlocks () {
        super (Properties.of(Material.STONE).harvestTool(ToolType.PICKAXE).strength(3F));
    }
}
