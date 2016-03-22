package matthbo.mods.matthproject.handler;

import matthbo.mods.matthproject.MatthProject.GuiID;
import matthbo.mods.matthproject.client.gui.GuiMachineBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GuiID.MACHINEBLOCK.ordinal()) return new GuiMachineBlock(new BlockPos(x,y,z));
        return null;
    }
}