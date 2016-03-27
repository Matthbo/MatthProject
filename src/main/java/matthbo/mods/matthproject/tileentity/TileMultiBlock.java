package matthbo.mods.matthproject.tileentity;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileMultiBlock extends TileEntity implements ITickable {
    private boolean hasMaster;
    private boolean isMaster;
    private int masterX;
    private int masterY;
    private int masterZ;

    @Override
    public void update() {
        if (!worldObj.isRemote && this.worldObj.getTotalWorldTime() % 80L == 0L) {
            if (hasMaster()) {
                if (isMaster()) {
                    // Put stuff you want the multiblock to do here!
                    worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, pos.getX(), pos.getY() + 1, pos.getZ(), true));
                }
            } else {
                if (checkMultiBlockForm()){
                    setupStructure();}
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        hasMaster = compound.getBoolean("hasMaster");
        isMaster = compound.getBoolean("isMaster");
        masterX = compound.getInteger("masterX");
        masterY = compound.getInteger("masterY");
        masterZ = compound.getInteger("masterZ");

        if(hasMaster && isMaster){
            //stuff for master
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setBoolean("hasMaster", hasMaster);
        compound.setBoolean("isMaster", isMaster);
        compound.setInteger("masterX", masterX);
        compound.setInteger("masterY", masterY);
        compound.setInteger("masterZ", masterZ);

        if(hasMaster && isMaster){
            //stuff for master
        }
    }

    public boolean checkMultiBlockForm(){
        int i = 0;
        for (int x = pos.getX() - 1; x < pos.getX() + 2; x++){
            for (int y = pos.getY(); y < pos.getY() + 3; y++){
                for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++){
                    TileEntity tile = worldObj.getTileEntity(new BlockPos(x,y,z));
                    if(tile != null && tile instanceof TileMultiBlock){
                        TileMultiBlock multiBlock = (TileMultiBlock) tile;
                        if(this.isMaster()){
                            if(multiBlock.hasMaster)
                                i++;
                        }else if(!multiBlock.hasMaster)
                            i++;
                    }
                }
            }
        }
        return (i > 25 && worldObj.isAirBlock(new BlockPos(pos.getX(), pos.getY() +1, pos.getZ())));
    }

    public void setupStructure() {
        for (int x = pos.getX() - 1; x < pos.getX() + 2; x++){
            for (int y = pos.getY(); y < pos.getY() + 3; y++){
                for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(new BlockPos(x, y, z));
                    boolean master = (x == pos.getX() && y == pos.getY() && z == pos.getZ());

                    if (tile != null && (tile instanceof TileMultiBlock)) {
                        TileMultiBlock multiBlock = (TileMultiBlock) tile;
                        multiBlock.setMasterCoords(pos.getX(), pos.getY(), pos.getZ());
                        multiBlock.setHasMaster(true);
                        multiBlock.setIsMaster(master);
                    }
                }
            }
        }
    }

    public void resetStructure() {
        for (int x = pos.getX() - 1; x < pos.getX() + 2; x++)
            for (int y = pos.getY(); y < pos.getY() + 3; y++)
                for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(new BlockPos(x, y, z));
                    if (tile != null && (tile instanceof TileMultiBlock))
                        ((TileMultiBlock) tile).reset();
                }
    }

    public void reset(){
        hasMaster = false;
        isMaster = false;
        masterX = 0;
        masterY = 0;
        masterZ = 0;
    }

    public boolean checkForMaster(){
        TileEntity tile = worldObj.getTileEntity(new BlockPos(masterX, masterY, masterZ));
        return tile != null && tile instanceof TileMultiBlock;
    }

    public boolean hasMaster() {
        return hasMaster;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public BlockPos getMasterPos(){
        return new BlockPos(masterX,masterY,masterZ);
    }

    public void setHasMaster(boolean bool) {
        hasMaster = bool;
    }

    public void setIsMaster(boolean bool) {
        isMaster = bool;
    }

    public void setMasterCoords(int x, int y, int z) {
        masterX = x;
        masterY = y;
        masterZ = z;
    }
}
