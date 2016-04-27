package spring.scopingandproperties;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@ContextConfiguration(classes = Config.class)
public class Test {

    @Autowired
    @Qualifier("proto")
    private TextProgram notepad1;

    @Autowired
    @Qualifier("proto")
    private TextProgram notepad2;


    @Autowired
    @Qualifier("single")
    private TextProgram s1;

    @Autowired
    @Qualifier("single")
    private TextProgram s2;


    @org.junit.Test
    public void test() {
        notepad1.setText("a");
        notepad2.setText("b");
        Assert.assertNotEquals(notepad1.getText(), notepad2.getText());
        //s1 and s2 is same object
        s1.setText("a");
        s2.setText("b");
        Assert.assertEquals(s1.getText(), s2.getText());
        System.out.println(notepad1.getProperty());
        System.out.println(s1.getProperty());
        System.out.println(s1.getCount());
    }

}
