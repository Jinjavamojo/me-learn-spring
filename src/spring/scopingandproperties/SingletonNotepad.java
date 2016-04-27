package spring.scopingandproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

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
@Component
@Qualifier("single")
public class SingletonNotepad implements TextProgram {

    @Autowired
    Environment environment;

    private String text;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getProperty() {
        return environment.getProperty("singletonProperty","defaultValue");
    }
    @Override
    public int getCount() {
        return environment.getProperty("count",Integer.class,0);
        //environment.getRequiredProperty() //also usable
        //environment.getActiveProfiles();
        //environment.getDefaultProfiles()
        //environment.acceptsProfiles()
    }

}
