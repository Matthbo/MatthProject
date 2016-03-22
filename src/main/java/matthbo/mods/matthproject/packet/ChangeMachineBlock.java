package matthbo.mods.matthproject.packet;

import io.netty.buffer.ByteBuf;
import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.block.BlockMachineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ChangeMachineBlock implements IMessage{

    private BlockPos pos;
    private boolean active;

    public ChangeMachineBlock(BlockPos pos, boolean active){
        this.pos = pos;
        this.active = active;
    }

    public ChangeMachineBlock(){

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        active = buf.readBoolean();

        pos = new BlockPos(x,y,z);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(pos.getX());
        buf.writeInt(pos.getY());
        buf.writeInt(pos.getZ());
        buf.writeBoolean(active);
    }

    //TODO http://www.minecraftforge.net/forum/index.php/topic,20135.0.html

    public static class Handler implements IMessageHandler<ChangeMachineBlock, IMessage>{

        @Override
        public IMessage onMessage(ChangeMachineBlock message, MessageContext ctx) {
            World world = ctx.getServerHandler().playerEntity.worldObj;
            BlockPos pos = message.pos;
            boolean active = message.active;
            BlockMachineBlock.setState(active, world, pos);
            return null;
        }
    }
}
