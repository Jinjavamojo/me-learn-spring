package spring.scopingandproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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
@Qualifier("proto")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Notepad implements TextProgram {

    private String ownText;

    @Autowired
    Environment environment;

    @Override
    public String getText() {
        return ownText;
    }

    @Override
    public void setText(String text) {
        ownText = text;

    }

    @Override
    public String getProperty() {
        return environment.getProperty("protoProperty");
    }

    @Override
    public int getCount() {
        return environment.getProperty("count",Integer.class,0);
    }
}
