package anton.potemkin.spring.message;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Anton Potemkin on 26/05/2018.
 */
@ContextConfiguration("classpath:spring/message-bean.xml")
@RunWith(SpringRunner.class)
public class MessageSpringTest {
    @Autowired
    private Message message;

    @Test
    public void getMessageTest() {
        Assert.assertEquals(message.getMessage(), "This is message from simple bean.");
    }
}
