package com.dhj.ingameime;

import mezz.jei.api.*;
import org.jetbrains.annotations.NotNull;

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
    public void register(@NotNull IModRegistry iModRegistry) {

    }

    @Override
    public void onRecipeRegistryAvailable(@NotNull IRecipeRegistry iRecipeRegistry) {

    }

    @Override
    public void onRuntimeAvailable(@NotNull IJeiRuntime runtime) {
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