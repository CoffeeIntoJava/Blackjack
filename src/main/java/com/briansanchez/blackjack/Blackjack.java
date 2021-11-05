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

import java.sql.Time;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.TreeMap;

/**
 * This is the main class implementing a command-line blackjack simulator.
 * 
 * @author Brian Sanchez
 */
public class Blackjack {

    /**
     * The main method for the blackjack simulator.
     * @param args No arguments are processed
     */
    public static void main(String[] args) {
        
        startTime = System.currentTimeMillis();
        while (!shoe.isEmpty()) {
            newGame();
            
            while (!shoe.isEmpty()) {
                if (player.isHitMe()) {
                    player.draw();
//LOG.info(player.toString());
//LOG.info("Player busted? "+player.isBusted()+"\thit? "+player.hitMe);
                    if (player.isBusted()) {
                        break;
                    }
                }
                if ((!dealer.isBusted()) && (!player.isHitMe())) {
                    if (player.getScore() > dealer.getScore()) {
                        // Player holds, but dealer is losing
                        dealer.draw();
//LOG.info(dealer.toString());
//LOG.info("Dealer busted? "+dealer.isBusted()+"\thit? "+dealer.hitMe);
                        if (dealer.isBusted()) {
                            break;
                        }
                    } else {
                        // Player holds and dealer is winning/tied, so
                        // no need to draw
                        break;
                    }
                }
            }
            if (shoe.isEmpty()
                && (!player.isBusted()) && (!dealer.isBusted())) {
                // the shoe is out of cards but nobody has won, so the game is
                // a push and shouldn't be added to the statistics
                push++;
                break;
            } else if (dealer.isBusted() 
                    || ((!player.isHitMe()) && (!player.isBusted())
                        && (player.getScore() > dealer.getScore()))) {
                player.setWon();
            } else if (player.isBusted() && (!dealer.isBusted())) {
                dealer.setWon();
            } else if ((!player.isBusted()) 
                    && (player.getScore() > dealer.getScore())) {
                player.setWon();
            } else if (player.getScore() < dealer.getScore()) {
                dealer.setWon();
            } else {
                // it's a push
                push++;
            }

            outputGameSummary();
        }
        outputSummaryStats();        
    }
    
    /**
     * Outputs the game summary, including each player's cards and score
     */
    public static void outputGameSummary() {
        if ((player == null) || (dealer == null)) return;
        
        LOG.info(player.toString());
        LOG.info(dealer.toString());
        if (player.isWon()) {
            LOG.info("Result: Player wins!\n");
        } else if (dealer.isWon()) {
            LOG.info("Result: Dealer wins!\n");
        } else {
            LOG.info("Result: Push\n");
        }
    }
    
    /**
     * Outputs the game and player statistics to the Logger
     */
    public static void outputSummaryStats() {
        if (player == null) return;
        if (numGames == 0) {
            LOG.log(INFO, "No games played");
            return;
        }
        
        LOG.log(INFO, "Number of games: {0}\n", numGames);
        LOG.log(INFO, "Player success: {0}%\n",
                (int)(100d*((double)player.getWinCount()/(double)numGames)));
        
        //LOG.log(INFO, "{0} wins\n", player.getWinCount());
        //LOG.log(INFO, "{0} pushes\n", push);
        
        // Now print the winning hand counts for the player
        TreeMap playerWinStats = player.getWinStats();
        if (playerWinStats != null) {
            playerWinStats.descendingKeySet().forEach(key -> {
                LOG.log(INFO, "{0} => {1}",
                        new Object[]{key, playerWinStats.get(key)});
            });
        }
        
        // Finally, print the duration
        endTime = System.currentTimeMillis();
        LOG.log(INFO, "\n{0} ms elapsed", (endTime-startTime));
    }
    
    /**
     * Starts a new blackjack game by dealing each player two cards
     */
    public static void newGame() {
        numGames++;
        dealer.newHand();
        player.newHand();
        
        // First card
        player.draw();
        dealer.draw();
        // Second card
        player.draw();
        dealer.draw();
    }

    /**
     * This is the shoe, the collection of cards from which players are dealt
     */
    private static final Shoe shoe = new Shoe();
    
    /**
     * The players in the game.
     * Note that there should only be one dealer.
     * Additional logic will need to be added to support additional players
     */
    private static final Dealer dealer = new Dealer(shoe);
    private static final Player player = new Player(shoe);
    
    /**
     * Stores the number of games played
     */
    private static int numGames = 0;
    
    /** 
     * Stores the number of games without a winner
     */
    private static int push = 0;
    
    /**
     * Stores the start & stop time of the execution
     */
    private static long startTime = 0;
    private static long endTime   = 0;
    
    /**
     * For logging messages {@link Logger}
     */
    private static final Logger LOG = LoggingSingleton.getLogger();

    /**
     * 
     */
    private static final Level  INFO = Constants.OUTPUT;
}
