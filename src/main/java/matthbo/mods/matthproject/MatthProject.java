package matthbo.mods.matthproject;

import matthbo.mods.matthproject.handler.GuiHandler;
import matthbo.mods.matthproject.init.InitBlocks;
import matthbo.mods.matthproject.packet.ChangeMachineBlock;
import matthbo.mods.matthproject.proxy.IProxy;
import matthbo.mods.matthproject.tileentity.TileMultiBlock;
import matthbo.mods.matthproject.tileentity.TileTESRBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = MatthProject.MODID, name = MatthProject.MODNAME, version = MatthProject.VERSION)
public class MatthProject {

    @Mod.Instance(MatthProject.MODID)
    public static MatthProject instance;

    public static final String MODID = "matthproject";
    public static final String MODNAME = "Matth's Project";
    public static final String VERSION = "1.8.9-0.1";

    @SidedProxy(clientSide = "matthbo.mods.matthproject.proxy.ClientProxy", serverSide = "matthbo.mods.matthproject.proxy.CommonProxy")
    public static IProxy proxy;
    public static SimpleNetworkWrapper network;
    public static Logger logger = LogManager.getLogger(MatthProject.MODID);

    public static final CreativeTabs tabMatthProject = new CreativeTabs(MatthProject.MODID) {
        @Override
        public Item getTabIconItem() {
            return Items.banner;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        InitBlocks.init();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        network.registerMessage(ChangeMachineBlock.Handler.class, ChangeMachineBlock.class, 0, Side.SERVER);

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();

        NetworkRegistry.INSTANCE.registerGuiHandler(MatthProject.instance, new GuiHandler());

        GameRegistry.registerTileEntity(TileMultiBlock.class, "tilemultiblock");
        GameRegistry.registerTileEntity(TileTESRBlock.class, "tiletesrblock");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }

    public enum GuiID{
        MACHINEBLOCK
    }
}
