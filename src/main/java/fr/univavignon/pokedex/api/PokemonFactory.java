package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    IPokemonMetadataProvider iPokemonMetadataProvider;

    public PokemonFactory(IPokemonMetadataProvider iPokemonMetadataProviderCopy) {
        iPokemonMetadataProvider = iPokemonMetadataProviderCopy;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
    {
        PokemonMetadata pokemonMetadata = null;
        try {
            pokemonMetadata = iPokemonMetadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
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
