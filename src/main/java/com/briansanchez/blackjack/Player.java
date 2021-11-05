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
import java.util.TreeMap;

/**
 * Implements a blackjack player, storing the current hand of cards, its value
 * and determines whether the player has busted.
 * 
 * @author Brian Sanchez
 */
public class Player {

    /**
     * Private constructor to prevent instantiation without parameters
     */
    private Player() {}

    /**
     * Class constructor
     * 
     * @param shoe a reference to the card collection from which players will
     *             be dealt
     */
    public Player(Shoe shoe) {
        this.shoe = shoe;
        
        newHand();
    }
    
    /**
     * Creates a new, empty hand for the player
     */
    public final void newHand() {
        hand   = new ArrayList<PlayingCard>();
        score  = 0;
        busted = false;
        won    = false;
        hitMe  = true;
    }
    
    /**
     * Returns a beautified String describing the player's hand
     * 
     * @return String containing the player hand suitable for output
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Player hand: ");
        int cardnum = 0;
        for (var card:hand) {
            if (cardnum++ > 0) {
                sb.append(", ");
            }
            sb.append(card.toString());
        }
        sb.append(" = ");
        sb.append(getScore());
        
        return sb.toString();
    }
    
    /**
     * Draws a card from the shoe
     */
    public void draw() {
        if ((shoe==null) || (shoe.isEmpty() || (!hitMe))) return;

        // Get the next card from the shoe and add it to the player's hand
        PlayingCard temp = shoe.getNextCard();
        hand.add(temp);
        
        // Calculate the value of the player's hand
        Rank rank = temp.getRank();
        if ((score + rank.value()) > Constants.WIN_VALUE) {
            // if this card made me bust, make sure it isn't an ace
            if (rank.altValue() != Constants.NO_VALUE) {
                score += rank.altValue();
            } else {
                score += rank.value();
            }
        } else {
            score += rank.value();
        }
        busted = (score > Constants.WIN_VALUE);
        
        // Determine whether the player will hit on the next turn
        setHitMe();
    }
    
    /**
     * Determines whether the player will hit on the next turn.
     */
    public void setHitMe() {
        hitMe = (!busted) && (score < Constants.HIT_VALUE);
        //LOG.info("\tPlayer Hit? "+hitMe+"\tbust? "+isBusted()+"\twon? "+isWon());
    }
    
    /**
     * Returns true if the player will hit on the next turn
     * 
     * @return true if the player will draw another card on the next turn
     */
    public boolean isHitMe() {
        return hitMe;
    }
    
    /**
     * Returns the score of the player's current hand
     * 
     * @return score of the player's current hand
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Returns true if the value of the player's hand is greater than 
     * {@value Constants#WIN_VALUE}
     * 
     * @return true if the player has busted, meaning the value of the player's
     * hand is greater than Constants.WIN_VALUE
     */
    public boolean isBusted() {
        return busted;
    }
    
    /**
     * Updates the player win statistics
     */
    public void setWon() {
        won = true;
        
        // Generate stats for player wins
        winCount++;
        if (winStats.get(score) == null) {
            winStats.put(score, 1);
        } else {
            winStats.put(score, ((Integer)winStats.get(score))+1);
        }
    }
    
    /**
     * Getter for the player's win count
     * 
     * @return int containing the number of games the player has won
     */
    public int getWinCount() {
        return winCount;
    }
    
    /**
     * Provides access to the player win statistics
     * 
     * @return TreeMap containing the win count indexed by the hand score
     */
    public final TreeMap<Integer, Integer> getWinStats() {
        return winStats;
    }
    
    /**
     * Returns the player win status for this hand
     * 
     * @return true if the player has won this hand
     */
    public boolean isWon() {
        return won;
    }
    
    /**
     * True indicates that the player has won this hand
     */
    protected boolean won = false;
    
    /**
     * Maintains a count of the hands the player has won
     */
    private static int winCount = 0;
    
    /**
     * Stores the count of wins indexed by the value of the winning hand
     */
    protected static TreeMap winStats = new TreeMap<Integer, Integer>();
            
    /**
     * True indicates that the value of the player's hand is greater than
     * {@value Constants#WIN_VALUE}
     */
    protected boolean busted = false;
    
    /**
     * True indicates that the player will draw another card on the next
     * turn, that is, the player will hit.
     */
    protected boolean hitMe = true;
    
    /**
     * Internal representation of the player's current hand of cards
     */
    protected ArrayList hand = new ArrayList<PlayingCard>();
    
    /**
     * Total score of the player's current hand
     */
    protected int score = 0;
    
    /**
     * A reference to the shoe, a collection of cards from which players
     * will be dealt
     */
    protected Shoe shoe = null;
    
    /**
     * For logging messages {@link LoggingSingleton}
     */
    private static final Logger LOG = LoggingSingleton.getLogger();
}
