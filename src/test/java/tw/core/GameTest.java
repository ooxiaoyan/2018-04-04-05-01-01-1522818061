package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */

public class GameTest {

    private Answer inputAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setup() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(inputAnswer);
        game = new Game(answerGenerator);

    }

    @Test
    public void test_guess() throws OutOfRangeAnswerException {
        GuessResult guessResult = game.guess(inputAnswer);
        assertNotNull(guessResult);
    }

    @Test
    public void test_checkCorrectGuessResult_should_return_continue() throws Exception {
        game.guess(Answer.createAnswer("1 5 6 7"));
        String result = game.checkStatus();
        assertThat(result, is("continue"));
    }

    @Test
    public void test_checkCorrectGuessResult_should_return_success() throws Exception {
        game.guess(Answer.createAnswer("1 5 6 7"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        String result = game.checkStatus();
        assertThat(result, is("success"));
    }

    @Test
    public void test_checkCorrectGuessResult_should_return_fail() throws Exception {
        game.guess(Answer.createAnswer("1 3 5 7"));
        game.guess(Answer.createAnswer("1 2 5 7"));
        game.guess(Answer.createAnswer("1 2 3 7"));
        game.guess(Answer.createAnswer("1 3 4 7"));
        game.guess(Answer.createAnswer("1 3 6 7"));
        game.guess(Answer.createAnswer("1 3 4 9"));
        String result = game.checkStatus();
        assertThat(result, is("fail"));
    }
}
