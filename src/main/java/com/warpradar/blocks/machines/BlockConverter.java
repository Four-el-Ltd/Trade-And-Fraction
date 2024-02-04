package com.warpradar.blocks.machines;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

import com.hbm.blocks.ILookOverlay;
import com.hbm.items.machine.IItemFluidIdentifier;
import com.hbm.util.I18nUtil;
import com.warpradar.registry.MainRegistry;
import com.warpradar.tileentities.machines.TileEntityConverter;

public class BlockConverter extends BlockContainer implements ILookOverlay {

    public BlockConverter(Material mat) {
        super(mat);
        setCreativeTab(MainRegistry.BlocksTab);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityConverter();
    }

    /**
     * Данный мето вызывается при правом клике мышкой игроком
     * Он выполняет следующие действия:
     * Проверка на наличие жидкостного идентификатора в руке(в случае отсутствия
     * метод завершается)
     * Снятие типа жидкости с идентификатора сущности конвертера
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float fX, float fY,
        float fZ) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (player.getHeldItem() != null && player.getHeldItem()
            .getItem() instanceof IItemFluidIdentifier && te instanceof TileEntityConverter) {
            IItemFluidIdentifier id = (IItemFluidIdentifier) player.getHeldItem()
                .getItem();
            TileEntityConverter tec = (TileEntityConverter) te;
            tec.bobtank.setTankType(id.getType(world, x, y, z, player.getHeldItem()));
            return true;
        }
        return true;
    }

    @Override
    public void printHook(Pre preEvent, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        TileEntityConverter tec = (TileEntityConverter) te;
        List<String> text = new ArrayList<>();
        text.add(
            tec.getAllTanks()[0].getTankType()
                .getLocalizedName());
        ILookOverlay
            .printGeneric(preEvent, I18nUtil.resolveKey(getUnlocalizedName() + ".text"), 0xffff00, 0x404000, text);

    }
}
