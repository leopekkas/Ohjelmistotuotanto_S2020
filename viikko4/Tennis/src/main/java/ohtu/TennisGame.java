package ohtu;

public class TennisGame {
    
    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1.incrementPoints();
        } else { 
            player2.incrementPoints();
        }
    }

    public String getScore() {
        String score;
       
        int player1Points = player1.getPoints();
        int player2Points = player2.getPoints();
        
        if (player1Points == player2Points) {
            score = equalScoreString(player1Points);
        } else if (player1Points >= 4 || player2Points >= 4) {
            score = advantageScoreString(player1Points, player2Points);
        } else {
            score = scoreString(player1Points, player2Points);
        }
        return score;
    }
    
    public String singleScoreString(int points) {
        if (points == 0) {
            return "Love";
        } else if (points == 1) {
            return "Fifteen";
        } else if (points == 2) {
            return "Thirty";
        } else {
            return "Forty";
        }
    }
    
    public String scoreString (int player1Points, int player2Points) {
        String scoreStr;
        
        String player1Score = singleScoreString(player1Points);
        String player2Score = singleScoreString(player2Points);
        
        scoreStr = player1Score + "-" + player2Score;
        
        return scoreStr;  
    }
    
    public String equalScoreString(int score) {
        String scoreStr;
        if (score > 3) {
            return "Deuce";
        }
        
        scoreStr = singleScoreString(score) + "-All";

        return scoreStr;
    }
    
    public String advantageScoreString(int player1Points, int player2Points) {
        String scoreStr;
        
        // How many points is player 1 ahead of player 2
        int player1Lead = player1Points - player2Points;
        
        if (player1Lead == 1) {
            scoreStr ="Advantage player1";
        } else if (player1Lead >= 2) {
            scoreStr = "Win for player1";
        } else if (player1Lead == -1) {
            scoreStr ="Advantage player2";
        } else {
            scoreStr ="Win for player2";
        }
        
        return scoreStr;
    }
}