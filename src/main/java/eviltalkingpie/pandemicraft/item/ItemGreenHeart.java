package eviltalkingpie.pandemicraft.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.ILexicon;
import vazkii.botania.api.recipe.IElvenItem;

public class ItemGreenHeart extends ItemBase implements IElvenItem
{
    public ItemGreenHeart(String name)
    {
        super(name, "", null);
        setMaxStackSize(16);
    }
    
    @Override
    public boolean isElvenItem(ItemStack item)
    {
        return true;
    }
    
    @Override
    public void addInformation(ItemStack sstack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        boolean hasElven = false;
        if (player != null)
        {
            for (ItemStack stack : player.inventory.mainInventory)
            {
                if ((stack != null) && ((stack.getItem() instanceof ILexicon)))
                {
                    ILexicon lexicon = (ILexicon) stack.getItem();
                    if (lexicon.isKnowledgeUnlocked(stack, BotaniaAPI.elvenKnowledge))
                    {
                        hasElven = true;
                    }
                }
            }
        }
        if (!hasElven)
        {
            list.add(StatCollector.translateToLocal("flavorText.elvenknowlegde"));
        }
    }
    
    // TODO when eaten fully heal player, and provide absorbtion effect
}
