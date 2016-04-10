package matthbo.mods.matthproject.init;

import matthbo.mods.matthproject.block.*;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class InitBlocks {

    public static final List<MatthProjectBlock> BLOCKS = new ArrayList<MatthProjectBlock>();

    public static MatthProjectBlock machineBlock = new BlockMachineBlock(false);
    public static MatthProjectBlock activeMachineBlock = new BlockMachineBlock(true);
    public static MatthProjectBlock TESRBlock = new BlockTESRBlock();
    public static MatthProjectBlock multiBlock = new BlockMultiBlock();
    public static MatthProjectBlock kappaBlock = new BlockKappaBlock();

    public static void init(){
        for (MatthProjectBlock block : BLOCKS){
            GameRegistry.register(block);
            GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        for (MatthProjectBlock block : BLOCKS){
            block.initModels();
        }
    }
}
