import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.Entity.DTO.StandingDTO;
import org.sapient.FootballMainApplication;
import org.sapient.controller.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FootballMainApplication.class)
public class FootballTest {

    @Autowired
    RestController restController;

    @Test
    public void testFootballRank() throws Exception {

        StandingDTO standingDTO=restController.getResponse("Argentina","Primera C","Dep. Merlo");
        Assert.assertEquals(standingDTO.getOverallLeaguePosition(),"1");
    }

}
