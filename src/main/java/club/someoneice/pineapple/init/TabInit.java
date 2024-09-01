package club.someoneice.pineapple.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static club.someoneice.pineapple.PineappleMain.MODID;

public class TabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PINEAPPLE_TAB = TABS.register(MODID, () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + MODID))
            // Set icon of creative tab
            .icon(() -> new ItemStack(ItemList.PINEAPPLE.get()))
            // Add default items to tab
            .displayItems((params, output) -> {
                ItemList.ITEMS.getEntries().forEach(it -> output.accept(it.get()));
                BlockList.BLOCK_ITEMS.getEntries().forEach(it -> output.accept(it.get()));
            })
            .build()
    );
}
