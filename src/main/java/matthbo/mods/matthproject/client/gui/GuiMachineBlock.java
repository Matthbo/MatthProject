package matthbo.mods.matthproject.client.gui;

import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.block.BlockMachineBlock;
import matthbo.mods.matthproject.init.InitBlocks;
import matthbo.mods.matthproject.packet.ChangeMachineBlock;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;

public class GuiMachineBlock extends GuiScreen {

    private ResourceLocation texture = new ResourceLocation(MatthProject.MODID + ":textures/gui/machine_block.png");
    private int x;
    private int y;
    private int guiHeight = 166;
    private int guiWidth = 248;
    private GuiButton activateBtn;
    private GuiButton deactivateBtn;
    private BlockPos pos;

    public GuiMachineBlock(BlockPos pos){
        this.pos = pos;
    }

    @Override
    public void initGui() {
        x = (width - guiWidth) / 2;
        y = (height - guiHeight) / 2;

        activateBtn = new GuiButton(0, (width - 100) /2, (height - 20)/2, 100, 20, "Activate");
        deactivateBtn = new GuiButton(1, (width - 100) /2, (height - 20)/2 + 10, 100, 20, "Deactivate");
        this.buttonList.add(activateBtn);
        this.buttonList.add(deactivateBtn);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        this.mc.getTextureManager().bindTexture(texture);
        GL11.glColor4f(1.0F,1.0F,1.0F,1.0F);
        this.drawTexturedModalRect(x, y, 0, 0, guiWidth, guiHeight);

        Block block = this.mc.theWorld.getBlockState(pos).getBlock();
        if(block == InitBlocks.machineBlock){
            activateBtn.enabled = true;
            activateBtn.visible = true;
            deactivateBtn.enabled = false;
            deactivateBtn.visible = false;
        }else{
            activateBtn.enabled = false;
            activateBtn.visible = false;
            deactivateBtn.enabled = true;
            deactivateBtn.visible = true;
            this.drawString(fontRendererObj, "This block is active", (width - 100) /2, (height - 20)/2 - 10, Color.CYAN.getRGB());
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void updateScreen()
    {

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id){
            case 0:
                MatthProject.network.sendToServer(new ChangeMachineBlock(pos, true));
                break;
            case 1:
                MatthProject.network.sendToServer(new ChangeMachineBlock(pos, false));
                break;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
