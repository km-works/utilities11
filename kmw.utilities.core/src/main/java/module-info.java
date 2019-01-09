open module kmw.utilities.core {
    requires com.google.guice;  // is MultiBinder included??
    requires com.google.common;
    requires jsr305;

    exports kmw.utilities.core;
    exports kmw.utilities.core.strings;
    exports kmw.utilities.core.structs;

    provides com.google.inject.AbstractModule with kmw.utilities.core.UtilitiesCoreModule;
    provides kmw.utilities.core.structs.PeekingStack with kmw.utilities.core.structs.impl.PeekingArrayListStack;

    uses    kmw.utilities.core.structs.PeekingStack;
}