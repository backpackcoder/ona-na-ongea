package org.hammermission.onao.dummy;

import org.hammermission.onao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 10/9/16.
 */

public class Card {
    public static final List<Card> LIST = new ArrayList<Card>();
    public static final Map<String, Card> MAP = new HashMap<String, Card>();

    public final String kiiswahili;
    public final String english;
    public final int audioResourceId;
    public final int imageResourceId;

    static {
        LIST.add(new Card("parachichi","avocado", R.drawable.avocado, R.raw.avocado));
        LIST.add(new Card("tikiti","watermelon", R.drawable.watermellon, R.raw.watermellon));
        LIST.add(new Card("nanasi","pineapple", R.drawable.pineapple, R.raw.pineapple));
        LIST.add(new Card("limao","lemon", R.drawable.lemon, R.raw.lemon));
        LIST.add(new Card("ndizi","banana", R.drawable.banana, R.raw.banana));
        LIST.add(new Card("epul","apple", R.drawable.apple, R.raw.apple));
        LIST.add(new Card("kiazi","potato", R.drawable.potato, R.raw.potato));
        LIST.add(new Card("karoti","carrot", R.drawable.carrot, R.raw.carrot));
        LIST.add(new Card("nyanya","tomato", R.drawable.tomato, R.raw.tomato));
        LIST.add(new Card("kabichi","cabbage", R.drawable.cabbage, R.raw.cabbage));
        LIST.add(new Card("njegere","peas", R.drawable.peas, R.raw.peas));
        LIST.add(new Card("kitugnuu","onion", R.drawable.onion, R.raw.onion));
        LIST.add(new Card("pilipili","pepper", R.drawable.pepper, R.raw.pepper));
        LIST.add(new Card("zabibu","grapes", R.drawable. grapes, R.raw.grape));

        for (Card card: LIST) {
            MAP.put(card.kiiswahili, card);
        }
    }

    public Card(String kiiswahili, String english, int imageId, int soundId) {
        this.kiiswahili = kiiswahili;
        this.english = english;
        this.audioResourceId = soundId;
        this.imageResourceId = imageId;
    }
}
