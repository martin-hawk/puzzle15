package pro.vanagas.puzzle15.model;

import java.util.List;

public class Game {

    private Player player;

    private List<Integer> board;

    public Game(String player) {
        this.player = new Player(player);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Integer> getBoard() {
        return board;
    }

    public void setBoard(List<Integer> board) {
        this.board = board;
    }
}
