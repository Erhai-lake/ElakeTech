package top.elake.elaketech.datagen.assets.translation.language;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elaketech.datagen.assets.translation.Translation;

import java.util.List;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class ZH extends LanguageProvider {
    public ZH(PackOutput output) {
        super(output, MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        for (List<String> item : Translation.LIST) {
            add(item.get(0), item.get(2));
        }
    }
}