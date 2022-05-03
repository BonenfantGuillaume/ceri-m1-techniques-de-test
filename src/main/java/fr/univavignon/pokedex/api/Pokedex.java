package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    IPokemonFactory iPokemonFactory;
    IPokemonMetadataProvider iPokemonMetadataProvider;

    public Pokedex(IPokemonFactory iPokemonFactoryCopy, IPokemonMetadataProvider iPokemonMetadataProviderCopy){
        iPokemonFactory = iPokemonFactoryCopy;
        iPokemonMetadataProvider = iPokemonMetadataProviderCopy;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            return pokemons.get(id);
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new PokedexException("Pokémon non découvert");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        ArrayList<Pokemon> pokemonsSorted = new ArrayList<Pokemon>(pokemons);
        Collections.sort(pokemonsSorted, order);
        return pokemonsSorted;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return iPokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return iPokemonMetadataProvider.getPokemonMetadata(index);
    }
}
