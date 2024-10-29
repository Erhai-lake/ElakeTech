package top.elake.elakechemical.client.dataGenerators.translation;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.item.Sundries;

/**
 * @author Erhai-lake
 */
public class zh_cn extends LanguageProvider {
    public zh_cn(PackOutput output) {
        super(output, ElakeChemical.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(Sundries.TEST.get(), "测试");
    }
}
