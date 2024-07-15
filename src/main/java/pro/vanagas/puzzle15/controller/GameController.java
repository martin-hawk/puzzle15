package pro.vanagas.puzzle15.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.vanagas.puzzle15.model.Game;
import pro.vanagas.puzzle15.service.GameService;

@RestController
@RequestMapping("games")
public class GameController {

    private static final Log logger = LogFactory.getLog(GameController.class);

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // http://localhost:8080/puzzle-api/games
    @PostMapping
    public Game newGame() {
        var game = gameService.createGame(4);
        logger.info(game.getPlayer() + " got board with numbers: " + game.getBoard());
        return game;
    }

    // http://localhost:8080/puzzle-api/games/player1/2/3
    @PutMapping("/{player}/{row}/{column}")
    public Boolean onMove(@PathVariable String player, @PathVariable int row, @PathVariable int column) {
        var result = gameService.onMove(player, row, column);
        logger.info("Player: " + player + " made a move with coordinates: " + "Row: " + row + " Column: " + column +
                " and did " + (result ? "WIN" : "NOT WIN"));

        // jeigu išmetama klaida, reikėtų ją apdoroti front-end ir parodyti aiškų pranešimą naudotojui
        return result;
    }
}
