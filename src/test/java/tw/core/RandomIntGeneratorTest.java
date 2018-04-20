package tw.core;


import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;
import tw.validator.InputValidator;

import static org.junit.Assert.assertTrue;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    private RandomIntGenerator randomIntGenerator;
    private InputValidator inputValidator;

    @Before
    public void setup() {
        randomIntGenerator = new RandomIntGenerator();
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_four_distinct_int_less_than_9() {
        String result = randomIntGenerator.generateNums(9,4);
        assertTrue(inputValidator.validate(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_IllegalArgumentException_when_digitmax_greater_than_numbersOfNeed() {
        String exception = "Can't ask for more numbers than are available";
        System.out.println(exception);
        randomIntGenerator.generateNums(3,4);
    }
}