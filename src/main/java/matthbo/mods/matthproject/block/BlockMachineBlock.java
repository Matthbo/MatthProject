package matthbo.mods.matthproject.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachineBlock extends MatthProjectBlockContainer {

    public BlockMachineBlock() {
        super(Material.piston, "machineblock");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null; //TODO
    }

    // TODO check BlockFurnace.java
}
