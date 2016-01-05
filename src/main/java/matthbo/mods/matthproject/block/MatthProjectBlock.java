package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.MatthProject;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MatthProjectBlock extends Block {

    public MatthProjectBlock(Material material, String unlocalizedName) {
        super(material, material.getMaterialMapColor());
        this.setCreativeTab(MatthProject.tabMatthProject);
        this.setUnlocalizedName(unlocalizedName);
    }

    public String getUnlocalizedName(){
        return String.format("tile.%s%s", MatthProject.MODID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
