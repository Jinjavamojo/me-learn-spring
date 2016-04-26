package spring.addressing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.profilebeans.DataSource;
import spring.profilebeans.DataSourceConfig;

/**
 * Copyright 2016 LANIT group.
 * http://www.lanit.ru/
 * <p/>
 * Repository path:    $HeadURL$
 * Last committed:     $Revision$
 * Last changed by:    $Author$
 * Last changed date:  $Date$
 * ID:                 $Id$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DesertConfig.class)
public class DesertTest {

    @Autowired
    @Creamy
    private Dessert dessert;

    private Dessert anotherDessert;

    @Autowired
    @Qualifier("taste")
    protected void setAnotherDesert(Dessert desert) {
        this.anotherDessert = desert;
    }

    @Test
    public void test() {
        System.out.println(dessert.getMe());
        System.out.println(anotherDessert.getMe());
    }
}
