package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest extends TestCase {

    IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    @Before
    public void setUp() {
        when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(Aquali);
    }


    @Test
    public void testGetCpBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(613, pokemon.getCp());
    }

    @Test
    public void testGetHpBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(64, pokemon.getHp());
    }

    @Test
    public void testDustBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4000, pokemon.getDust());
    }

    @Test
    public void testGetCandyBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void testGetIvBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals((double) 56, pokemon.getIv());
    }

    @Test
    public void testGetCpAquali() {
        Pokemon pokemon = iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(2729, pokemon.getCp());
    }

    @Test
    public void testGetHpAquali() {
        Pokemon pokemon = iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(202, pokemon.getHp());
    }

    @Test
    public void testDustAquali() {
        Pokemon pokemon = iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(5000, pokemon.getDust());
    }

    @Test
    public void testGetCandyAquali() {
        Pokemon pokemon = iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void testGetIvAquali() {
        Pokemon pokemon = iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals((double) 100, pokemon.getIv());
    }
}