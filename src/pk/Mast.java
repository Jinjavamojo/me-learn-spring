package pk;

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
public enum Mast {
    CHERVI(0),
    BUBI(1000),
    PIKI(2000),
    KRESTI(3000);

    int value;

    Mast(int value) {
        this.value = value;
    }
}
