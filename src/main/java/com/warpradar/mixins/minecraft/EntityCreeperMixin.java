package com.warpradar.mixins.minecraft;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityCreeper.class)
public abstract class EntityCreeperMixin extends EntityMob {

    EntityCreeperMixin(World world) {
        super(world);
    }

    @Inject(at = @At("HEAD"), method = "onDeath")
    protected void death(DamageSource damageSource, CallbackInfo ci) {
        this.worldObj.createExplosion(((EntityCreeper) (EntityMob) this), this.posX, this.posY, this.posZ, 16, true);
    }
}
