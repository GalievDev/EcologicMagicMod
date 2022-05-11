package com.eсologicmagic.gui;


import com.eсologicmagic.buttons.BaseButton;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@SuppressWarnings("all")
public class InfoScreen extends Screen {
    public InfoScreen() {
        super(new StringTextComponent("INFO_SCREEN"));
    }
    @Override
    protected void init() {
        this.addButton(new BaseButton(223, 195, 26, 13, new StringTextComponent(""), new Button.IPressable() {
            @Override
            public void onPress(Button p_onPress_1_) {
                onClose();
            }
        }, new ResourceLocation("ecologicmagic", "textures/button/back_button.png")));

        this.addButton(new BaseButton(143, 195, 16, 32, new StringTextComponent(""), new Button.IPressable() {
            @Override
            public void onPress(Button p_onPress_1_) {
                Minecraft.getInstance().setScreen(new InfoScreen());
            }
        },new ResourceLocation("ecologicmagic","textures/button/info_button.png")));
    }
    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float ticks) {
        Minecraft.getInstance().getTextureManager().bind(new ResourceLocation("ecologicmagic","textures/gui/clean_ecology_book.png"));
        blit(stack, 100, 20, 0, 0, 276, 186, 276, 186);
        Minecraft.getInstance().font.draw(stack, new TranslationTextComponent("ecologicmagic.info1"), 123, 40, -100);
        Minecraft.getInstance().font.draw(stack, new TranslationTextComponent("ecologicmagic.info2"), 123, 50, -100);
        Minecraft.getInstance().font.draw(stack, new TranslationTextComponent("ecologicmagic.info3"), 123, 60, -100);
    }



    @Override
    public boolean isPauseScreen(){
        return false;
    }
}

