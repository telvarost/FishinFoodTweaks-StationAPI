package com.github.telvarost.fishinfoodtweaks;

import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ModHelper {

    //public static final Namespace NAMESPACE = Namespace.resolve();
    @Entrypoint.Namespace
    public static Namespace NAMESPACE = Null.get();

    public static class ModHelperFields {
        public static Boolean IS_RAW_FISH_CONSUMED = false;
        public static Integer COOKED_RAW_FISH_TYPE = -1;
        public static Integer COOKED_RAW_FISH_SIZE = 0;
    }
}
