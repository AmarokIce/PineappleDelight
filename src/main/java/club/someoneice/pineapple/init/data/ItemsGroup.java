package club.someoneice.pineapple.init.data;

import club.someoneice.pineapple.init.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemsGroup {
    public static final ItemGroup TAB = new ItemGroup("pineapple") {
        @Nonnull @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemList.PINEAPPLE.get());
        }
    };
}
