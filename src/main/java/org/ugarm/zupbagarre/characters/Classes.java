package org.ugarm.zupbagarre.characters;

import java.util.Set;

public final class Classes {
    public static final String WIZARD = "Wizard";
    public static final String INBRED = "Inbred";
    public static final String CHAV = "Chav";
    public static final String POLICEMAN = "Policeman";

    private Classes() {};

    public static final Set<String> VALID_CLASSES = Set.of(WIZARD, INBRED, CHAV, POLICEMAN);

}