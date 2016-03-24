package matthbo.mods.matthproject.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * MultiBlock - Matthbo
 * Created using Tabula 5.1.0
 */
public class TESRBlockModel extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer Thingy;

    public TESRBlockModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Thingy = new ModelRenderer(this, 0, 0);
        this.Thingy.setRotationPoint(0.0F, -4.200000000000035F, 0.0F);
        this.Thingy.addBox(1.0F, 0.0F, -2.0F, 2, 6, 2, 0.5F);
        this.setRotateAngle(Thingy, 0.4363323129985824F, 0.0F, 0.4363323129985824F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Base.addBox(-4.0F, 12.0F, -4.0F, 8, 8, 8, 4.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Thingy.render(f5);
        this.Base.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
