package message;

import az.rock.lib.message.MessageProvider;
import az.rock.ws.auth.AuthServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AuthServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class MessageProviderTest {
    @Autowired
    private MessageProvider messageProvider;

    @Test
    public void test_Json_Provider(){
        log.info("Test started");
        var message = messageProvider.fail("F_0000000001","tr");
        System.out.println(message);
        assertThat(message,true);
    }
}
