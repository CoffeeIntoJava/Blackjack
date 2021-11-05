//<editor-fold defaultstate="collapsed" desc="License Information">
/*
 * Copyright 2021 Brian Sanchez.
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
 * The Dealer class is a special type of {@link Player} who must draw until
 * (all) Player hands are beaten or the Dealer busts 
 * (hand value &gt; {@value Constants#WIN_VALUE}
 * 
 * @author Brian Sanchez
 */
public class Dealer extends Player {
    
    /**
     * Class constructor
     * 
     * @param shoe the collection of cards from which players will be dealt
     */
    public Dealer(Shoe shoe) {
        super(shoe);
    }

    /**
     * Determines whether the dealer will hit on the next turn.
     */
    @Override
    public void setHitMe() {
        hitMe = (!busted) && (score < Constants.DEALER_HIT_VALUE);
        //LOG.info("\tDealer Hit? "+hitMe+"\tbust? "+isBusted()+"\twon? "+isWon());
    }
    
    /**
     * Updates the player win statistics
     */
    @Override
    public void setWon() {
        won = true;
    }
    
    
    /**
     * Returns a beautified String describing the player's hand
     * 
     * @return String containing the player hand suitable for output
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dealer hand: ");
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
     * For logging messages {@link LoggingSingleton}
     */
    private static final Logger LOG = LoggingSingleton.getLogger();    
}
