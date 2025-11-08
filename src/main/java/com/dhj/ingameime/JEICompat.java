package com.dhj.ingameime;

import mezz.jei.api.*;
import javax.annotation.Nonnull;

@JEIPlugin
public class JEICompat implements IModPlugin {

    private static IJeiRuntime jeiRuntime;

    @Override
    public void onJeiHelpersAvailable(IJeiHelpers iJeiHelpers) {

    }

    @Override
    public void onItemRegistryAvailable(IItemRegistry iItemRegistry) {

    }

    @Override
    public void register(@Nonnull IModRegistry iModRegistry) {

    }

    @Override
    public void onRecipeRegistryAvailable(@Nonnull  IRecipeRegistry iRecipeRegistry) {

    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime runtime) {
        JEICompat.jeiRuntime = runtime;
    }

    public static String getJEIFilterText() {
        if (jeiRuntime != null) {
            return jeiRuntime.getItemListOverlay().getFilterText();
        }
        return "";
    }

    public static void setJEIFilterText(String text) {
        if (jeiRuntime != null) {
            jeiRuntime.getItemListOverlay().setFilterText(text);
        }
    }
}