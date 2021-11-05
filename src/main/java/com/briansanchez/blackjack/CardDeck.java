//<editor-fold defaultstate="collapsed" desc="License Information">
/*
 * Copyright 2021 Brian Sanchez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//</editor-fold>
package com.briansanchez.blackjack;

import java.util.logging.Logger;
import java.util.ArrayList;

/**
 * Uses an {@link ArrayList} to hold a standard deck of 52 {@link PlayingCard}.
 * The constructor is private; Use the factory method @see #newCardDeck
 * 
 * @author Brian Sanchez
 */
public abstract class CardDeck {
    
    /**
     * CardDeck is abstract.  Use the factory method @see #newCardDeck
     */
    private CardDeck() {}
    
    /**
     * The factory method for creating a new deck of cards
     * 
     * @return ArrayList of {@link PlayingCard} containing
     *         {@value Constants#NUM_CARDS} cards
     */
    public static ArrayList<PlayingCard> newCardDeck() {
        ArrayList deck = new ArrayList<PlayingCard>(Constants.NUM_CARDS);
        for (Suit s : Suit.values()) {
            for (Rank r: Rank.values()) {
                deck.add(new PlayingCard(r, s));
            }
        }
        return deck;
    }

    /**
     * For logging messages {@link LoggingSingleton}
     */
    private static final Logger LOG = LoggingSingleton.getLogger();    
}
