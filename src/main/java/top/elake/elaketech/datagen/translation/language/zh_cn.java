package top.elake.elaketech.datagen.translation.language;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.translation.I18n;

import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class zh_cn extends LanguageProvider {
    public zh_cn(PackOutput output) {
        super(output, ElakeTech.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        for (List<String> item : I18n.LIST) {
            add(item.get(0), item.get(2));
        }
    }
}
