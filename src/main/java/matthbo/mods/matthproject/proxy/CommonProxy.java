package matthbo.mods.matthproject.proxy;

import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.handler.GuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy implements IProxy {

    @Override
    public void addTextureName(String name) {}

    @Override
    public void textureFix() {}

    public void init(){
        textureFix();
    }
}
