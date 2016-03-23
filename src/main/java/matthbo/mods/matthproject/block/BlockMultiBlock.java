package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.tileentity.TileMultiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMultiBlock extends MatthProjectBlockContainer {

    public BlockMultiBlock(){
        super(Material.rock, "multiblock");
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile != null && tile instanceof TileMultiBlock) {
            TileMultiBlock multiBlock = (TileMultiBlock) tile;
            if (multiBlock.hasMaster()) {
                if (multiBlock.isMaster()) {
                    if (!multiBlock.checkMultiBlockForm())
                        multiBlock.resetStructure();
                } else {
                    if (!multiBlock.checkForMaster()) {
                        multiBlock.reset();
                    } else {
                        TileMultiBlock master = (TileMultiBlock) world.getTileEntity(multiBlock.getMasterPos());
                        if(!master.checkMultiBlockForm())
                            master.resetStructure();
                    }
                }

            }
        }
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMultiBlock();
    }
}
