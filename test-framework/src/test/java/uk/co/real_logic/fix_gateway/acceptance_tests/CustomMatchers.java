package uk.co.real_logic.fix_gateway.acceptance_tests;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;
import static uk.co.real_logic.fix_gateway.system_tests.SystemTestUtil.ACCEPTOR_ID;
import static uk.co.real_logic.fix_gateway.system_tests.SystemTestUtil.INITIATOR_ID;

public final class CustomMatchers
{
    public static <T> Matcher<Iterable<? super T>> containsInitiator()
    {
        return containsLogon(ACCEPTOR_ID, INITIATOR_ID);
    }

    public static <T> Matcher<Iterable<? super T>> containsAcceptor()
    {
        return containsLogon(INITIATOR_ID, ACCEPTOR_ID);
    }

    private static <T> Matcher<Iterable<? super T>> containsLogon(final String senderCompId, final String targetCompId)
    {
        return hasItem(
            allOf(hasSenderCompId(senderCompId),
                hasTargetCompId(targetCompId)));
    }

    private static <T> Matcher<T> hasTargetCompId(final String targetCompId)
    {
        return hasProperty("targetCompID", equalTo(targetCompId));
    }

    private static <T> Matcher<T> hasSenderCompId(final String senderCompId)
    {
        return hasProperty("senderCompID", equalTo(senderCompId));
    }


}
