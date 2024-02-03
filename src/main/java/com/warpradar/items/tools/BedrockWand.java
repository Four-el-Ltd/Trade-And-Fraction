package com.warpradar.items.tools;

import com.hbm.blocks.generic.BlockBedrockOreTE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BedrockWand extends Item {
  public ItemStack target;

  @Override
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int dir, float mx,
      float my, float mz) {
    if (stack.stackTagCompound == null) {
      stack.stackTagCompound = new NBTTagCompound();
    }
    ItemStack itemStack = new ItemStack(Item.getItemById(stack.stackTagCompound.getInteger("id_target")));
    itemStack.setItemDamage(stack.stackTagCompound.getInteger("meta"));
    target = itemStack;
    if (target != null && world.getBlock(x, y, z) instanceof BlockBedrockOreTE && !player.isSneaking()) {
      BlockBedrockOreTE.TileEntityBedrockOre teb = (BlockBedrockOreTE.TileEntityBedrockOre) world.getTileEntity(x, y,
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

    }
    if (player.isSneaking()) {
      if (player.inventory.getStackInSlot(0) != null) {
        stack.stackTagCompound.setInteger("id_target",
            Item.getIdFromItem(player.inventory.getStackInSlot(0).getItem()));
        stack.stackTagCompound.setInteger("meta", player.inventory.getStackInSlot(0).getItemDamage());
        if (world.isRemote) {
          player.addChatMessage(new ChatComponentText("Тип руды установлен на"
              + Item.getItemById(stack.stackTagCompound.getInteger("id_target")).getUnlocalizedName()));
        }
      }
    }
    return true;
  }

}
