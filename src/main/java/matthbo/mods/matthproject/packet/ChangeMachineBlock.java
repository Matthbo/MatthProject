package matthbo.mods.matthproject.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ChangeMachineBlock implements IMessage{
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    //TODO http://www.minecraftforge.net/forum/index.php/topic,20135.0.html

    public static class Handler implements IMessageHandler<ChangeMachineBlock, IMessage>{

        @Override
        public IMessage onMessage(ChangeMachineBlock message, MessageContext ctx) {
            return null;
        }
    }
}
