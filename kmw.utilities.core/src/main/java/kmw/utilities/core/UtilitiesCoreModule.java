package kmw.utilities.core;

import com.google.inject.AbstractModule;
import kmw.utilities.core.structs.PeekingStack;
import kmw.utilities.core.structs.impl.PeekingArrayListStack;

public class UtilitiesCoreModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PeekingStack.class).to(PeekingArrayListStack.class);
    }

}
