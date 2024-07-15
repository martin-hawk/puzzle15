package pro.vanagas.puzzle15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.vanagas.puzzle15.model.Game;
import pro.vanagas.puzzle15.service.GameService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Puzzle15ApplicationTests {

    @Autowired
    private GameService gameService;

    @Test
    void contextLoads() {
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testCreatePlayerGame(int arg) {
        Game game = gameService.createGame(4);
        assertNotNull(game);
        assertNotNull(game.getPlayer());
        assertEquals("player" + arg, game.getPlayer().getPlayerName());
    }

    @Test
    void testMoveTile() {
        Boolean isFinished = gameService.onMove("player1", 5, 6);
        assertEquals(false, isFinished);
    }

    @Test
    void testMoveTileFail() {
        try {
            Boolean isFinished = gameService.onMove("player", 5, 6);
            fail("Should throw exception");
        } catch (RuntimeException exception) {
            System.out.println("Exception caught");
        }
    }
}
