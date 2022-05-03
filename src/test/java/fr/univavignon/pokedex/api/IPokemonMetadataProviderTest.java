package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest extends TestCase {
    //IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonMetadataProvider iPokemonMetadataProvider = new PokemonMetadataProvider();

    /*@BeforeEach
    public void setUp() {
        try {
            when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
            when(iPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
        }
        catch (PokedexException e)
        {
            e.printStackTrace();
        }
    }*/

    @Test
    public void testGetIndexBulbizarre() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(0, pokemonMetadata.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNameBulbizarre() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals("Bulbizarre", pokemonMetadata.getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttackBulbizarre() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(126, pokemonMetadata.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDefenseBulbizarre() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(126, pokemonMetadata.getDefense());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetStaminaBulbizarre() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(90, pokemonMetadata.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetIndexAquali() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals(133, pokemonMetadata.getIndex());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNameAquali() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals("Aquali", pokemonMetadata.getName());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttackAquali() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals(186, pokemonMetadata.getAttack());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDefenseAquali() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals(168, pokemonMetadata.getDefense());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetStaminaAquali() {
        try {
            PokemonMetadata pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals(260, pokemonMetadata.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemonMetadataException() {
        try {
            assertEquals("Pokemon non découvert", iPokemonMetadataProvider.getPokemonMetadata(3));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
}