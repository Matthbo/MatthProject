package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.MatthProject;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MatthProjectBlock extends Block {

    public MatthProjectBlock(Material material, String unlocalizedName) {
        super(material, material.getMaterialMapColor());
        this.setCreativeTab(MatthProject.tabMatthProject);
        this.setUnlocalizedName(MatthProject.MODID+":"+unlocalizedName);
    }
}
