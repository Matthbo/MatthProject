package matthbo.mods.matthproject.proxy;

public interface IProxy {

    void addTextureName(String name);
    void textureFix();
    void registerRenders();

    void preInit();
    void init();
}
