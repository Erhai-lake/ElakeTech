package top.elake.elaketech.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class UtilsMethod {
    /**
     * 这些方法用于从注册表里直接把id拉出来, 用法调用后直接写id
     * 用法如下例子
     * UtilsMethod.GetRegisterId.item("minecraft:stone")
     */
    public static final class GetRegisterId {
        public static Item item(String id) {
            return BuiltInRegistries.ITEM.get(ResourceLocation.parse(id));
        }

        public static Block block(String id) {
            return BuiltInRegistries.BLOCK.get(ResourceLocation.parse(id));
        }

        public static Fluid fluid(String id) {
            return BuiltInRegistries.FLUID.get(ResourceLocation.parse(id));
        }

        public static EntityType entity(String id) {
            return BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(id));
        }
    }
}