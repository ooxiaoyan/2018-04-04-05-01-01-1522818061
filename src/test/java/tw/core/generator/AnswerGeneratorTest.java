package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    private AnswerGenerator answerGenerator;
    private String answerString = "1 2 3 4";
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup() {
        randomIntGenerator = mock(RandomIntGenerator.class);
    }

    @Test
    public void test_generate_should_return_Answer_object() throws OutOfRangeAnswerException {
        when(randomIntGenerator.generateNums(9, 4)).thenReturn(answerString);
        answerGenerator = new AnswerGenerator(randomIntGenerator);
        Answer result = answerGenerator.generate();
        assertNotNull(result);
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void test_generate_should_throw_OutOfRangeAnswerException_when_the_number_is_not_between_0_and_9() throws OutOfRangeAnswerException {
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("3 15 3 9");
        answerGenerator = new AnswerGenerator(randomIntGenerator);
        answerGenerator.generate();
    }
}

