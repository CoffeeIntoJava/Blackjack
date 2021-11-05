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

/**
 * Enumeration class to hold the card ranks and value(s).  Only ACE has two
 * values, all others use {@link Constants#NO_VALUE} to denote the lack of 
 * an alternate value.
 * 
 * @author Brian Sanchez
 */
public enum Rank {
    ACE   ("Ace",   11, 1),
    ONE   ("One",    1, Constants.NO_VALUE),
    TWO   ("Two",    2, Constants.NO_VALUE),
    THREE ("Three",  3, Constants.NO_VALUE),
    FOUR  ("Four",   4, Constants.NO_VALUE),
    FIVE  ("Five",   5, Constants.NO_VALUE),
    SIX   ("Six",    6, Constants.NO_VALUE),
    SEVEN ("Seven",  7, Constants.NO_VALUE),
    EIGHT ("Eight",  8, Constants.NO_VALUE),
    NINE  ("Nine",   9, Constants.NO_VALUE),
    TEN   ("Ten",   10, Constants.NO_VALUE),
    JACK  ("Jack",  10, Constants.NO_VALUE),
    QUEEN ("Queen", 10, Constants.NO_VALUE),
    KING  ("King",  10, Constants.NO_VALUE);
    
    // The printable rank of the card
    private final String prettyRank;
    // The value of the card rank
    private final int value1;
    // The alternate value of the rank, or Constants.NO_VALUE if none
    private final int value2;
    
    /**
     * Private constructor to link values to the given Rank
     * 
     * @param value1 Value of the rank
     * @param value2 Alternate value of the rank or Constants.NO_VALUE if none
     */
    private Rank(String prettyRank, int value1, int value2) {
        this.prettyRank = prettyRank;
        this.value1 = value1;
        this.value2 = value2;
    }
    
    /**
     * Returns the value of the given rank
     * 
     * @return int value of the rank
     */
    public int value() {
        return this.value1;
    }
    
    /**
     * Returns the alternate value of the given rank
     * Note: Only ACE has two values, all others return Constants.NO_VALUE
     * 
     * @return int alternate value of the rank, or Constants.NO_VALUE
     */
    public int altValue() {
        return this.value2;
    }
    
    /**
     * Returns the beautified rank, suitable for output
     * 
     * @return String containing the rank, formatted for output
     */
    @Override
    public String toString() {
        return this.prettyRank;
    }
}
