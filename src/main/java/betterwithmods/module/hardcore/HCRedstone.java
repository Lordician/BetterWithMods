package betterwithmods.module.hardcore;

import betterwithmods.common.BWMBlocks;
import betterwithmods.common.BWMRecipes;
import betterwithmods.common.blocks.BlockUrn;
import betterwithmods.common.blocks.mini.BlockMini;
import betterwithmods.common.items.ItemMaterial;
import betterwithmods.module.Feature;
import betterwithmods.module.gameplay.CrucibleRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by tyler on 4/20/17.
 */
public class HCRedstone extends Feature {


    public static boolean stoneDeviceRecipesAnvil;

    @Override
    public void setupConfig() {
        stoneDeviceRecipesAnvil = loadPropBool("Stone Device Recipes Require Anvil", "Makes it so stone buttons and pressure plates require cut stone, which must be done in the anvil", true);
    }

    @Override
    public String getFeatureDescription() {
        return "Changes the recipes for Redstone devices to be more complex";
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ItemStack LATCH = ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.REDSTONE_LATCH);
//TODO
//        BWMRecipes.removeRecipes(Blocks.STONE_BUTTON);
//        BWMRecipes.removeRecipes(Blocks.STONE_PRESSURE_PLATE);
//        BWMRecipes.removeRecipes(Blocks.DISPENSER);
//        BWMRecipes.removeRecipes(Blocks.DROPPER);
//        BWMRecipes.removeRecipes(Items.IRON_DOOR, 0);
//        BWMRecipes.removeRecipes(Blocks.IRON_TRAPDOOR);
//        BWMRecipes.removeRecipes(Blocks.LEVER);
//        BWMRecipes.removeRecipes(Blocks.PISTON);
//        BWMRecipes.removeRecipes(Blocks.TRIPWIRE_HOOK);
//        BWMRecipes.removeRecipes(Blocks.WOODEN_BUTTON);
//        BWMRecipes.removeRecipes(Blocks.WOODEN_PRESSURE_PLATE);
//        BWMRecipes.removeRecipes(Items.REPEATER, 0);
//        BWMRecipes.removeRecipes(Blocks.OBSERVER);
//        BWMRecipes.removeRecipes(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
//        BWMRecipes.removeRecipes(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);
//        BWMRecipes.removeRecipes(Blocks.HOPPER);


        BWMRecipes.addOreRecipe(new ItemStack(Blocks.STONE_BUTTON), "C", "R", 'C', new ItemStack(BWMBlocks.STONE_CORNER, 1, BlockMini.EnumType.STONE.getMetadata()), 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.STONE_PRESSURE_PLATE), "S", "R", 'S', new ItemStack(BWMBlocks.STONE_SIDING, 1, BlockMini.EnumType.STONE.getMetadata()), 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.DISPENSER), "CCC", "CBC", "CRC", 'C', "cobblestone", 'B', Items.BOW, 'R', LATCH);
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.DROPPER), "CCC", "C C", "CRC", 'C', "cobblestone", 'R', LATCH);
        BWMRecipes.addOreRecipe(new ItemStack(Items.IRON_DOOR, 3), "RII", " II", "RII", 'I', "ingotIron", 'R', LATCH);
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.IRON_TRAPDOOR, 2), "RII", "RII", 'I', "ingotIron", 'R', LATCH);
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.LEVER), "S", "C", "R", 'S', "stickWood", 'C', "cobblestone", 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.PISTON), "WIW", "CSC", "CRC", 'W', new ItemStack(BWMBlocks.WOOD_SIDING, 1, 32767), 'I', "ingotIron", 'C', "cobblestone", 'S', new ItemStack(BWMBlocks.URN, 1, BlockUrn.EnumType.FULL.getMeta()), 'R', LATCH);
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.TRIPWIRE_HOOK), "I", "M", "R", 'I', "nuggetIron", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, 32767), 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.WOODEN_BUTTON), "C", "R", 'C', new ItemStack(BWMBlocks.WOOD_CORNER, 1, 32767), 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE), "S", "R", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, 32767), 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Items.REPEATER), "RCR", "SSS", 'R', Blocks.REDSTONE_TORCH, 'C', Items.CLOCK, 'S', "stone");
        BWMRecipes.addOreRecipe(new ItemStack(Items.REPEATER), "RCR", "SSS", 'R', Blocks.REDSTONE_TORCH, 'C', Items.CLOCK, 'S', new ItemStack(BWMBlocks.STONE_SIDING, 1, BlockMini.EnumType.STONE.getMetadata()));
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), "II", "RR", 'I', "ingotIron", 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), "GG", "RR", 'G', "ingotGold", 'R', "dustRedstone");
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.HOPPER), "ICI", "IRI", " I ", 'I', "ingotIron", 'C', "chestWood", 'R', LATCH);
        BWMRecipes.addOreRecipe(new ItemStack(Items.COMPARATOR), " R ", "RQR", "SSS", 'R', Blocks.REDSTONE_TORCH, 'Q', "gemQuartz", 'S', new ItemStack(BWMBlocks.STONE_SIDING, 1, BlockMini.EnumType.STONE.getMetadata()));
        BWMRecipes.addOreRecipe(new ItemStack(Blocks.OBSERVER), "CCC", "LLU", "CCC", 'C', "cobblestone", 'L', LATCH, 'U', BlockUrn.getStack(BlockUrn.EnumType.FULL, 1));
        if (!stoneDeviceRecipesAnvil) {
            BWMRecipes.addOreRecipe(new ItemStack(Blocks.STONE_BUTTON), "C", "R", 'C', new ItemStack(Blocks.STONE), 'R', LATCH);
            BWMRecipes.addOreRecipe(new ItemStack(Blocks.STONE_PRESSURE_PLATE), "S", "R", 'S', new ItemStack(Blocks.STONE), 'R', LATCH);
        }

        CrucibleRecipes.addStokedCrucibleRecipe(new ItemStack(Items.IRON_INGOT, 4, 0), new Object[]{new ItemStack(Blocks.IRON_TRAPDOOR, 2)});

    }

    @Override
    public void disabledInit(FMLInitializationEvent event) {
        CrucibleRecipes.addStokedCrucibleRecipe(new ItemStack(Items.IRON_INGOT, 6, 0), new Object[]{new ItemStack(Blocks.IRON_TRAPDOOR, 2)});
    }
}
