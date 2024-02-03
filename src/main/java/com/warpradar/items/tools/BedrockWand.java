package com.warpradar.items.tools;

import com.hbm.blocks.generic.BlockBedrockOreTE;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.items.machine.ItemFluidIdentifier;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BedrockWand extends Item {
  public ItemStack target;
  public FluidType targetFluid;

  @Override
  public boolean onItemUse(final ItemStack stack, final EntityPlayer player, final World world, final int x,
      final int y, final int z, final int dir, final float mx,
      final float my, final float mz) {
    if (stack.stackTagCompound == null) {
      stack.stackTagCompound = new NBTTagCompound();
    }
    final ItemStack itemStack = new ItemStack(Item.getItemById(stack.stackTagCompound.getInteger("id_target")));
    itemStack.setItemDamage(stack.stackTagCompound.getInteger("meta"));
    target = itemStack;
    targetFluid = Fluids.fromID(stack.stackTagCompound.getInteger("fluid_type"));
    if (target != null && world.getBlock(x, y, z) instanceof BlockBedrockOreTE && !player.isSneaking()) {
      final BlockBedrockOreTE.TileEntityBedrockOre teb = (BlockBedrockOreTE.TileEntityBedrockOre) world.getTileEntity(x,
          y,
          z);
      if (teb.resource.equals(target)) {
        if (teb.tier >= 4) {
          teb.tier = 0;
        } else {
          teb.tier++;
        }
      } else {
        teb.resource = target;
      }
      if (!teb.acidRequirement.type.equals(targetFluid)) {
        teb.acidRequirement.type = targetFluid;
      } else {
        teb.acidRequirement.type = Fluids.NONE;
      }

    }
    if (player.isSneaking()) {
      if (player.inventory.getStackInSlot(0) != null) {
        stack.stackTagCompound.setInteger("id_target",
            Item.getIdFromItem(player.inventory.getStackInSlot(0).getItem()));
        stack.stackTagCompound.setInteger("meta", player.inventory.getStackInSlot(0).getItemDamage());
        if (player.inventory.getStackInSlot(1).getItem() instanceof ItemFluidIdentifier) {
          stack.stackTagCompound.setInteger("fluid_type",
              ItemFluidIdentifier.getType(player.inventory.getStackInSlot(1)).getID());

        }
        if (world.isRemote) {
          player.addChatMessage(new ChatComponentText("Тип руды установлен на"
              + Item.getItemById(stack.stackTagCompound.getInteger("id_target")).getUnlocalizedName()));
        }
      }
    }
    return true;
  }

}
