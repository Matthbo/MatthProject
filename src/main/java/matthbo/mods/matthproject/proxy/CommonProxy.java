package matthbo.mods.matthproject.proxy;

public class CommonProxy implements IProxy {

    @Override
    public void addTextureName(String name) {}

    @Override
    public void textureFix() {}

    @Override
    public void registerRenders() {}

    public void preInit(){
        textureFix();
    }

    public void init(){
        registerRenders();
    }
}
