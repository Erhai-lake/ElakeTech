package top.elake.elakechemical.client;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.item.Sundries;

/**
 * @author Erhai-lake
 */
public class Translation extends LanguageProvider {
    public Translation(PackOutput output) {
        super(output, ElakeChemical.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(Sundries.TEST.get(), "Ruby");
    }
}
