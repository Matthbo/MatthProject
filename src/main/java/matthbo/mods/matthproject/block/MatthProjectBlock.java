package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.init.InitBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MatthProjectBlock extends Block {

    public MatthProjectBlock(Material material, String unlocalizedName) {
        super(material, material.getMaterialMapColor());
        this.setCreativeTab(MatthProject.tabMatthProject);
        this.setRegistryName(unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);

        InitBlocks.BLOCKS.add(this);
    }

    public String getUnlocalizedName(){
        return String.format("tile.%s%s", MatthProject.MODID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @SideOnly(Side.CLIENT)
    public void initModels(){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
    }
}
