package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {

    String trainerName = "Sasha";
/*    IPokemonTrainerFactory iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    IPokedex iPokedex = mock(IPokedex.class);
    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
 */
    IPokemonTrainerFactory iPokemonTrainerFactory = new PokemonTrainerFactory();
    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    PokemonFactory pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
    IPokedex iPokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);
    PokemonTrainer pokemonTrainer = new PokemonTrainer(trainerName, Team.MYSTIC, iPokedex);
    IPokedexFactory iPokedexFactory = new PokedexFactory();
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    /*@BeforeEach
    public void setUp() {
        when(iPokemonTrainerFactory.createTrainer(trainerName, Team.MYSTIC, iPokedexFactory)).thenReturn(pokemonTrainer);
    }*/

    @Test
    public void testTrainerGetName() {
        assertEquals("Sasha", iPokemonTrainerFactory.createTrainer(trainerName, Team.MYSTIC, iPokedexFactory).getName());
    }

    @Test
    public void testTrainerGetTeam() {
        assertEquals(Team.MYSTIC, iPokemonTrainerFactory.createTrainer(trainerName, Team.MYSTIC, iPokedexFactory).getTeam());
    }

    @Test
    public void testTrainerGetPokedex() {
        pokemonTrainer.getPokedex().addPokemon(bulbizarre);
        Pokedex pokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);
        pokedex.addPokemon(bulbizarre);
        try {
            assertEquals(pokedex.getPokemon(0), pokemonTrainer.getPokedex().getPokemon(0));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}