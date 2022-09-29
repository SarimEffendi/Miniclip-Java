package model;

public class Cricketers {
    private String name;
    private int record;
    private int score;
    private boolean batting;

    public Cricketers(String name, int record, int score, boolean batting)throws Exception{
        this.name = name;
        this.record = record;
        this.score = score;
        this.batting = batting;
    }
    public String toString(){
        return "Name: " + name + ", Record: "+ record;
    }
    public boolean isBatting()throws Exception {
        return batting;
    }

    public void setBatting(boolean batting)throws Exception {
        this.batting = batting;
    }

    public String getName()throws Exception {
        return name;
    }

    public void setName(String name)throws Exception {
        this.name = name;
    }

    public int getScore()throws Exception {
        return score;
    }

    public void setScore(int score)throws Exception {
        this.score = score;
    }

    public int getRecord()throws Exception {
        return record;
    }

    public void setRecord(int record)throws Exception {
        this.record = record;
    }
}
