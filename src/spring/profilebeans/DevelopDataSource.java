package spring.profilebeans;

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
public class DevelopDataSource implements DataSource {

    @Override
    public String getConnString() {
        return "develop localhost";
    }
}
