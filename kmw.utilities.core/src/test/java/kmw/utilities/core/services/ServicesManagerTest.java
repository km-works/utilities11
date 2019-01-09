package kmw.utilities.core.services;

import kmw.utilities.core.structs.PeekingStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicesManagerTest {

    @Test
    void getSingleOrFail() {
        assertNotNull(ServicesManager.getSingleOrFail(PeekingStack.class));
    }

    @Test
    void getDefaultOrFail() {
        assertNotNull(ServicesManager.getDefaultOrFail(PeekingStack.class));
    }

    @Test
    void getNamedOrFail() {
        assertNotNull(ServicesManager.getNamedOrFail(PeekingStack.class, "PEEKING_ARRAY_LIST_STACK"));
    }

}