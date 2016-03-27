package matthbo.mods.matthproject.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Jero - Matthbo
 * Created using Tabula 5.0.0
 */
public class KappaBlockModel extends ModelBase {
    public ModelRenderer SideN;
    public ModelRenderer SideW;
    public ModelRenderer SideS;
    public ModelRenderer SideE;
    public ModelRenderer SideT;
    public ModelRenderer SideB;

    public KappaBlockModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.SideW = new ModelRenderer(this, 1, -47);
        this.SideW.setRotationPoint(-24.0F, -24.0F, -24.0F);
        this.SideW.addBox(0.0F, 0.0F, 0.0F, 1, 48, 48, 0.0F);
        this.SideB = new ModelRenderer(this, 52, 50);
        this.SideB.setRotationPoint(-24.0F, 23.0F, -24.0F);
        this.SideB.addBox(0.0F, 0.0F, 0.0F, 48, 1, 48, 0.0F);
        this.SideS = new ModelRenderer(this, 98, 0);
        this.SideS.setRotationPoint(-24.0F, -24.0F, 23.0F);
        this.SideS.addBox(0.0F, 0.0F, 0.0F, 48, 48, 1, 0.0F);
        this.SideN = new ModelRenderer(this, 0, 0);
        this.SideN.setRotationPoint(-24.0F, -24.0F, -24.0F);
        this.SideN.addBox(0.0F, 0.0F, 0.0F, 48, 48, 1, 0.0F);
        this.SideE = new ModelRenderer(this, 99, -47);
        this.SideE.setRotationPoint(23.0F, -24.0F, -24.0F);
        this.SideE.addBox(0.0F, 0.0F, 0.0F, 1, 48, 48, 0.0F);
        this.SideT = new ModelRenderer(this, -47, 50);
        this.SideT.setRotationPoint(-24.0F, -24.0F, -24.0F);
        this.SideT.addBox(0.0F, 0.0F, 0.0F, 48, 1, 48, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.SideW.render(f5);
        this.SideB.render(f5);
        this.SideS.render(f5);
        this.SideN.render(f5);
        this.SideE.render(f5);
        this.SideT.render(f5);
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
