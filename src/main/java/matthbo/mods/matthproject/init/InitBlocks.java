package matthbo.mods.matthproject.init;

import matthbo.mods.matthproject.MatthProject;
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
        //GameRegistry.registerBlock(newBlock, newBlock.getUnlocalizedName());
        GameRegistry.registerBlock(newBlock, getName(newBlock));
        MatthProject.proxy.addTextureName(getName(newBlock));
    }

    private static void registerItemBlock(Block newBlock, Class<? extends ItemBlock> itemBlock){
        //GameRegistry.registerBlock(newBlock, itemBlock, newBlock.getUnlocalizedName());
        GameRegistry.registerBlock(newBlock, itemBlock, getName(newBlock));
        MatthProject.proxy.addTextureName(getName(newBlock));
    }


    private static String getName(Block newBlock){
        return newBlock.getUnlocalizedName().substring(newBlock.getUnlocalizedName().indexOf(":")+1);
    }
}
