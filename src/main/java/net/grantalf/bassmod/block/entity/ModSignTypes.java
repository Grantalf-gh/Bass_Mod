package net.grantalf.bassmod.block.entity;

import net.grantalf.bassmod.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class ModSignTypes {
    public static final SignType EBONY =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("ebony"));
}