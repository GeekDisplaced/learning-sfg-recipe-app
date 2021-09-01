package guru.springframework.converters;

import guru.springframework.commands.UnitOMCommand;
import guru.springframework.domain.UnitOM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jt on 6/21/17.
 */
public class UnitOMToUnitOMCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOMToUnitOMCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOMToUnitOMCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOM()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOM unitOM = new UnitOM();
        unitOM.setId(LONG_VALUE);
        unitOM.setDescription(DESCRIPTION);
        //when
        UnitOMCommand uomc = converter.convert(unitOM);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }

}