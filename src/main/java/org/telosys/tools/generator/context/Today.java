/**
 *  Copyright (C) 2008-2017  Telosys project org. ( http://www.telosys.org/ )
 *
 *  Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.telosys.tools.generator.context;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.telosys.tools.generator.context.doc.VelocityMethod;
import org.telosys.tools.generator.context.doc.VelocityObject;
import org.telosys.tools.generator.context.names.ContextName;

/**
 * The current system date and time
 *  
 * @author Laurent GUERIN
 *
 */
//-------------------------------------------------------------------------------------
@VelocityObject(
		contextName= ContextName.TODAY ,
		text = "Object providing the current system date and time ",
		since = ""
 )
//-------------------------------------------------------------------------------------
public class Today
{
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd" ; // ISO
    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss"   ; // ISO
    
	//-------------------------------------------------------------------------------------
	@VelocityMethod(
		text={	
			"Returns the current date with the default format (ISO date format)"
			}
	)
    public String getDate()
    {
        //return defaultDateFormat.format( new Date() );
		// Fix SimpleDateFormat potential bug
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return dateFormat.format( new Date() );
    }

	//-------------------------------------------------------------------------------------
	@VelocityMethod(
		text={	
			"Returns the current date formatted with the given format"
			},
		parameters={
			"format : the Java date format (cf 'SimpleDateFormat' JavaDoc) "
		}
	)
    public String date( String sFormat )
    {
        SimpleDateFormat frm = new SimpleDateFormat(sFormat);
        return frm.format( new Date() );
    }

	//-------------------------------------------------------------------------------------
	@VelocityMethod(
		text={	
			"Returns the current time with the default format (ISO time format)"
			}
	)
    public String getTime()
    {
        //return defaultTimeFormat.format( new Date() );
		// Fix SimpleDateFormat potential bug
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
        return dateFormat.format( new Date() );
    }
    
	//-------------------------------------------------------------------------------------
	@VelocityMethod(
		text={	
			"Returns the current time formatted with the given format"
			},
		parameters={
			"format : the Java date format (cf 'SimpleDateFormat' JavaDoc) "
		}
	)
    public String time( String sFormat )
    {
        SimpleDateFormat frm = new SimpleDateFormat(sFormat);
        return frm.format( new Date() );
    }
}