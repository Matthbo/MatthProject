package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.MatthProject;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class MatthProjectBlockContainer extends BlockContainer {

    protected MatthProjectBlockContainer(Material material, String unlocalizedName) {
        this(material, material.getMaterialMapColor(), unlocalizedName);
    }

    protected MatthProjectBlockContainer(Material material, MapColor color, String unlocalizedName) {
        super(material, color);
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
