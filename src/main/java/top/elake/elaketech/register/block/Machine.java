package top.elake.elaketech.register.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.register.block.blockentity.registers.RegistersThermalBlockEntity;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class Machine {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(BuiltInRegistries.BLOCK, ElakeTech.MODID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, ElakeTech.MODID);

    public static final Supplier<Block> THERMAL_POWER = BLOCKS.register("thermal_power",
            () -> new RegistersThermalBlockEntity(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()));

    public static final Supplier<Item> THERMAL_POWER_ITEM = ITEMS.register("thermal_power",
            () -> new BlockItem(THERMAL_POWER.get(), new Item.Properties()));

    public static void registers() {
        ModCreativeModeTab.addAll((DeferredItem<? extends Item>) THERMAL_POWER_ITEM);
    }
}