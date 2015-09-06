package cn.com.rexen.example.sequoiadb;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmaia on 2/11/15.
 */

public class compareTest {


    @Test
    public void ShouldMatchEqualObjects() {
        Airport base = new Airport();
        base.setId(1);
        base.setCity("BH");
        base.setName(new AirportName("name", "n"));

        Airport working = new Airport();
        working.setId(2);
        working.setCity("BH");
        working.setName(new AirportName("name", "n"));


        Assert.assertTrue(Matcher.Match(base, working));
    }

    @Test
    public void ShouldNotMatchDifferentObjects() {
        Airport base = new Airport();
        base.setId(1);
        base.setCity("BH1");
        base.setName(new AirportName("name", "n2"));

        Airport working = new Airport();
        working.setId(1);
        working.setCity("BH");
        working.setName(new AirportName("name2", "n"));

        Assert.assertFalse(Matcher.Match(base, working));

    }

    @Test
    public void ShouldMatchEqualObjectsWithDifferentId() {
        Airport base = new Airport();
        base.setId(1);
        base.setCity("BH");
        base.setName(new AirportName("name", "n"));

        Airport working = new Airport();
        working.setId(2);
        working.setCity("BH");
        working.setName(new AirportName("name", "n"));

        Assert.assertTrue(Matcher.Match(base, working));
    }


}
