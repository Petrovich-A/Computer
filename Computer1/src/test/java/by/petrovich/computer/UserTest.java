package by.petrovich.computer;

import junit.framework.TestCase;
import org.junit.Assert;

public class UserTest extends TestCase {

    public void testIncreaseAge() {
        User user = new User(20);
        int expected = user.increaseAge(5);
        int actual = user.getAge();
        Assert.assertEquals(expected, actual);
    }
}