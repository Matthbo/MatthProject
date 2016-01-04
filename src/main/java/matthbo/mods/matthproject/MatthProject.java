package matthbo.mods.matthproject;

import matthbo.mods.matthproject.init.InitBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MatthProject.MODID, name = MatthProject.MODNAME, version = MatthProject.VERSION)
public class MatthProject {

    public static final String MODID = "matthproject";
    public static final String MODNAME = "Matth's Project";
    public static final String VERSION = "1.8.9-0.1";

    public static final CreativeTabs tabMatthProject = new CreativeTabs(MatthProject.MODID) {
        @Override
        public Item getTabIconItem() {
            return Items.banner;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        InitBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        System.out.println("Machine Block >>"+InitBlocks.machineBlock.getUnlocalizedName());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
