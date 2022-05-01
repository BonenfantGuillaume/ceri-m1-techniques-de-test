package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {

    String trainerName = "Sasha";
    IPokemonTrainerFactory iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    IPokedex iPokedex = mock(IPokedex.class);
    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
    PokemonTrainer pokemonTrainer = new PokemonTrainer(trainerName, Team.MYSTIC, iPokedex);


    @BeforeEach
    public void setUp() {
        when(iPokemonTrainerFactory.createTrainer(trainerName, Team.MYSTIC, iPokedexFactory)).thenReturn(pokemonTrainer);
    }

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
        assertEquals(pokemonTrainer.getPokedex(), iPokemonTrainerFactory.createTrainer(trainerName, Team.MYSTIC, iPokedexFactory).getPokedex());
    }

    @Test
    public void testTrainer() {
        assertEquals(pokemonTrainer, iPokemonTrainerFactory.createTrainer(trainerName, Team.MYSTIC, iPokedexFactory));
    }
}