package com.warpradar.items.tools;

import com.hbm.blocks.generic.BlockBedrockOre;
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
      stack.stackTagCompound.setInteger("id_target", 1);
    }
    target = new ItemStack(Item.getItemById(stack.stackTagCompound.getInteger("id_target")));
    if (world.getBlock(x, y, z) instanceof BlockBedrockOre && !player.isSneaking()) {
      BlockBedrockOreTE.TileEntityBedrockOre teb = (BlockBedrockOreTE.TileEntityBedrockOre) world.getTileEntity(x, y,
          z);
      teb.resource = target;

    }
    if (player.isSneaking()) {
      if (player.inventory.getStackInSlot(36) != null) {
        stack.stackTagCompound.setInteger("id_target", Item.getIdFromItem(target.getItem()));
        if (world.isRemote) {
          player.addChatMessage(new ChatComponentText("Тип руды установлен на"
              + Item.getItemById(stack.stackTagCompound.getInteger("id_target")).getUnlocalizedName()));
        }
      }
    }
    return true;
  }

}
