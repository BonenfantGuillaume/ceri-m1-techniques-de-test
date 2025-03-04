package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest extends TestCase {

    //IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
    //IPokemonFactory iPokemonFactory = new PokemonFactory(new PokemonMetadataProvider());
    IPokemonFactory iPokemonFactory = new RocketPokemonFactory();
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    /*@Before
    public void setUp() {
        when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(Aquali);
    }*/


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
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
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
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
    }

    @Test
    public void testGetAttackBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 2729, 202, 5000, 4);
        assertTrue(pokemon.getAttack() >= bulbizarre.getAttack() && pokemon.getAttack() <= bulbizarre.getAttack() + 15);
    }

    @Test
    public void testGetDefenseBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 2729, 202, 5000, 4);
        assertTrue(pokemon.getDefense() >= bulbizarre.getDefense() && pokemon.getDefense() <= bulbizarre.getDefense() + 15);
    }

    @Test
    public void testGetStaminaBulbizarre() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 2729, 202, 5000, 4);
        assertTrue(pokemon.getStamina() >= bulbizarre.getStamina() && pokemon.getStamina() <= bulbizarre.getStamina() + 15);
    }

    @Test
    public void testConstructor() {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new RocketPokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(aquali.getName(), pokemon.getName());
    }

    @Test
    public void testCreatePokemonNull() {
        Pokemon pokemon = iPokemonFactory.createPokemon(157, 2729, 202, 5000, 4);
        assertEquals(null, pokemon);
    }
}