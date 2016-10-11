package org.hammermission.onao.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.net.MalformedURLException;

/**
 * Card content provider
 */

public class FlashCardProvider extends ContentProvider {
    private static final UriMatcher sUriMatcher = FlashCard.GetUriMatcher();


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case FlashCard.MATCH_ALL_ROWS:
                return FlashCard.MATCH_ALL_ROWS_MIME;
            case FlashCard.MATCH_SINGLE_ROW:
                return FlashCard.MATCH_SINGLE_ROW_MIME;
            case FlashCard.MATCH_IMAGE:
                return FlashCard.MATCH_IMAGE_MIME;
            case FlashCard.MATCH_AUDIO:
                return FlashCard.MATCH_AUDIO_MIME;
            default:
                throw new IllegalArgumentException("Unsupported uri " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }
}
