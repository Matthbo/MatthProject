package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.init.InitBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

import java.util.Random;

public class BlockMachineBlock extends MatthProjectBlock {

    private final boolean isActive;

    public BlockMachineBlock(boolean isActive) {
        super(Material.rock, "machineblock");
        this.isActive = isActive;

        if(isActive){
            this.setUnlocalizedName("activemachineblock");
            //this.setTickRandomly(true);
        }
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(InitBlocks.machineBlock);
    }

    /*
    @Override
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
        //TODO particles
    }*/

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(world.isRemote) {
            player.openGui(MatthProject.instance, 10, world, pos.getX(), pos.getY(), pos.getZ());
            //FMLNetworkHandler.openGui(player, MatthProject.instance, 10, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public Item getItem(World world, BlockPos pos) {
        return Item.getItemFromBlock(InitBlocks.machineBlock);
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(InitBlocks.machineBlock);
    }
}
