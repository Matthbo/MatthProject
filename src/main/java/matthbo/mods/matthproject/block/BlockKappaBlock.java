package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.tileentity.TileKappaBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockKappaBlock extends MatthProjectBlockContainer {

    public BlockKappaBlock(){
        super(Material.cake, "kappablock");
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileKappaBlock();
    }
}
