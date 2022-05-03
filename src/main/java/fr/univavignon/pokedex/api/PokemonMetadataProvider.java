package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    Map<Integer, PokemonMetadata> pokemonsMetadata = new HashMap<Integer, PokemonMetadata>();

    public PokemonMetadataProvider() {
        pokemonsMetadata.put(0, new PokemonMetadata(0,  "Bulbizarre", 126, 126, 90));
        pokemonsMetadata.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        //TODO : Gotta map them all !
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (pokemonsMetadata.get(index) == null)
        {
            throw new PokedexException("Pokemon non découvert");
        }
        return pokemonsMetadata.get(index);
    }
}
