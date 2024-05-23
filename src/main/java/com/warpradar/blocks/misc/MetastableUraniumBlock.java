package com.warpradar.blocks.misc;

import java.util.Random;

import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.entity.logic.EntityNukeExplosionMK5;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class MetastableUraniumBlock extends Block{
    public MetastableUraniumBlock(){
        super(Material.iron);
    }

    @Override
    public void updateTick(World worldIn, int x, int y, int z, Random random) {
        if(random.nextInt(800) == 799){
            worldIn.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldIn, 50, x, y, z));
            EntityNukeTorex.statFac(worldIn, x, y, z, 5000);
        }
    }

}
