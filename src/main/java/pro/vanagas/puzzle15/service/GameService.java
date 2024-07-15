package pro.vanagas.puzzle15.service;

import org.springframework.stereotype.Service;
import pro.vanagas.puzzle15.model.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    List<String> players = new ArrayList<>();

    List<Game> games = new ArrayList<>();

    public Game createGame(int size) {
        var initialList = new ArrayList<Integer>(size * size);
        for (int i = 0; i < size * size; i++) {
            initialList.add(i + 1);
        }

        Collections.shuffle(initialList);

        Game game = new Game(createUser());
        game.setBoard(initialList);
        this.games.add(game);

        return game;
    }

    public Boolean onMove(String player, int row, int column) {
        Optional<Game> game = this.games.stream().filter(g -> g.getPlayer().getPlayerName().equals(player)).findFirst();
        Game gameToReturn = null;

        if (game.isPresent()) {
            gameToReturn = game.get();

            if (moveTile(gameToReturn, row, column))
                return isFinished(gameToReturn);
        }

        // turi būti nurodyta užduoties reikalavimuose, kaip elgtis tokiu atveju
        throw new RuntimeException("The game board for the player doesn't exist");
    }

    // algoritmas patikrina, ar pasirinktas skaičius yra toje pačioje eilutėje arba stulpelyje kaip ir tuščias langelis
    private Boolean moveTile(Game game, int row, int column) {

        // jeigu taip - pakeičia pasirinkto skaičiaus poziciją lentoje
        if (true)
            return true;
            // kitu atveju grąžina false
        else
            return false;
    }

    private String createUser() {
        String player = "player" + (players.size() + 1);
        players.add(player);
        return player;
    }

    private boolean isFinished(Game game) {
        return game.getBoard().stream().sorted().toList().equals(game.getBoard());
    }
}
