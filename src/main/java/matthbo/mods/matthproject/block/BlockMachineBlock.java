package matthbo.mods.matthproject.block;

import matthbo.mods.matthproject.init.InitBlocks;
import matthbo.mods.matthproject.tileentity.TileEntityMachineBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMachineBlock extends MatthProjectBlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    private final boolean isActive;
    private static boolean keepInventory;

    public BlockMachineBlock(boolean isActive) {
        super(Material.rock, "machineblock");
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.isActive = isActive;

        if(isActive){
            this.setUnlocalizedName("activemachineblock");
        }
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(InitBlocks.machineBlock);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        this.setDefaultFacing(world, pos, state);
    }

    private void setDefaultFacing(World world, BlockPos pos, IBlockState state){
        if(!world.isRemote){
            Block block = world.getBlockState(pos.north()).getBlock();
            Block block1 = world.getBlockState(pos.south()).getBlock();
            Block block2 = world.getBlockState(pos.west()).getBlock();
            Block block3 = world.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if(enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock()) enumfacing = EnumFacing.SOUTH;
            else if(enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock()) enumfacing = EnumFacing.NORTH;
            else if(enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock()) enumfacing = EnumFacing.EAST;
            else if(enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock()) enumfacing = EnumFacing.WEST;

            world.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    /*
    @Override
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
        //TODO particles
    }*/

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(world.isRemote) return true;
        else{
            TileEntity tile = world.getTileEntity(pos);

            /* TODO
            if(tile instanceof TileEntityMachineBlock){
                player.openGui(MatthProject.instance, GuiID.MACHINEBLOCK.original(), world, (int)player.posX, (int)player.posY, (int)player.posZ);
            }*/

            return true;
        }
    }

    public static void setState(boolean active, World world, BlockPos pos){
        IBlockState state = world.getBlockState(pos);
        TileEntity tile = world.getTileEntity(pos);
        keepInventory = true;

        if(active){
            world.setBlockState(pos, InitBlocks.activeMachineBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
            world.setBlockState(pos, InitBlocks.activeMachineBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3); //why twice?
        }else{
            world.setBlockState(pos, InitBlocks.machineBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
            world.setBlockState(pos, InitBlocks.machineBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);// again?
        }

        keepInventory = false;

        if(tile != null){
            tile.validate();
            world.setTileEntity(pos, tile);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMachineBlock(); //TODO
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if(stack.hasDisplayName()){
            TileEntity tile = world.getTileEntity(pos);

            //TODO if(tile instanceof TileEntityMachineBlock) ((TileENtityMachineBlock)tile).setCustomInventoryName(stack.getDisplayName());
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if(!keepInventory){
            TileEntity tile = world.getTileEntity(pos);

            /* TODO
            if(tile instanceof TileEntityMachineBlock){
                InventoryHelper.dropInventoryItems(world, pos, (TileEntityMachineBlock)tile);
                world.updateComparatorOutputLevel(pos, this);
            }*/
        }

        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, BlockPos pos) {
        return Container.calcRedstone(world.getTileEntity(pos));
    }

    @Override
    public Item getItem(World worldIn, BlockPos pos) {
        return Item.getItemFromBlock(InitBlocks.machineBlock);
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    public IBlockState getStateForEntityRender(IBlockState state) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if(enumfacing.getAxis() == EnumFacing.Axis.Y) enumfacing = EnumFacing.NORTH;

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING);
    }
}
