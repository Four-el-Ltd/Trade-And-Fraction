package com.warpradar.items.food;

import com.hbm.config.VersatileConfig;
import com.hbm.potion.HbmPotion;
import com.warpradar.registry.MainRegistry;
import com.warpradar.registry.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEnergy extends com.hbm.items.food.ItemEnergy {
  private Item container = null;
  private Item cap = null;
  private boolean requiresOpener = false;

  public ItemEnergy() {
    super();
    this.setCreativeTab(MainRegistry.ItemsTab); // TODO: Изменить на вкладку с расходниками
  }

  @Override
  public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
    if (!player.capabilities.isCreativeMode) {
      --stack.stackSize;
    }
    if (!world.isRemote) {
      VersatileConfig.applyPotionSickness(player, 5);

      if (this == ModItems.bottle_leninade) {
        player.heal(15F);
        player.addPotionEffect(new PotionEffect(HbmPotion.taint.id, 600, 10)); // Коммунистическая зараза; хы
      }
      if (!player.capabilities.isCreativeMode) {
        if (this.cap != null) {
          player.inventory.addItemStackToInventory(new ItemStack(this.cap));
        }
      }

    }

    return stack;
  }
}
