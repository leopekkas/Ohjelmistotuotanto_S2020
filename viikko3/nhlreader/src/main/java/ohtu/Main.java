package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players);
        
        
        System.out.println("Oliot:");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                int points = player.getGoals() + player.getAssists();
                System.out.printf("%-20s %-8s %-3s +   %-3s =   %-3s\n", player.getName(),
                        player.getTeam(), player.getGoals(), player.getAssists(), points);
            
            
            }
        }   
    }
  
}

