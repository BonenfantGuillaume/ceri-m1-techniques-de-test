package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{
    @Override
    public Pokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(pokemonFactory, metadataProvider);
    }
}
