package top.elake.elaketech.util.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.HoeItem;
import top.elake.elaketech.util.tools.damage.*;

/**
 * @author ElakeStudio
 */
public enum ToolType {
    /**
     * 工具类型
     */
    SWORD("sword", SwordDamageToolCrafting::new, 3, -2.4F),
    PICKAXE("pickaxe", PickaxeDamageToolCrafting::new, 1, -2.8F),
    AXE("axe", AxeDamageToolCrafting::new, 5, -3.0F),
    SHOVEL("shovel", ShovelDamageToolCrafting::new, 1.5F, -3.0F),
    HOE("hoe", HoeDamageToolCrafting::new, -1, -3.0F),
    HAMMER("hammer", HammerDamageToolCrafting::new, 4, -2.8F);

    private final String path;
    private final TriFunction<Tier, Item.Properties, Integer, ? extends Item> itemFactory;
    private final float defaultAttackDamage;
    private final float defaultAttackSpeed;

    ToolType(String path, TriFunction<Tier, Item.Properties, Integer, ? extends Item> itemFactory, float defaultAttackDamage, float defaultAttackSpeed) {
        this.path = path;
        this.itemFactory = itemFactory;
        this.defaultAttackDamage = defaultAttackDamage;
        this.defaultAttackSpeed = defaultAttackSpeed;
    }

    public String getPath() {
        return path;
    }

    public TriFunction<Tier, Item.Properties, Integer, ? extends Item> getItemFactory() {
        return itemFactory;
    }

    public ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        float damage = attackDamage != 0 ? attackDamage : tier.getAttackDamageBonus() + defaultAttackDamage;
        float speed = attackSpeed != 0 ? attackSpeed : defaultAttackSpeed;

        return switch (this) {
            case SWORD -> SwordItem.createAttributes(tier, damage, speed);
            case PICKAXE -> PickaxeItem.createAttributes(tier, damage, speed);
            case AXE -> AxeItem.createAttributes(tier, damage, speed);
            case SHOVEL -> ShovelItem.createAttributes(tier, damage, speed);
            case HOE -> HoeItem.createAttributes(tier, damage, speed);
            case HAMMER -> createHammerAttributes(tier, damage, speed);
        };
    }

    private ItemAttributeModifiers createHammerAttributes(Tier tier, float damage, float speed) {
        // 自定义锤子属性或复用斧头属性
        return AxeItem.createAttributes(tier, damage, speed);
    }
}