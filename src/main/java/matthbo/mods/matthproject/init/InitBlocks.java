package matthbo.mods.matthproject.init;

import matthbo.mods.matthproject.block.BlockMachineBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitBlocks {

    public static Block machineBlock = new BlockMachineBlock();

    public static void init(){
        register(machineBlock);
    }

    private static void register(Block newBlock){
        GameRegistry.registerBlock(newBlock, getName(newBlock));
    }

    private static void registerItemBlock(Block newBlock, Class<? extends ItemBlock> itemBlock){
        GameRegistry.registerBlock(newBlock, itemBlock, getName(newBlock));
    }

    private static String getName(Block newBlock){
        return newBlock.getUnlocalizedName().substring(newBlock.getUnlocalizedName().indexOf(".")+1);
    }
}
