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

    @Before
    public void setup() {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn(answerString);
        answerGenerator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void should_return_Answer_object() throws OutOfRangeAnswerException {
        Answer result = answerGenerator.generate();
        assertNotNull(result);
    }
}

