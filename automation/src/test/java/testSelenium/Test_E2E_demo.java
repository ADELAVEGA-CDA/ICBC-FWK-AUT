package testSelenium;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Test_E2E_demo {
    protected static Logger logger = LogManager.getLogger(String.valueOf(Test_E2E_demo.class));

    public static void main(String[] args) {
        // DATOS
        String baseURL = "https://bookstore.toolsqa.com";
        String nombre = "TOOLSQA-Test";
        String pass = "Test@@123";
        String datos_1 = "{ \"userName\":\"" + nombre + "\", \"password\":\"" + pass + "\"}";
        String path_Autho = "/Account/v1/Authorized";
        String path_Token = "/Account/v1/GenerateToken";
        String path_Book = "/bookStore/v1/Books";
        logger.info("Datos: " + baseURL + "\n - " + nombre + "\n - " + pass);

        // Conexion
        RestAssured.baseURI = baseURL;
        RequestSpecification solicitud = RestAssured.given();

        logger.info("\n Solicitud GET para consulta Authorized \n");
        solicitud.header("Content-Type", "application/json");
        Response respuesta_autho = solicitud.body(datos_1).get(path_Autho);

        logger.info(respuesta_autho.getStatusCode());
        Assert.assertEquals(respuesta_autho.getStatusCode(), 200);

        logger.info("\n Solicitud POST para TokenGenerator y obtiene Token \n");
        Response respuesta = solicitud.body(datos_1).post(path_Token);

        logger.info(respuesta.getStatusCode());
        Assert.assertEquals(respuesta.getStatusCode(), 200);

        String jsonDatos = respuesta.asString();
        logger.info(jsonDatos.toString() + "\n token: " + JsonPath.from(jsonDatos).get("token"));
        Assert.assertTrue(jsonDatos.contains("token"));
        String token = JsonPath.from(jsonDatos).get("token");
        logger.info(token);


        logger.info("\n Solicitud GET para consulta \n");
        respuesta = solicitud.get(path_Book);
        logger.info(respuesta.getStatusCode());
        Assert.assertEquals(respuesta.getStatusCode(), 200);

        jsonDatos = respuesta.asString();
        logger.info(jsonDatos);
        List<Map<String, String>> libros = JsonPath.from(jsonDatos).get("books");
        logger.info(libros.size());
        Assert.assertTrue(libros.size() > 0);

        String librosId = libros.get(0).get("isbn");
        logger.info(librosId);

        logger.info("\n Agrega un registro con autorizacion \n");
        String userId = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String Datos_2 = "{ \"userId\": \"" + userId + "\", \"collectionOfIsbns\": [ { \"isbn\": \"" + librosId + "\" } ]}";

        solicitud.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");
        respuesta = solicitud.body(Datos_2).post(path_Book);

        logger.info(respuesta.getStatusCode() + "\n " + respuesta.getStatusLine() + "\n " + respuesta.getContentType() + "\n " + respuesta.getBody());

    }

}
