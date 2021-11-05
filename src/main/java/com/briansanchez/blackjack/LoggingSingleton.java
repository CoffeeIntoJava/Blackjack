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
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

/**
 * This class implements a singleton design pattern in which the
 * {@link getLogger} method returns a fully configured instance.
 * Classes should use this rather than creating their own 
 * {@link java.util.logging.Logger}
 * instance.
 * 
 * @author Brian Sanchez
 */
public class LoggingSingleton extends Logger {
    
    /**
     * Private constructor.  Use factory method {@see getLogger}
     */
    private LoggingSingleton(String a, String b) {
        super(a,b);
    }
    
    /**
     * Implements the singleton design pattern.  This is the only way to create
     * a Logging instance
     * 
     * @return The singleton LoggingSingleton instance
     */
    public static final Logger getLogger() {
        if (!configured) {
            Configure();
        }
        return theLog;
    }
    
    /**
     * Configures the LoggingSingleton instance with {@see Constants#LOG_FORMAT}
     * 
     * @return no return value is provided
     */
    private static void Configure() {

        System.setProperty("java.util.logging.SimpleFormatter.format",
            (Constants.DEBUG_OUTPUT ?
                    Constants.LOG_FORMAT_DEBUG :
                    Constants.LOG_FORMAT));

        final ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel
            (Constants.DEBUG_OUTPUT ? Constants.DEBUG : Constants.OUTPUT);
        consoleHandler.setFormatter(new SimpleFormatter());

//theLog.setLevel
//    (Constants.DEBUG_OUTPUT ? Constants.DEBUG : Constants.OUTPUT);
//      theLog.addHandler(consoleHandler);
        
        // prevent additional calls to this method
        configured = true;
    }
    
    /**
     * The singleton LoggingSingleton instance
     */
    private static final Logger theLog = Logger.getAnonymousLogger();

    // True implies the Logger has been configured
    private static boolean configured = false;
}
