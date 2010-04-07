import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Test {


    public static void main(String[] args) {
        Client client = Client.create();
        WebResource webResource = client.resource("http://shrub.appspot.com/s3hub?format=json");
        String response = webResource.get(String.class);
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = null;
        try {
            jsonObj = (JSONObject) parser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (jsonObj != null && jsonObj.containsKey("maxKeys")) {
            System.out.println(jsonObj.get("maxKeys").toString());
        } else {
            System.out.println("maxKeys not found");
        }
    }
}
