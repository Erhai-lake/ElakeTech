package top.elake.elakechemical.client.datagen.translation;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.item.Materials;

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
        for (DeferredItem<? extends Item> element : ModCreativeModeTab.REGISTERED_ELEMENTS) {
            add(element.get(), element.getRegisteredName().replace(ElakeChemical.MODID + ":", ""));
        }
        // 材料
        // 草纤维
        add(Materials.GRASS_FIBER.get(), "草纤维");
        // 草绳
        add(Materials.GRASS_STRING.get(), "草绳");
    }
}
