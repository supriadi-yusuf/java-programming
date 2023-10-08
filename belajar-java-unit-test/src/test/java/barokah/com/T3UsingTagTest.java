package barokah.com;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

// @Tag is annotation to group tests. so we can run only several groups of tests if we do not want to run all test
// All method inherits this tag. Use @Tags if more than one tag.
// run test : mvn test -Dgroups=tag1,tag2

/*@Tags({
        @Tag("integration-test")
})*/
@Tag("integration-test")
public class T3UsingTagTest {

    @Test
    public void test1(){}

    @Test
    public void test2(){}
}
