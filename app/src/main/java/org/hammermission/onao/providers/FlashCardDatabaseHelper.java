package org.hammermission.onao.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrew on 10/9/16.
 */
public class FlashCardDatabaseHelper extends SQLiteOpenHelper {

    public FlashCardDatabaseHelper(Context context) {
        super(context, FlashCard.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE {0} (" +
                "{1} INTEGER PRIMARY KEY, " +
                "{2} TEXT, " +
                "{3} TEXT )", FlashCard.TABLE,
                FlashCard.COL_ID, FlashCard.COL_ENGLISH, FlashCard.COL_SWAHILI));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new IllegalArgumentException("Only 1 version");
    }
}
