package org.hammermission.onao.providers;

/**
 * Test Data for unit tests
 */

public final class  TestData {
    public static final String[] URIS_BAD = {
            "content://com.example.app/flashCard",
            "content://org.hammermission.onao.provider/card",
            "content://org.hammermission.onao.provider/flashCards/23/picture",
            "content://org.hammermission.onao.provider/flashCards/-23",
            "content://org.hammermission.onao.provider/flashCards/image"
    };

    public static final String[] URI_ALL_ROWS = {
            "content://org.hammermission.onao.provider/flashCards"
    };

    public static final String[] URIS_ONE_ROW = {
            "content://org.hammermission.onao.provider/flashCards/23",
            "content://org.hammermission.onao.provider/flashCards/2",
            "content://org.hammermission.onao.provider/flashCards/631",
            "content://org.hammermission.onao.provider/flashCards/0"
    };

    public static final String[] URIS_IMAGES = {
            "content://org.hammermission.onao.provider/flashCards/3/image",
            "content://org.hammermission.onao.provider/flashCards/23/image",
            "content://org.hammermission.onao.provider/flashCards/1/image"
    };

    public static final String[] URIS_AUDIO = {
            "content://org.hammermission.onao.provider/flashCards/3/audio",
            "content://org.hammermission.onao.provider/flashCards/23/audio",
            "content://org.hammermission.onao.provider/flashCards/1/audio"
    };
}
