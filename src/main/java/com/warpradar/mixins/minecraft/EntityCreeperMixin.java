package com.warpradar.mixins.minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.World;

@Mixin(EntityCreeper.class)
public abstract class EntityCreeperMixin extends EntityCreeper {
    EntityCreeperMixin(World world) {
        super(world);
    }

    @Shadow
    protected abstract void func_146077_cc();

    @Inject(at = @At("RETURN"), method = "onDeath")
    protected void onKill(CallbackInfo ci) {
        this.func_146077_cc();
    }
}
