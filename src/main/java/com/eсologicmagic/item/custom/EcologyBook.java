package com.eсologicmagic.item.custom;


import com.eсologicmagic.gui.BookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;

public class EcologyBook extends Item {


    public EcologyBook() {
        super(new Item.Properties().stacksTo(1).tab(ECOLOGICALL));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(world.isClientSide) {
            Minecraft.getInstance().setScreen(new BookScreen());
            return ActionResult.success(player.getItemInHand(hand));
        }

        return super.use(world, player, hand);
    }
}
