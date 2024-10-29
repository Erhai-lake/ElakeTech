package top.elake.elakechemical.client.datagen.translation;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elakechemical.ElakeChemical;

import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class zh_cn extends LanguageProvider {
    public zh_cn(PackOutput output) {
        super(output, ElakeChemical.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        // 元素
//        for (DeferredItem<? extends Item> element : ModCreativeModeTab.REGISTERED_ELEMENTS) {
//            add(element.get(), element.getRegisteredName().replace(ElakeChemical.MODID + ":", ""));
//        }
        // 材料
        // 草纤维
//        add(Materials.GRASS_FIBER.get(), "草纤维");
        // 草绳
//        add(Materials.GRASS_STRING.get(), "草绳");
        // 铜板
//        add(Materials.COPPER_PLATE.get(), "铜板");
        // 铜线
//        add(Materials.COPPER_WIRE.get(), "铜线");
        // 铜简易单闸线圈
//        add(Materials.SIMPLE_COPPER_SINGLE_SOLENOID.get(), "铜简易单闸线圈");
        // 石墨
//        add(Materials.GRAPHITE.get(), "石墨");
        // 燧石剑
//        add(Flint.FLINT_SWORD.get(), "燧石剑");
        // 燧石镐
//        add(Flint.FLINT_PICKAXE.get(), "燧石镐");
        // 燧石斧
//        add(Flint.FLINT_AXE.get(), "燧石斧");
        // 燧石手斧
//        add(Flint.FLINT_HANDAXE.get(), "燧石手斧");
        // 燧石锹
//        add(Flint.FLINT_SHOVEL.get(), "燧石锹");
        // 燧石锄
//        add(Flint.FLINT_HOE.get(), "燧石锄");
        // 石锤
//        add(Hammer.STONE_HAMMER.get(), "石锤");
        for (List<String> item : I18n.LIST) {
            add(item.get(0), item.get(2));
        }
    }
}
