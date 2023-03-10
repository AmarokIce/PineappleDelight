package club.someoneice.pineapple.data;

import club.someoneice.pineapple.init.ItemList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemsGroup {
    public static final CreativeModeTab TAB = new CreativeModeTab("pineapple") {
        @Nonnull @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemList.PINEAPPLE.get());
        }
    };
}
