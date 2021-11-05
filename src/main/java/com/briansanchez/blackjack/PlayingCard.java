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

/**
 * Holds the suit and rank of an individual playing card.
 * For example, Ace of Spades
 * 
 * @author Brian Sanchez
 */
public class PlayingCard {

    /**
     * Stores the suit and rank of the playing card.
     * For example, {@link Rank#ACE} of {@link Suit#SPADES}
     * 
     * @param rank The {@link Rank} of the card, for example Rank.ACE
     * @param suit The {@link Suit} of the card, for example Suit.SPADES
     */
    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the {@link Rank} of the card, for example, Rank.KING
     * 
     * @return Rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Gets the {@link Suit} of the card, for example, Suit.HEARTS
     * 
     * @return Suit of the card
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * Gets a beautified representation of the card for print purposes
     * 
     * @return String containing the rank, suit combination suitable for output
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(rank.toString());
        sb.append(" ");
        sb.append(suit.toString());

        return sb.toString();
    }
    
    /**
     * The rank of the card, for example, King
     */
    private final Rank rank;
    /**
     * The suit of the card, for example, Hearts
     */
    private final Suit suit;
    /**
     * For logging messages {@link LoggingSingleton}
     */
    private static final Logger LOG = LoggingSingleton.getLogger();
}
