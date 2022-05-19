package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest extends TestCase {
    //IPokedex iPokedex = mock(IPokedex.class);
    //IPokedex iPokedex = new Pokedex(new PokemonFactory(new PokemonMetadataProvider()), new PokemonMetadataProvider());
    IPokedex iPokedex = new Pokedex(new RocketPokemonFactory(), new PokemonMetadataProvider());
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    //ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    /*@BeforeEach
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
    }*/


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

    @Test
    public void testTestGetPokemonsComparatorINDEX() {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        pokemons.add(bulbizarre);

        ArrayList<Pokemon> pokemonsCopyPasta = new ArrayList<Pokemon>();
        pokemonsCopyPasta.add(bulbizarre);
        pokemonsCopyPasta.add(bulbizarre);
        pokemonsCopyPasta.add(aquali);

        Collections.sort(pokemons, PokemonComparators.INDEX); //Première façon de trier
        assertEquals(pokemonsCopyPasta, pokemons);
    }

    @Test
    public void testTestGetPokemonsComparatorNAME() {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        pokemons.add(bulbizarre);

        ArrayList<Pokemon> pokemonsCopyPasta = new ArrayList<Pokemon>();
        pokemonsCopyPasta.add(aquali);
        pokemonsCopyPasta.add(bulbizarre);
        pokemonsCopyPasta.add(bulbizarre);

        Collections.sort(pokemons, PokemonComparators.NAME); //Première façon de trier
        assertEquals(pokemonsCopyPasta, pokemons);
    }

    @Test
    public void testTestGetPokemonsComparatorCP() {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        pokemons.add(bulbizarre);

        ArrayList<Pokemon> pokemonsCopyPasta = new ArrayList<Pokemon>();
        pokemonsCopyPasta.add(bulbizarre);
        pokemonsCopyPasta.add(bulbizarre);
        pokemonsCopyPasta.add(aquali);

        pokemons.sort(PokemonComparators.CP); //Deuxième façon de trier
        assertEquals(pokemonsCopyPasta, pokemons);
    }

    @Test
    public void testPokedexExceptionMoins1() {
        try {
            assertEquals("Pokemon non decouvert", iPokedex.getPokemon(-1));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPokedexException2() {
        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(bulbizarre);
        try {
            assertEquals("Pokemon non decouvert", iPokedex.getPokemon(2));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePokemonName() {
        iPokedex.addPokemon(iPokedex.createPokemon(0, 613, 64, 4000, 4));
        try {
            assertEquals(bulbizarre.getName(), iPokedex.getPokemon(0).getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePokemonCP() {
        iPokedex.addPokemon(iPokedex.createPokemon(0, 613, 64, 4000, 4));
        try {
            assertEquals(bulbizarre.getCp(), iPokedex.getPokemon(0).getCp());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemonMetadata() {
        try {
            PokemonMetadata pokemonMetadata = iPokedex.getPokemonMetadata(0);
            assertEquals(pokemonMetadata.getAttack(), bulbizarre.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemonsComparator() {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(aquali);
        pokemons.add(bulbizarre);
        pokemons.add(bulbizarre);
        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(aquali);
        assertEquals(pokemons, iPokedex.getPokemons(PokemonComparators.NAME));
    }
}