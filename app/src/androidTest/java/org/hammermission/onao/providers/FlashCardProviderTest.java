package org.hammermission.onao.providers;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;
import android.test.mock.MockContentResolver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit test for FlashCardProvider
 */
@RunWith(AndroidJUnit4.class)
public class FlashCardProviderTest extends ProviderTestCase2<FlashCardProvider> {
    public FlashCardProviderTest() {
        super(FlashCardProvider.class, FlashCard.AUTHORITY);
    }

    private MockContentResolver mContentResolver;

    @Before
    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        mContentResolver = this.getMockContentResolver();
    }

    @Test
    public void testGetType() throws Exception {
        //checkUris(matcher, TestData.URIS_BAD, -1);
        checkUris(TestData.URIS_ONE_ROW, FlashCard.MATCH_SINGLE_ROW_MIME);
        checkUris(TestData.URI_ALL_ROWS, FlashCard.MATCH_ALL_ROWS_MIME);
        checkUris(TestData.URIS_IMAGES, FlashCard.MATCH_IMAGE_MIME);
        checkUris(TestData.URIS_AUDIO, FlashCard.MATCH_AUDIO_MIME);
    }
    //Tests matching an Array of URIs against an expected result
    private void checkUris(String[] uris, String expectedMimeType) {
        for (String uri : uris) {
            String mimeType = mContentResolver.getType(Uri.parse(uri));
            Assert.assertEquals("Failed for " + uri, expectedMimeType, mimeType);
        }
    }

}
