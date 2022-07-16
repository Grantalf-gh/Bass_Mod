package net.grantalf.bassmod.entity.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ImposterVariant {
    RED(0),
    BLUE(1),
    GREEN(2),
    PINK(3),
    ORANGE(4),
    YELLOW(5),
    BLACK(6),
    WHITE(7),
    PURPLE(8),
    BROWN(9),
    CYAN(10),
    LIME(11);

    private static final ImposterVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ImposterVariant::getId)).toArray(ImposterVariant[]::new);
    private final int id;

    ImposterVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ImposterVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}