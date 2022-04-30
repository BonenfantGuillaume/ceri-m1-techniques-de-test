package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {

    String trainerName = "Sasha";
    IPokemonTrainerFactory iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    IPokedex iPokedex = new IPokedex() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public int addPokemon(Pokemon pokemon) {
            return 0;
        }

        @Override
        public Pokemon getPokemon(int id) throws PokedexException {
            return null;
        }

        @Override
        public List<Pokemon> getPokemons() {
            return null;
        }

        @Override
        public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
            return null;
        }

        @Override
        public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
            return null;
        }

        @Override
        public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
            return null;
        }
    };
    IPokedexFactory iPokedexFactory = new IPokedexFactory() {
        @Override
        public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
            return null;
        }
    };
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