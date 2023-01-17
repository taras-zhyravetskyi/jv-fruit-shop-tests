package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String REPORT_HEADER = "fruit,quantity";
    private static final String ELEMENT_SEPARATOR = ",";
    private FruitDao fruitDao;

    {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public String generate() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : fruitDao.getMapEntry()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(ELEMENT_SEPARATOR)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
