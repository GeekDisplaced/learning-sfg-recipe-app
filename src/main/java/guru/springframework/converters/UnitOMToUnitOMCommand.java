package guru.springframework.converters;

import guru.springframework.commands.UnitOMCommand;
import guru.springframework.domain.UnitOM;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class UnitOMToUnitOMCommand implements Converter<UnitOM, UnitOMCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOMCommand convert(UnitOM unitOM) {

        if (unitOM != null) {
            final UnitOMCommand unitOMCommand = new UnitOMCommand();
            unitOMCommand.setId(unitOM.getId());
            unitOMCommand.setDescription(unitOM.getDescription());
            return unitOMCommand;
        }
        return null;
    }
}
