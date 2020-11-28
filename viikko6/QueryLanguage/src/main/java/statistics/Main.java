package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
        
        // Tehtävä 4
        QueryBuilder query = new QueryBuilder();
 
        Matcher m1 = query.playsIn("PHI")
                    .hasAtLeast(10, "assists")
                    .hasFewerThan(8, "goals").build();

        Matcher m2 = query.playsIn("NYR")
                    .hasAtLeast(10, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

        
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
