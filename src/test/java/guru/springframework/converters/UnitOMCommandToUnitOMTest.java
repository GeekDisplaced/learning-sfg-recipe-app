package guru.springframework.converters;

import guru.springframework.commands.UnitOMCommand;
import guru.springframework.domain.UnitOM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOMCommandToUnitOMTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOMCommandToUnitOM converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOMCommandToUnitOM();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOMCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOMCommand command = new UnitOMCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOM unitOM = converter.convert(command);

        //then
        assertNotNull(unitOM);
        assertEquals(LONG_VALUE, unitOM.getId());
        assertEquals(DESCRIPTION, unitOM.getDescription());

    }

}