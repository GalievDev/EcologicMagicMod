package com.valion.eсologicmagic.setup;


import com.valion.eсologicmagic.Ecologicmagic;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Ecologicmagic.ModId, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static final ItemGroup ECOLOGICALL = new ItemGroup("ecologic_all") {
        public ItemStack makeIcon() {
            return new ItemStack(Registration.ECOLOGY_BOOK.get());
        }
    };
    public static void init(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
    }
}