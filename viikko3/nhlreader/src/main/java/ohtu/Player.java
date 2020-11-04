
package ohtu;

public class Player implements Comparable {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(Object o) {
        int myPoints = this.goals + this.assists;
        int compPoints = ((Player) o).getGoals() + ((Player) o).getAssists();
        if (myPoints > compPoints) {
            return -1;
        } else if (myPoints == compPoints) {
            return 0;
        } else {
            return 1;
        }
    }
      
}
