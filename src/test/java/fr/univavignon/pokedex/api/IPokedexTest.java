package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest extends TestCase {
    IPokedex iPokedex = mock(IPokedex.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();


    @BeforeEach
    public void setUp() {
        when(iPokedex.addPokemon(any(Pokemon.class))).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                pokemons.add(invocationOnMock.getArgument(0));
                return pokemons.size() - 1;
            }
        });

        when(iPokedex.size()).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return pokemons.size();
            }
        });

        try {
            when(iPokedex.getPokemon(any(Integer.class))).then(new Answer<Pokemon>() {
                @Override
                public Pokemon answer(InvocationOnMock invocationOnMock) throws Throwable {
                    return pokemons.get(invocationOnMock.getArgument(0));
                }
            });
        } catch (PokedexException e) {
            e.printStackTrace();
        }

        when(iPokedex.getPokemons()).then(new Answer<List<Pokemon>>() {
            @Override
            public List<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                return pokemons;
            }
        });

    }




    @Test
    public void testSize0() {
        assertEquals(0, iPokedex.size());
    }

    @Test
    public void testSize1() {
        iPokedex.addPokemon(bulbizarre);
        assertEquals(1, iPokedex.size());
    }

    @Test
    public void testAddBulbizarre() {
        assertEquals(0, iPokedex.addPokemon(bulbizarre));
        assertEquals(1, iPokedex.addPokemon(bulbizarre));
    }


    @Test
    public void testAddAquali() {
        assertEquals(0, iPokedex.addPokemon(aquali));
        assertEquals(1, iPokedex.addPokemon(aquali));
    }

    @Test
    public void testGetPokemon0() {
        try {
            iPokedex.addPokemon(bulbizarre);
            assertEquals(bulbizarre, iPokedex.getPokemon(0));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemon1() {
        try {
            iPokedex.addPokemon(bulbizarre);
            iPokedex.addPokemon(aquali);
            System.out.println(pokemons);
            assertEquals(aquali, iPokedex.getPokemon(1));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemons() {
        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(aquali);
        iPokedex.addPokemon(bulbizarre);
        ArrayList<Pokemon> pokemonsCopyPasta = new ArrayList<Pokemon>();
        pokemonsCopyPasta.add(bulbizarre);
        pokemonsCopyPasta.add(aquali);
        pokemonsCopyPasta.add(bulbizarre);
        assertEquals(pokemonsCopyPasta, iPokedex.getPokemons());
    }

/*    @Test
    public void testTestGetPokemons() {
    }*/
}