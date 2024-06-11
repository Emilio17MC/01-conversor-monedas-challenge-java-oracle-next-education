import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarAPI {

    public Moneda generarConversion(String base_code, String target_code, double cantidad) {

        String direccionAPI = "https://v6.exchangerate-api.com/v6/482af6b5a4cfa2f9aba1a6a9/pair/" + base_code + "/" + target_code + "/" + cantidad + "/";

        URI direccion = URI.create(direccionAPI);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            return gson.fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Recurso no encontrado");
        }
    }

}
