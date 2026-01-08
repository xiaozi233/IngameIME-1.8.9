package com.dhj.ingameime.control;

import com.dhj.ingameime.ClientProxy;
import com.dhj.ingameime.mixins.vanilla.AccessorGuiTextField;
import mezz.jei.api.*;
import mezz.jei.input.GuiTextFieldFilter;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.fml.common.Optional;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.awt.*;

public class JEITextFieldControl extends VanillaTextFieldControl<GuiTextFieldFilter> {

    public static final String JEI_MOD_ID = "JEI";

    protected JEITextFieldControl(GuiTextFieldFilter control) {
        super(control);
    }

    @Override
    public void writeText(String text) {
        // FIXME: It just works!
        this.controlObject.writeText(text);
        int cursorPos = this.controlObject.getCursorPosition();
        Plugin.setJEIFilterText(this.controlObject.getText());
        this.controlObject.setCursorPosition(cursorPos);
    }

    @Nonnull
    @Override
    public Point getCursorPos() {
        com.dhj.ingameime.mixins.vanilla.AccessorGuiTextField accessor = (AccessorGuiTextField) this.controlObject;
        return AbstractControl.getCursorPos(
                accessor.getFont(), this.controlObject.getText(),
                this.controlObject.xPosition, this.controlObject.yPosition, this.controlObject.width, this.controlObject.height,
                accessor.getLineScrollOffset(), this.controlObject.getCursorPosition(), this.controlObject.getSelectionEnd(),
                true
        );
    }

    /**
     * Try to set the GuiTextField object focus.
     *
     * @param object The field to be set
     * @return Success or not
     */
    @Optional.Method(modid = JEI_MOD_ID)
    public static boolean onFocusChange(GuiTextField object, boolean focused) {
        if (object instanceof GuiTextFieldFilter) {
            ClientProxy.INSTANCE.onControlFocus(new JEITextFieldControl((GuiTextFieldFilter) object), focused, true);
            return true;
        }
        return false;
    }

    @JEIPlugin
    public static class Plugin implements IModPlugin {
        private static IJeiRuntime jeiRuntime;

        // Necessary to stop JEI erroring
        public Plugin() {
        }

        public static void setJEIFilterText(String text) {
            if (jeiRuntime != null) {
                jeiRuntime.getItemListOverlay().setFilterText(text);
            }
        }

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
        public void onRuntimeAvailable(@Nonnull IJeiRuntime runtime) {
            jeiRuntime = runtime;
        }
    }
}
