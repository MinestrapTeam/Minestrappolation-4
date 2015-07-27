package minestrapteam.mods.minestrappolation.nei.handler;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import minestrapteam.mods.minestrappolation.crafting.recipes.AlloyRecipes;
import minestrapteam.mods.minestrappolation.inventory.gui.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AlloyRecipeHandler extends TemplateRecipeHandler
{
    @Override 
    public String getGuiTexture()
    {
        return GuiAlloy.texture.toString();
    }

    @Override 
    public String getRecipeName()
    {
        return "recipe.alloy";
    }

    @Override 
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GuiAlloy.class;
    }

    @Override
    public void loadCraftingRecipes(ItemStack output)
    {
        ArrayList<AlloyRecipes.AlloyRecipe> recipesFor = AlloyRecipes.getInstance().getRecipesFor(output);

        for (AlloyRecipes.AlloyRecipe recipe: recipesFor)
        {
            NEIRecipe neiRecipe = new NEIRecipe(recipe.getIngredients(), recipe.getCraftingResult(), output);
            arecipes.add(neiRecipe);
        }
    }

    @Override 
    public void loadUsageRecipes(ItemStack ingredient)
    {
        ArrayList<AlloyRecipes.AlloyRecipe> recipesFor = AlloyRecipes.getInstance().getRecipesUsing(ingredient);

        for (AlloyRecipes.AlloyRecipe recipe: recipesFor)
        {
            NEIRecipe neiRecipe = new NEIRecipe(recipe.getIngredients(), recipe.getCraftingResult(), ingredient);
            arecipes.add(neiRecipe);
        }
    }

    private class NEIRecipe extends CachedRecipe
    {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public NEIRecipe(ItemStack[] inputs, ItemStack craftingResult, ItemStack ingredient)
        {
            result = new PositionedStack(craftingResult, 111, 23);
            ingredients = new ArrayList<PositionedStack>();
            setIngredients(inputs, craftingResult);
        }

        @Override 
        public List<PositionedStack> getIngredients()
        {
            return getCycledIngredients(AlloyRecipeHandler.this.cycleticks / 20, ingredients);
        }

        private void setIngredients(ItemStack[] inputs, ItemStack output)
        {
            PositionedStack stack = new PositionedStack(inputs[0], 32, 6);
            stack.setMaxSize(1);
            ingredients.add(stack);

            if(inputs.length > 1 && inputs[1] != null)
            {
                stack = new PositionedStack(inputs[1], 50, 6);
                stack.setMaxSize(1);
                ingredients.add(stack);
            }
        }


        @Override 
        public PositionedStack getResult()
        {
            return result;
        }
    }
}