package matthbo.mods.matthproject.proxy;

import matthbo.mods.matthproject.client.renderer.TileKappaBlockRenderer;
import matthbo.mods.matthproject.client.renderer.TileTESRBlockRenderer;
import matthbo.mods.matthproject.init.InitBlocks;
import matthbo.mods.matthproject.tileentity.TileKappaBlock;
import matthbo.mods.matthproject.tileentity.TileTESRBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    public void preInit(){
        super.preInit();
        InitBlocks.initModels();
    }

    public void init(){
        super.init();
        registerRenders();
    }

    private void registerRenders() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileTESRBlock.class, new TileTESRBlockRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileKappaBlock.class, new TileKappaBlockRenderer());
    }

}
