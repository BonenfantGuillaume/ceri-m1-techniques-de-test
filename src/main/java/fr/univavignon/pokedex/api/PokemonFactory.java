package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    Map<Integer, PokemonMetadata> pokemonsMetadata = new HashMap<Integer, PokemonMetadata>();

    public PokemonFactory() {
        pokemonsMetadata.put(0, new PokemonMetadata(0,  "Bulbizarre", 126, 126, 90));
        pokemonsMetadata.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        //TODO : Gotta map them all !
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
    {
        PokemonMetadata pokemonMetadata = pokemonsMetadata.get(0);
        Random rand = new Random();

        int randAtk = rand.nextInt(16);
        int atk = pokemonMetadata.getAttack() + randAtk;
        int randDef = rand.nextInt(16);
        int def = pokemonMetadata.getDefense() + randDef;
        int randStam = rand.nextInt(16);
        int stam = pokemonMetadata.getStamina() + randStam;

        int iv = (int) ((randAtk + randDef + randStam) * 100 / 45);

        Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), atk, def, stam, cp, hp, dust, candy, iv);
        return pokemon;
    }
}
