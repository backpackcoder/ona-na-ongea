package org.hammermission.onao.providers;

import android.content.UriMatcher;

/**
 * Card constants
 */

public final class FlashCard {
    /**
     * Provider authority
     */
    static final String AUTHORITY = "org.hammermission.onao.provider";
    static final String DATABASE_NAME = AUTHORITY.replace("provider", "database");

    static final String TABLE = "flashCards";
    static final String COL_ID = "_ID";
    static final String COL_ENGLISH = "ENGLISH";
    static final String COL_SWAHILI = "SWAHILI";

    static final int MATCH_ALL_ROWS = 1;
    static final String MATCH_ALL_ROWS_PATH = TABLE;
    static final String MATCH_ALL_ROWS_MIME =
            String.format("vnd.android.cursor.dir/vnd.%s.%s", AUTHORITY, TABLE);

    static final int MATCH_SINGLE_ROW = 2;
    static final String MATCH_SINGLE_ROW_PATH = String.format("%s/#", TABLE);
    static final String MATCH_SINGLE_ROW_MIME =
            String.format("vnd.android.cursor.item/vnd.%s.%s", AUTHORITY, TABLE);

    static final int MATCH_IMAGE = 3;
    static final String MATCH_IMAGE_PATH = String.format("%s/#/image", TABLE);
    static final String MATCH_IMAGE_MIME = "image/png";

    static final int MATCH_AUDIO = 4;
    static final String MATCH_AUDIO_PATH = String.format("%s/#/audio", TABLE);
    static final String MATCH_AUDIO_MIME = "audio/acc";

    public static UriMatcher GetUriMatcher() {
        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, MATCH_ALL_ROWS_PATH, MATCH_ALL_ROWS);
        matcher.addURI(AUTHORITY, MATCH_SINGLE_ROW_PATH, MATCH_SINGLE_ROW);
        matcher.addURI(AUTHORITY, MATCH_IMAGE_PATH, MATCH_IMAGE);
        matcher.addURI(AUTHORITY, MATCH_AUDIO_PATH, MATCH_AUDIO);
        return matcher;
    }

}
