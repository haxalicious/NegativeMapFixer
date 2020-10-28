package me.haxalicious.negativemapfixer.mixins;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * @author Haxalicious
 * @since 10/27/20
 */
@Mixin(ItemStack.class)
public class MixinItemStack {
    @Redirect(method = "<init>(Lnet/minecraft/item/Item;IILnet/minecraft/nbt/NBTTagCompound;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemStack;itemDamage:I", opcode = Opcodes.GETFIELD))
    public int ItemStackItemDamage(ItemStack itemStack) {
        return 0;
    }
    @ModifyArg(method = "<init>(Lnet/minecraft/nbt/NBTTagCompound;)V", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(II)I"), index = 0)
    public int ItemStackMax(int i, int i1) {
        return i1;
    }
}
