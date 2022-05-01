package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest extends TestCase {

    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
    IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
    IPokedex iPokedex = mock(IPokedex.class);

    @BeforeEach
    public void setUp() {
        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory)).thenReturn(iPokedex);
    }

    @Test
    public void testCreatePokedex() {
        assertEquals(iPokedex, iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory));
    }
}