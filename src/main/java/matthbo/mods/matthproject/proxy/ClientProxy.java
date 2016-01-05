package matthbo.mods.matthproject.proxy;

import matthbo.mods.matthproject.MatthProject;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
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
        final int DEFAULT_ITEM_SUBTYPE = 0;

        for(String object : objectTextureNames) {
            Item item = GameRegistry.findItem(MatthProject.MODID, object);
            ModelResourceLocation modelItem = new ModelResourceLocation(MatthProject.MODID + ":" + object, "inventory");
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE, modelItem);
        }
    }


}
