package matthbo.mods.matthproject.client.gui;

import matthbo.mods.matthproject.MatthProject;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class GuiMachineBlock extends GuiScreen {

    private ResourceLocation texture = new ResourceLocation(MatthProject.MODID + ":textures/gui/machine_block.png");
    private int x;
    private int y;
    private int guiHeight = 166;
    private int guiWidth = 248;
    private GuiButton activateBtn;

    @Override
    public void initGui() {
        x = (width - guiWidth) / 2;
        y = (height - guiHeight) / 2;

        activateBtn = new GuiButton(0, (width - 100) /2, (height - 20)/2, 100, 20, "Activate");
        this.buttonList.add(activateBtn);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        this.mc.getTextureManager().bindTexture(texture);
        GL11.glColor4f(1.0F,1.0F,1.0F,1.0F);
        this.drawTexturedModalRect(x, y, 0, 0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {

    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
