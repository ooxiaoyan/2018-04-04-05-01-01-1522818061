package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @Before
    public void setup() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_true_when_input_is_1234() {
        String numStr = "1 2 3 4";
        Boolean result = inputValidator.validate(numStr);
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_input_is_1134() {
        String numStr = "1 1 3 4";
        Boolean result = inputValidator.validate(numStr);
        assertFalse(result);
    }

    @Test
    public void should_return_false_when_input_is_12331() {
        String numStr = "1 23 3 1";
        Boolean result = inputValidator.validate(numStr);
        assertFalse(result);
    }
}
