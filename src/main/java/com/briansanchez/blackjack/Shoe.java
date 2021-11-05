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

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Uses an {@link ArrayList} to hold {@value Constants#NUM_DECKS} {@link CardDeck}
 * of {@link PlayingCard}.  The total size of the ArrayList will be 
 * {@value Constants#NUM_DECKS}*{@value Constants#NUM_CARDS}
 * 
 * @author Brian Sanchez
 */
public class Shoe extends ArrayList<PlayingCard> {
    
    /**
     * Public constructor for creating the ArrayList of PlayingCard
     */
    public Shoe() {
        for (int deck=0; deck<Constants.NUM_DECKS; deck++) {
            addAll(CardDeck.newCardDeck());
        }
    }
    
    /**
     * Returns a pseudo-random card and removes it from the shoe.
     * A pseudo-random index into the Shoe is generated with the card at that
     * location returned and removed, leaving Shoe.size() smaller by one.
     * 
     * @return Pseudo-random PlayingCard from the shoe or NULL if there
     *         are no cards remaining in the shoe
     */
    public PlayingCard getNextCard() {
        if (isEmpty()) return null;
        
        // Math.random gives a value between 0 and 1
        int index = (int)(Math.random()*(size()-1));
        PlayingCard retVal = (PlayingCard) get(index);
        remove(index);
        return retVal;
            
    }

    /**
     * Internal representation of the shoe
     */
    //private static final ArrayList shoe = new ArrayList<PlayingCard>();
    /**
     * For logging messages {@link LoggingSingleton}
     */
    private static final Logger LOG = LoggingSingleton.getLogger();
    
}
