package kbo;

class Player {
    private String playerName; //선수 이름
    private String playerTeam; //선수 팀
    private String playerType; //선수 유형 (투수, 포수 등)

    Player(String playerName, String playerTeam, String playerType){
        this.playerName=playerName;
        this.playerTeam=playerTeam;
        this.playerType=playerType;
    }

    String getPlayerName() {return playerName;}
    String getPlayerTeam() {return playerTeam;}
    String getPlayerType() {return playerType;}
}