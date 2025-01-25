package top.elake.elaketech.datagen.resources.assets.translation.i18n.language;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.translation.i18n.Common;

import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class EN extends LanguageProvider {
    public EN(PackOutput output) {
        super(output, ElakeTech.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (List<String> item : Common.LIST) {
            add(item.get(0), item.get(1));
        }
    }
}
