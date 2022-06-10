package br.com.pokedex;

import br.com.pokedex.view.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.pokedex.network.HTTPRequest;

public class App {
    public static void main(String[] args) throws Exception {
        view views = new view();
        int pokemon;

        JSONObject object = new HTTPRequest()
                .requestGetMethod("https://pokeapi.co/api/v2/pokemon?limit=151");

        // int count = object.getInt("count");
        // String next = object.getString("next");
        JSONArray array = object.getJSONArray("results");
        views.enunciado();
        views.cabecalho();
        for (int index = 0; index < array.length(); index++) {
            JSONObject pokeObject = array.getJSONObject(index);
            String pokeNome = pokeObject.getString("name");
            System.out.println( "| "+ index + " -->  " + pokeNome);
        }
        pokemon = views.infoUsuario();

        //PEGA A URL do Pokemon escolhido
        JSONObject pokeObject1 = array.getJSONObject(pokemon);
        String pokeName = pokeObject1.getString("name");
        String pokeUrl = pokeObject1.getString("url");

        System.out.println("Pokemon escolhido:");
        System.out.println("| "+pokeName +"\n");
       
        // //"Entra" dentro de JSON do pokemon
        JSONObject object2 = new HTTPRequest()
                .requestGetMethod(pokeUrl);

        // //Entra dentro de ABILITIES
        JSONArray arrayAbilities = object2.getJSONArray("abilities");
        System.out.println("\n"+"| Habilidades  |" +"\n");
        for (int i = 0; i < arrayAbilities.length(); i++) {
            JSONObject pokeAbilities = arrayAbilities.getJSONObject(i).getJSONObject("ability");
            String name = pokeAbilities.getString("name");
            System.out.println("|  -->" +name);
        }


        //types

        JSONArray arrayTypes = object2.getJSONArray("types");
        System.out.println( "\n" + "| Tipos  |" +"\n");
        for (int i = 0; i < arrayTypes.length(); i++) {
            JSONObject pokeTypes = arrayTypes.getJSONObject(i).getJSONObject("type");
            String name = pokeTypes.getString("name");
            System.out.println("|  -->" +name);
        }

        //stats

        JSONArray arrayStats = object2.getJSONArray("stats");
        System.out.println("\n"+"| Status  |");
        for (int i = 0; i < arrayStats.length(); i++) {
            JSONObject pokeTypes = arrayStats.getJSONObject(i).getJSONObject("stat");
            int baseStat = arrayStats.getJSONObject(i).getInt("base_stat");
            String name = pokeTypes.getString("name");
            System.out.println("|  -->" +name + ": " +  baseStat);
        }

        //MOVIES

        JSONArray arrayMoves = object2.getJSONArray("moves");
        System.out.println("\n"+"| Movimentos  |" +"\n");
        for (int i = 0; i < arrayMoves.length(); i++) {
            JSONObject pokeMove = arrayMoves.getJSONObject(i).getJSONObject("move");
            String name = pokeMove.getString("name");
            System.out.println("|  -->" +name);
        }










        

            
            
        




    }

    
}
