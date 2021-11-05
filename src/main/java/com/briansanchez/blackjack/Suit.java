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
 * Enumeration class to hold the card suits
 * 
 * @author Brian Sanchez
 */
public enum Suit {
    HEARTS   ("Hearts"),
    SPADES   ("Spades"),
    DIAMONDS ("Diamonds"),
    CLUBS    ("Clubs");
    
    // Stores the output-friendly version of the suit
    private final String prettySuit;

    /**
     * Private constructor that ties the suit value to the output-friendly
     * version
     * 
     * @param prettySuit String representation of the suit, for output
     */
    private Suit(String prettySuit) {
        this.prettySuit = prettySuit;
    }
    
    /**
     * Returns the output-friendly version of the suit
     * 
     * @return String containing a version of the suit that's suitable for
     *         output
     */
    @Override
    public String toString() {
        return this.prettySuit;
    }
}
