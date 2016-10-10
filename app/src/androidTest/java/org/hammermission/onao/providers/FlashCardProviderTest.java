package org.hammermission.onao.providers;

import android.content.UriMatcher;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit test for FlashCardProvider
 */
@RunWith(AndroidJUnit4.class)
public class FlashCardProviderTest extends ProviderTestCase2<FlashCardProvider> {
    /**
     * Constructor.
     *
     * @param providerClass     The class name of the provider under test
     * @param providerAuthority The provider's authority string
     */
    public FlashCardProviderTest(Class<FlashCardProvider> providerClass, String providerAuthority) {
        super(providerClass, providerAuthority);
    }

    @Override
    protected void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
    }


    /**
     * Tests the FlashCardProvider's URI matcher
     */
    @Test
    public void testUriMatcher() throws Exception {
        UriMatcher matcher = FlashCard.GetUriMatcher();
        checkUris(matcher, TestData.URIS_BAD, -1);
        checkUris(matcher, TestData.URIS_ONE_ROW, FlashCard.MATCH_SINGLE_ROW);
        checkUris(matcher, TestData.URI_ALL_ROWS, FlashCard.MATCH_ALL_ROWS);
        checkUris(matcher, TestData.URIS_IMAGES, FlashCard.MATCH_IMAGE);
        checkUris(matcher, TestData.URIS_AUDIO, FlashCard.MATCH_AUDIO);
    }
    //Tests matching an Array of URIs against an expected result
    private static void checkUris(UriMatcher matcher, String[] uris, int expected) {
        for (String uri : uris) {
            Assert.assertEquals("Failed for " + uri,
                    expected, matcher.match(Uri.parse(uri)));
        }
    }

}
