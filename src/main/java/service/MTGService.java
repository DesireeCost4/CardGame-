package service;

//aqui estou importando "UniRest".
//É usado para lidar com envio de reqs http o maven funciona como um tipo de gerenciador de pacotes, exemplo NPM.
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MTGService {



    //Alterando para tipo Object, pois posso acessar lá no card para preencher os campos da carta.

    //JSONObject Objeto que representa o JSON da resposta, como um mapa de chaves e valores

        public JSONObject buscarCard(String nomeCarta) {
            String url = "https://api.scryfall.com/cards/named?fuzzy=" + nomeCarta + "&lang=pt";

            //tentativa:
            try {

                // requisição do tipo get, passando a String url concatenada pronta para busca.
                HttpResponse<JsonNode> response = Unirest.get(url).asJson();

                if (response.getStatus() == 200) {
                    // Retorna o JSON completo como String

                    System.out.println("Status: " + response.getStatus());
                    //System.out.println("Body: " + response.getBody());

                    return response.getBody().getObject();

                } else {
                    System.out.println("Erro: " + response.getStatus());
                    return null;
                }

            } catch (Exception e) {
                System.out.println("Erro na requisição: " + e.getMessage());
                return null;
            }
        }


    public List<String> listarNomesCartas(String setCode) {
        List<String> nomes = new ArrayList<>();

        try {
            String url = "https://api.scryfall.com/cards/search?q=set:" + setCode + "&unique=cards&lang=pt";
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            if (response.getStatus() != 200) {
                System.out.println("Erro ao buscar cartas do set: " + setCode);
                return nomes;
            }

            JSONObject jsonResponse = response.getBody().getObject();
            JSONArray data = jsonResponse.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject card = data.getJSONObject(i);
                String nome = card.optString("printed_name", card.optString("name"));
                nomes.add(nome);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar nomes das cartas: " + e.getMessage());
        }

        return nomes;
    }
}

