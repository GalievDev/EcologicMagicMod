package com.valion.ecologicmagic.mixin;

import com.valion.ecologicmagic.setup.Registration;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.block.BushBlock;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BushBlock.class, remap = false)
public class BushBlockMixin {
    @Inject(method = "mayPlaceOn", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void onPlace(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(p_200014_1_.is(Registration.EMACIATED_DIRT.get()));
    }
}
