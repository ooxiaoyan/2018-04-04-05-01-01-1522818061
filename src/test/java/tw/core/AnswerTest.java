package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import static org.junit.Assert.assertNotNull;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test
    public void test_validate_should_return_void_when_input_is_correct() throws OutOfRangeAnswerException {
        String inputStr = "1 2 3 4";
        Answer answer = Answer.createAnswer(inputStr);
        answer.validate();
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void test_validate_should_return_OutOfRangeAnswerException_when_input_is_incorrect() throws OutOfRangeAnswerException {
        String exception = "Answer format is incorrect";
        String inputStr = "1 2 31 4";
        System.out.println(exception);
        Answer answer = Answer.createAnswer(inputStr);
        answer.validate();
    }

    @Test
    public void testCheck() {
        String inputStr = "1 2 3 4";
        Answer answer = Answer.createAnswer(inputStr);
        Record record = answer.check(answer);
        assertNotNull(record);
    }
}