package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.MatthProject;
import matthbo.mods.matthproject.init.InitBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMachineBlock extends MatthProjectBlock {

    private final boolean isActive;

    public BlockMachineBlock(boolean isActive) {
        super(Material.rock, "machineblock");
        this.isActive = isActive;

        if(isActive){
            this.setLightLevel(0.75F);
            this.setCreativeTab(null);
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack itemStack, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(world.isRemote) {
            player.openGui(MatthProject.instance, MatthProject.GuiID.MACHINEBLOCK.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    public static void setState(boolean active, World world, BlockPos pos)
    {
        if (active) {
            world.setBlockState(pos, InitBlocks.activeMachineBlock.getDefaultState(), 3);
        } else {
            world.setBlockState(pos, InitBlocks.machineBlock.getDefaultState(), 3);
        }
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(InitBlocks.machineBlock));
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(InitBlocks.machineBlock);
    }
}
