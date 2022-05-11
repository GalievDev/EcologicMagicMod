package com.eсologicmagic.item;


import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;
import static net.minecraft.item.BoneMealItem.applyBonemeal;
import static net.minecraft.item.BoneMealItem.growWaterPlant;

public class ProsperityStone extends Item {

    public ProsperityStone (){
        super (new Item.Properties().tab(ECOLOGICALL));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
        if (applyBonemeal(context.getItemInHand(), world, blockpos, context.getPlayer())) {
            if (!world.isClientSide) {
                world.levelEvent(2005, blockpos, 0);
            }

            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            BlockState blockstate = world.getBlockState(blockpos);
            boolean flag = blockstate.isFaceSturdy(world, blockpos, context.getClickedFace());
            if (flag && growWaterPlant(context.getItemInHand(), world, blockpos1, context.getClickedFace())) {
                if (!world.isClientSide) {
                    world.levelEvent(2005, blockpos1, 0);
                }

                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.PASS;
            }
        }
    }
}
