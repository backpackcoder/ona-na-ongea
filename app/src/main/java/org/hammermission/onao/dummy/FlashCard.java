package org.hammermission.onao.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 10/9/16.
 */

public class FlashCard {
    public static final List<FlashCard> LIST = new ArrayList<FlashCard>();
    public static final Map<String, FlashCard> MAP = new HashMap<String, FlashCard>();

    public final String kiiswahili;
    public final String english;
    public final String audioResourceId;
    public final String imageResourceId;

    static {
        LIST.add(new FlashCard("parachichi","alvocado"));
        LIST.add(new FlashCard("tikiti","watermelon"));
        LIST.add(new FlashCard("embe","mango"));
        LIST.add(new FlashCard("chungwa","orange"));
        LIST.add(new FlashCard("nanasi","pineapple"));
        LIST.add(new FlashCard("limao","lemon"));
        LIST.add(new FlashCard("tango","cucumber"));
        LIST.add(new FlashCard("ndizi","banana"));
        LIST.add(new FlashCard("chenza","tangerine"));
        LIST.add(new FlashCard("epul","apple"));
        LIST.add(new FlashCard("kiazi","potatoe"));
        LIST.add(new FlashCard("kitunguu saumu","garlic"));
        LIST.add(new FlashCard("karoti","carrot"));
        LIST.add(new FlashCard("nyanya","tomatoe"));
        LIST.add(new FlashCard("kabichi","cabbage"));
        LIST.add(new FlashCard("njegere","peas"));
        LIST.add(new FlashCard("bilinganya","egg plant"));
        LIST.add(new FlashCard("kitugnuu","onion"));
        LIST.add(new FlashCard("pilipili","pepper"));
        LIST.add(new FlashCard("zabibu","grapes"));
        LIST.add(new FlashCard("maziwa","milk"));
        LIST.add(new FlashCard("wali","rice"));

        for (FlashCard card: LIST) {
            MAP.put(card.kiiswahili, card);
        }
    }

    public FlashCard(String kiiswahili, String english) {
        this.kiiswahili = kiiswahili;
        this.english = english;
        this.audioResourceId = String.format("{0}-{1}.mp3", kiiswahili, english);
        this.imageResourceId = String.format("{0}-{1}.png", kiiswahili, english);
    }
}
