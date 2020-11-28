package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
        
        // Tehtävä 4
        QueryBuilder query = new QueryBuilder();
 
        Matcher m = query.playsIn("NYR")
                     .hasAtLeast(5, "goals")
                     .hasFewerThan(10, "goals").build();
        
        // Tehtävä 3
        /*
        Matcher m = new And(
            new HasAtLeast(20, "points"),
            new Or( 
                new PlaysIn("NYR"),
                new PlaysIn("NYI"),
                new PlaysIn("NJD")
            )
        );
        */
        
        
        // Tehtävä 3
        /* 
        Matcher m = new Or( new HasAtLeast(20, "goals"),
                            new HasAtLeast(20, "assists")
        );
        */

        
        // Tehtävä 1
        /*
        Matcher m = new And( 
            new HasFewerThan(1, "goals"), 
            new PlaysIn("NYR")
        );

        
        Matcher m = new And( 
            new Not( new HasAtLeast(1, "goals") ), 
            new PlaysIn("NYR")
        );
        */

        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
