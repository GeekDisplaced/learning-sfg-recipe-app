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
public class UnitOMCommandToUnitOM implements Converter<UnitOMCommand, UnitOM>{

    @Synchronized
    @Nullable
    @Override
    public UnitOM convert(UnitOMCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOM unitOM = new UnitOM();
        unitOM.setId(source.getId());
        unitOM.setDescription(source.getDescription());
        return unitOM;
    }
}
