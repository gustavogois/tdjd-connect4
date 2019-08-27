package gois.study.tdjdconnect4;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Connect4TDDTest {
    private Connect4TDD tested;

    @Before
    public void beforeEachTest() {
        tested = new Connect4TDD();
    }
    @Test
    public void whenTheGameIsStartedTheBoardIsEmpty() {
        assertThat(tested.getNumberOfDiscs(), is(0));
    }
}
