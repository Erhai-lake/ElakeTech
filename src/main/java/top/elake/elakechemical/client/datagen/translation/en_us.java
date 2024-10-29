package top.elake.elakechemical.client.datagen.translation;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elakechemical.ElakeChemical;

import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class en_us extends LanguageProvider {
    public en_us(PackOutput output) {
        super(output, ElakeChemical.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (List<String> item : I18n.LIST) {
            add(item.get(0), item.get(1));
        }
    }
}
