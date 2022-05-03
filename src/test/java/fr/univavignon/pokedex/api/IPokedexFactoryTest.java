package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest extends TestCase {

    /*IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
    IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
    IPokedex iPokedex = mock(IPokedex.class);*/
    IPokedexFactory iPokedexFactory = new PokedexFactory();
    IPokemonMetadataProvider iPokemonMetadataProvider = new PokemonMetadataProvider();
    IPokemonFactory iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
    IPokedex iPokedex = new Pokedex(iPokemonFactory, iPokemonMetadataProvider);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

/*    @BeforeEach
    public void setUp() {
        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory)).thenReturn(iPokedex);
    }*/

    @Test
    public void testCreatePokedex() {
        iPokedex.addPokemon(bulbizarre);
        IPokedex pokedexFromFactory = iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory);
        pokedexFromFactory.addPokemon(bulbizarre);
        assertEquals(iPokedex.getPokemons(), pokedexFromFactory.getPokemons());
    }

    @Test
    public void testCreatePokedexGetPokemon() {
        iPokedex.addPokemon(bulbizarre);
        IPokedex pokedexFromFactory = iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory);
        pokedexFromFactory.addPokemon(bulbizarre);
        try {
            assertEquals(iPokedex.getPokemon(0), pokedexFromFactory.getPokemon(0));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}