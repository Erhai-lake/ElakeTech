    package top.elake.elaketech.util;

    import com.tterrag.registrate.util.entry.ItemEntry;
    import net.minecraft.world.item.Item;
    import net.minecraft.world.item.Tier;
    import top.elake.elaketech.util.tools.*;

    import static top.elake.elaketech.ElakeTech.REGISTER;


    /**
     * @author Erhai-lake
     */
    public class ToolBuilder {
        private String id;
        private ToolType type;
        private Tier tier;
        private int attackDamage;
        private float attackSpeed;
        private int craftingDamage = 0;
        private String texture;
        private int color = -1;
        private boolean isColored = false;

        public ToolBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ToolBuilder type(ToolType type) {
            this.type = type;
            return this;
        }

        public ToolBuilder tier(Tier tier) {
            this.tier = tier;
            return this;
        }

        public ToolBuilder attack(int damage, float speed) {
            this.attackDamage = damage;
            this.attackSpeed = speed;
            return this;
        }

        public ToolBuilder craftingDamage(int damage) {
            this.craftingDamage = damage;
            return this;
        }

        public ToolBuilder texture(String path) {
            this.texture = path;
            return this;
        }

        public ToolBuilder colored(int color) {
            this.color = color;
            this.isColored = true;
            return this;
        }

        public ItemEntry<? extends Item> build() {
            Item.Properties properties = new Item.Properties()
                    .attributes(type.createAttributes(tier, attackDamage, attackSpeed));

            if (isColored) {
                return registerColorTool(properties);
            }
            return registerStandardTool(properties);
        }

        private ItemEntry<? extends Item> registerStandardTool(Item.Properties properties) {
            String path = texture != null ? texture : String.format("item/tools/%s/%s", id.split("_")[0], type.getPath());

            return REGISTER.item(id, p -> type.getItemFactory().apply(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(path)))
                    .register();
        }

        private ItemEntry<? extends Item> registerColorTool(Item.Properties properties) {
            return REGISTER.item(id, p -> type.getItemFactory().apply(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tools/color/" + type.getPath() + "/head"));
                        p.handheld(c, p.modLoc("item/tools/color/" + type.getPath() + "/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
        }

        /**
         * 注册工具
         *
         * @param type       类型: Sword/Pickaxe/Axe/Shovel/Hoe
         * @param tier       等级
         * @param properties 工具属性
         * @return 工具句柄
         */
    //    public static ItemEntry<? extends Item> registerAloneTool(String id, String type, Tier tier, Item.Properties properties, int craftingDamage, String texture) {
    //        return switch (type) {
    //            case "sword" -> REGISTER.item(id,
    //                            (p) -> new SwordDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
    //                    .register();
    //            case "pickaxe" -> REGISTER.item(id,
    //                            (p) -> new PickaxeDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
    //                    .register();
    //            case "axe" -> REGISTER.item(id,
    //                            (p) -> new AxeDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
    //                    .register();
    //            case "shovel" -> REGISTER.item(id,
    //                            (p) -> new ShovelDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
    //                    .register();
    //            case "hoe" -> REGISTER.item(id,
    //                            (p) -> new HoeDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
    //                    .register();
    //            case "hammer" -> REGISTER.item(id,
    //                            (p) -> new HammerDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
    //                    .register();
    //            default -> throw new IllegalArgumentException("Error Type");
    //        };
    //    }
    //
    //    public static ItemEntry<? extends Item> registerColorTool(String id, int color, String type, Tier tier, Item.Properties properties, int craftingDamage) {
    //        return switch (type) {
    //            case "sword" -> REGISTER.item(id,
    //                            (p) -> new SwordDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> {
    //                        p.handheld(c, p.modLoc("item/tool/color/sword/head"));
    //                        p.handheld(c, p.modLoc("item/tool/color/sword/handle"));
    //                    })
    //                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
    //                    .register();
    //            case "pickaxe" -> REGISTER.item(id,
    //                            (p) -> new PickaxeDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> {
    //                        p.handheld(c, p.modLoc("item/tool/color/pickaxe/head"));
    //                        p.handheld(c, p.modLoc("item/tool/color/pickaxe/handle"));
    //                    })
    //                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
    //                    .register();
    //            case "axe" -> REGISTER.item(id,
    //                            (p) -> new AxeDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> {
    //                        p.handheld(c, p.modLoc("item/tool/color/axe/head"));
    //                        p.handheld(c, p.modLoc("item/tool/color/axe/handle"));
    //                    })
    //                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
    //                    .register();
    //            case "shovel" -> REGISTER.item(id,
    //                            (p) -> new ShovelDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> {
    //                        p.handheld(c, p.modLoc("item/tool/color/shovel/head"));
    //                        p.handheld(c, p.modLoc("item/tool/color/shovel/handle"));
    //                    })
    //                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
    //                    .register();
    //            case "hoe" -> REGISTER.item(id,
    //                            (p) -> new HoeDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> {
    //                        p.handheld(c, p.modLoc("item/tool/color/hoe/head"));
    //                        p.handheld(c, p.modLoc("item/tool/color/hoe/handle"));
    //                    })
    //                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
    //                    .register();
    //            case "hammer" -> REGISTER.item(id,
    //                            (p) -> new HammerDamageToolCrafting(tier, properties, craftingDamage))
    //                    .model((c, p) -> {
    //                        p.handheld(c, p.modLoc("item/tool/color/hammer/head"));
    //                        p.handheld(c, p.modLoc("item/tool/color/hammer/handle"));
    //                    })
    //                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
    //                    .register();
    //            default -> throw new IllegalArgumentException("Error Type");
    //        };
    //    }
    }