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

import java.util.logging.Level;

/**
 *
 * @author Brian Sanchez
 */
public class Constants {
    
    /**
     * Private constructor since this class is not intended to be instantiated
     */
    private Constants() {}

    /**
     * The shoe contains {@value #NUM_DECKS} decks of cards
     */
    public static final int NUM_DECKS = 6;

    /**
     * A standard deck contains {@value #NUM_CARDS} playing cards
     */
    public static final int NUM_CARDS = 52;
    
    /**
     * This signifies that there is no alternate value for the card
     */
    public static final int NO_VALUE = Integer.MIN_VALUE;
    
    /**
     * The goal of blackjack is to reach this value without going over
     */
    public static final int WIN_VALUE = 21;
    
    /**
     * If a player's hand is less than this value, the player must hit
     */
    public static final int HIT_VALUE = 16;
    
    /**
     * If the dealer's hand is less than this value, the dealer must hit
     */
    public static final int DEALER_HIT_VALUE = 21;
    
    /**
     * These are the default output levels and formats for
     * {@link LoggingSingleton}
     * 
     * Changing DEBUG_OUTPUT to true changes the logger output to ALL
     */
    public static final boolean DEBUG_OUTPUT    = false;
    public static final Level   OUTPUT          = Level.INFO;
    public static final Level   DEBUG           = Level.ALL;
    /**
     * Emulates System.out.println(...)
     */
    public static final String LOG_FORMAT       = "%5$s%n";
    /**
     * Adds the time and other information to the log output
     */
    public static final String LOG_FORMAT_DEBUG = 
        "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s %2$s%n%5$s %6$s%n";
}
