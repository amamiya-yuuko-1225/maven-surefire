package org.apache.maven.plugin.surefire.log.api;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 2.19.2
 */
public final class ConsoleLoggerUtils
{
    private ConsoleLoggerUtils()
    {
        throw new IllegalStateException( "non instantiable constructor" );
    }

    public static String toString( String message, Throwable t )
    {
        StringWriter result = new StringWriter( 512 );
        PrintWriter writer = new PrintWriter( result );
        try
        {
            if ( message != null )
            {
                writer.println( message );
            }
            t.printStackTrace( writer );
            writer.flush();
            return result.toString();
        }
        finally
        {
            writer.close();
        }
    }
}
