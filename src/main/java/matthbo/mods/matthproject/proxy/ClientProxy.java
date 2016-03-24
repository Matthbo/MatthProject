package matthbo.mods.matthproject.proxy;

import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.client.renderer.TileTESRBlockRenderer;
import matthbo.mods.matthproject.tileentity.TileTESRBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ClientProxy extends CommonProxy {

    private List<String> objectTextureNames = new ArrayList<String>();

    public void addTextureName(String name){
        if(!objectTextureNames.contains(name)){
            objectTextureNames.add(name);
        }
    }

    @Override
    public void textureFix() {
        for(String object : objectTextureNames) {
            Item item = GameRegistry.findItem(MatthProject.MODID, object);
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.delegate.getResourceName(), "inventory"));
        }
    }

    @Override
    public void registerRenders() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileTESRBlock.class, new TileTESRBlockRenderer());
    }
}
