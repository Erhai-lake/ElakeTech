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

    /**
     * 工具id
     *
     * @param id id
     * @return ToolBuilder
     */
    public ToolBuilder id(String id) {
        this.id = id;
        return this;
    }

    /**
     * 工具类型
     *
     * @param type ToolType
     * @return ToolBuilder
     */
    public ToolBuilder type(ToolType type) {
        this.type = type;
        return this;
    }

    /**
     * 工具等级
     *
     * @param tier 等级
     * @return ToolBuilder
     */
    public ToolBuilder tier(Tier tier) {
        this.tier = tier;
        return this;
    }

    /**
     * 工具攻击伤害和速度
     *
     * @param damage 伤害
     * @param speed  速度
     * @return ToolBuilder
     */
    public ToolBuilder attack(int damage, float speed) {
        this.attackDamage = damage;
        this.attackSpeed = speed;
        return this;
    }

    /**
     * 合成时扣除耐久度
     *
     * @param damage 耐久度
     * @return ToolBuilder
     */
    public ToolBuilder craftingDamage(int damage) {
        this.craftingDamage = damage;
        return this;
    }

    /**
     * 工具贴图
     *
     * @param path 路径
     * @return ToolBuilder
     */
    public ToolBuilder texture(String path) {
        this.texture = path;
        return this;
    }

    /**
     * 颜色渲染
     *
     * @param color 颜色值
     * @return ToolBuilder
     */
    public ToolBuilder colored(int color) {
        this.color = color;
        this.isColored = true;
        return this;
    }

    /**
     * 构建工具
     *
     * @return ItemEntry
     */
    public ItemEntry<? extends Item> build() {
        Item.Properties properties = new Item.Properties()
                .attributes(type.createAttributes(tier, attackDamage, attackSpeed));

        if (isColored) {
            return registerColorTool(properties);
        }
        return registerStandardTool(properties);
    }

    /**
     * 注册工具
     *
     * @param properties 属性
     * @return ItemEntry
     */
    private ItemEntry<? extends Item> registerStandardTool(Item.Properties properties) {
        String path = texture != null ? texture : String.format("item/tools/%s/%s", id.split("_")[0], type.getPath());

        return REGISTER.item(id, p -> type.getItemFactory().apply(tier, properties, craftingDamage))
                .model((c, p) -> p.generated(c, p.modLoc(path)))
                .register();
    }

    /**
     * 注册颜色渲染工具
     *
     * @param properties 属性
     * @return ItemEntry
     */
    private ItemEntry<? extends Item> registerColorTool(Item.Properties properties) {
        return REGISTER.item(id, p -> type.getItemFactory().apply(tier, properties, craftingDamage))
                .model((c, p) -> {
                    p.handheld(c, p.modLoc("item/tools/color/" + type.getPath() + "/head"));
                    p.handheld(c, p.modLoc("item/tools/color/" + type.getPath() + "/handle"));
                })
                .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                .register();
    }
}