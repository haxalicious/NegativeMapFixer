package me.haxalicious.negativemapfixer.mixins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
/**
 * @author Haxalicious
 * @since 10/27/20
 */
@Mixin(ItemStack.class)
public class MixinItemStack {
    @Shadow
    private int itemDamage;

    @Inject(method = "<init>", at = @At("RETURN"), cancellable = true)
    public void ItemStackPOST (Item itemIn, int amount, int meta) {
        this.itemDamage = meta;
    }
    @Inject(method = "<init>", at = @At("RETURN"), cancellable = true)
    public void ItemStackPOST (NBTTagCompound compound) {
        this.itemDamage = compound.getShort("Damage");
    }

}
