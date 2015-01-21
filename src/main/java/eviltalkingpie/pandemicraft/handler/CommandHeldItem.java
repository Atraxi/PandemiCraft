package eviltalkingpie.pandemicraft.handler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class CommandHeldItem extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "held_item";
    }
    
    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "Displays details of the item being held";
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) sender;
            if (player.getHeldItem() != null)
            {
                ChatComponentText chatMessage = new ChatComponentText(player.getHeldItem().toString());
                if (player.getHeldItem().stackTagCompound != null)
                {
                    chatMessage.appendText("--" + player.getHeldItem().stackTagCompound.toString());
                }
                sender.addChatMessage(chatMessage);
            }
            else
            {
                sender.addChatMessage(new ChatComponentText("No currently held item"));
            }
        }
        else
        {
            sender.addChatMessage(new ChatComponentText("Can only be used by a player"));
        }
    }
}
