import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
/**
 * Created by nurkulov 12/26/19
 */
public class APITasks {
    /*
     * GET all soccer team names listed in given resource
     * Deserialization type: TypeReference
     */
    public static List<String> getAllTeams() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<String> allTeams = new ArrayList<>();
        List<Map<String, Object>> listOfTeams = (List<Map<String, Object>>) deseializedMap.get("teams");
        for (int i = 0; i < listOfTeams.size(); i++) {
            Map<String, Object> map = listOfTeams.get(i);
            allTeams.add((String) map.get("name"));
        }
        return allTeams;
    }
    /*
     * GET names of all goalkeepers from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getAllGoalkeepers() throws IOException, URISyntaxException {
        List<String> allTeams = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = client.execute(httpGet);
        Map<String, Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> squadGoalkeepers = (List<Map<String, Object>>) parsedResponse.get("squad");
        for (Map<String, Object> eachPlayer : squadGoalkeepers) {
            if (eachPlayer.get("position").equals("Goalkeeper")) {
                allTeams.add(eachPlayer.get("name").toString());
            }
        }
        return allTeams;
    }
    /*
     * GET names of all defenders from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getDefenders() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<String> defenders = new ArrayList<>();
        List<Map<String, Object>> listOfSquad = (List<Map<String, Object>>) deseializedMap.get("squad");
        for (int i = 0; i < listOfSquad.size(); i++) {
            Map<String, Object> map = listOfSquad.get(i);
            if (((String) map.get("position")).equals("Defender")) {
                defenders.add((String) map.get("name"));
            }
        }
        return defenders;
    }

    /*
     * GET names of all midfielders from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getMidfielders() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<String> midFielders = new ArrayList<>();
        List<Map<String, Object>> listOfSquad = (List<Map<String, Object>>) deseializedMap.get("squad");
        for (int i = 0; i < listOfSquad.size(); i++) {
            Map<String, Object> map = listOfSquad.get(i);
            if (((String) map.get("position")).equals("Midfielder")) {
                midFielders.add((String) map.get("name"));
            }
        }
        return midFielders;
    }
    /*
     * GET names of all midfielders from England team whose country is Brazil
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getMidfielderFromBrazil() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<String> midFieldersFromBrazil = new ArrayList<>();
        List<Map<String, Object>> listOfSquad = (List<Map<String, Object>>) deseializedMap.get("squad");
        for (int i = 0; i < listOfSquad.size(); i++) {
            Map<String, Object> map = listOfSquad.get(i);
            if (((String) map.get("position")).equals("Midfielder") && ((String) map.get("countryOfBirth")).equals("Brazil")) {
                midFieldersFromBrazil.add((String) map.get("name"));
            }
        }
        return midFieldersFromBrazil;
    }
    /*
     * GET names of all attackers from England team whose origin country is England
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getAttackerFromEngland() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<String> attackers = new ArrayList<>();
        List<Map<String, Object>> listOfSquad = (List<Map<String, Object>>) deseializedMap.get("squad");
        for (int i = 0; i < listOfSquad.size(); i++) {
            Map<String, Object> map = listOfSquad.get(i);
            if (((String) map.get("position")).equals("Attacker")&& ((String) map.get("countryOfBirth")).equals("England")) {
                attackers.add((String) map.get("name"));
            }
        }
        return attackers;
    }
    /*
     * GET name of Spain team coach
     * note: Spain team id is 77
     * Deserialization type: TypeReference
     */
    public static List<String> getSpainCoach() throws URISyntaxException, IOException {
        List<String> allSpainCoach = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/77");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");
        httpGet.addHeader("X-Auth-Token","a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        Map<String,Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });
        List<Map<String,Object>> squadGoalkeepers = (List<Map<String,Object>>) parsedResponse.get("squad");
        for(Map<String,Object> eachPlayer : squadGoalkeepers){
            if(eachPlayer.get("role").equals("COACH")){
                allSpainCoach.add(eachPlayer.get("name").toString());
            }
        }
        return allSpainCoach;
    }
    /*
     * GET list of all competitions
     * Deserialization type: TypeReference
     */
    public static List<String> getAllCompetitions() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/competitions");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<String> competitions = new ArrayList<>();
        List<Map<String, Object>> listOfCompetitions = (List<Map<String, Object>>) deseializedMap.get("competitions");
        for (int i = 0; i < listOfCompetitions.size(); i++) {
            Map<String, Object> map = listOfCompetitions.get(i);
            competitions.add((String) map.get("name"));
        }
        return competitions;
    }
    /*
     * GET names of second highest scorer from competitions of 2000 season
     * note: endpoint for competitions: `competitions/<year>/
     * note: endpoint for scorers: `competitions/<year>/scorers`
     * Deserialization type: TypeReference
     */
    public static List<String> getSecondHighestScorer() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.football-data.org").setPath("v2/competitions/2000/scorers/");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("X-Auth-Token", "a91af6e8144e4ddca37e290aa57ea114");
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deseializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Integer> scors = new ArrayList<>();
        List<Map<String,Object>> listOfScorers =(List<Map<String,Object>>)  deseializedMap.get("scorers");
        for (int i =0; i<listOfScorers.size(); i++){
            Map<String,Object> map = listOfScorers.get(i);
            scors.add((Integer) map.get("numberOfGoals"));
        }
        Collections.sort(scors);
        int secondHigh = scors.get(scors.size()-2);
        List<String> names = new ArrayList<>();
        List<Map<String,Object>> scorers =(List<Map<String,Object>>)  deseializedMap.get("scorers");
        for (int i =0; i<listOfScorers.size(); i++) {
            Map<String,Object> map = listOfScorers.get(i);
            if (((Integer)map.get("numberOfGoals")==secondHigh)){
                Map<String, Object> map2 =(Map<String, Object>)(map.get("player"));
                names.add((String) map2.get("name"));
            }
        }
        return names;
    }
}





