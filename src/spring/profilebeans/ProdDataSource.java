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
public class ProdDataSource implements DataSource {

    @Override
    public String getConnString() {
        return "real 146% address. i swear";
    }
}
