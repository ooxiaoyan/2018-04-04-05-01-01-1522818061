package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.views.GameView;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    private GameController gameController;

    @Mock
    private Game game;
    @Mock
    private GameView gameView;
    @Mock
    private InputCommand inputCommand;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_beginGame() throws IOException {
        gameController = new GameController(game, gameView);
        gameController.beginGame();
        verify(gameView).showBegin();
    }

    @Test
    public void test_play_show_results_when_checkCoutinue_is_false() throws IOException {
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 6 3 4"));
        when(game.checkCoutinue()).thenReturn(false);
        when(game.checkStatus()).thenReturn("fail");
        GameController gameController = new GameController(game, gameView);
        gameController.play(inputCommand);
        verify(gameView).showGameStatus(anyString());
    }
}