package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        PokemonFactory PokemonFactory = new PokemonFactory(pokemonMetadataProvider);
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokemonMetadataProvider, PokemonFactory));
    }
}
