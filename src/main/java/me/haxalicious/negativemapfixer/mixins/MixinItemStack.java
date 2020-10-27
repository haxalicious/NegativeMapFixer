package me.haxalicious.negativemapfixer.mixins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Haxalicious
 * @since 10/27/20
 */
@Mixin(ItemStack.class)
public class MixinItemStack {
    @Shadow
    private int itemDamage;

    @Inject(method = "<init>(Lnet/minecraft/item/Item;II)V", at = @At("RETURN"), cancellable = true)
    public void ItemStackPOST (Item itemIn, int amount, int meta, CallbackInfo cb) {
        this.itemDamage = meta;
        cb.cancel();
    }
    @Inject(method = "<init>(Lnet/minecraft/nbt/NBTTagCompound;)V", at = @At("RETURN"), cancellable = true)
    public void ItemStackPOST (NBTTagCompound compound, CallbackInfo cb) {
        this.itemDamage = compound.getShort("Damage");
        cb.cancel();
    }

}
