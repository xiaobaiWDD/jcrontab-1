/**
 *  This file is part of the jcrontab package
 *  Copyright (C) 2001-2002 Israel Olalla
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free
 *  Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *  MA 02111-1307, USA
 *
 *  For questions, suggestions:
 *
 *  iolalla@yahoo.com
 *
 */
 
package org.jcrontab.data;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.StringTokenizer;
import org.jcrontab.CrontabBean;

/** CrontabEntryBeans represents each entry into
 * crontab "DataSource" usually a file.
 * This Bean allows jcrontab to interact with
 * the information from CrontabEntry
 * @author $Author: iolalla $
 * @version $Revision: 1.25 $
 */
public class CrontabEntryBean implements Serializable {
    
    private int id;
    
    private CrontabBean[] cb;
    private String seconds;
    private String hours;
    private String minutes;
    private String months;
    private String daysOfWeek;
    private String daysOfMonth;
    private String years;
	
    private String className;
    private String methodName = "";
    private String[] extraInfo;
    private boolean bextraInfo = false;
    private String description;
        
        
    private boolean[] bHours;
    private boolean[] bSeconds;
    private boolean[] bMinutes;
    private boolean[] bMonths;
    private boolean[] bDaysOfWeek;
    private boolean[] bDaysOfMonth;

        /** Default constructor
         */        
    public CrontabEntryBean(){
        bHours = new boolean[24];
        bMinutes = new boolean[60];
        bSeconds = new boolean[60];
        bMonths = new boolean[12];
        bDaysOfWeek = new boolean[7];
        bDaysOfMonth = new boolean[31];
        
        // Initializes all arrays to false
        for(int i=0; i<60; i++) {
            if(i<24)
                bHours[i] = false;
            if(i<60)
                bMinutes[i] = false;
            if(i<60)
                bSeconds[i] = false;
            if(i<12)
                bMonths[i] = false;
            if(i<7)
                bDaysOfWeek[i] = false;
            if(i<31)
                bDaysOfMonth[i] = false;
        }
    }
        
	/** Id setter
	 * @param id this integer identifies the CrontabEntryBean
	 */        
	public void setId(int id){
		this.id = id;
	}
	/** ClassName Setter
	 * @param className This is the name of the class to execute
	 */        
	public void setClassName(String className){
		this.className = className;
	}
	/** MethodName setter
	 * @param methodName the name of the method to execute
	 */        
	public void setMethodName(String methodName){
		this.methodName = methodName;
	}
	/** Extra info setter
	 * @param extraInfo this array represents the parameters passed to the
	 * task
	 */        
	public void setExtraInfo(String[] extraInfo){
		this.extraInfo = extraInfo;
	}	
	/** Hours setter
	 * @param hours The hours to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */        
	public void setHours(String hours){
		this.hours = hours;
	}
	/** Minutes setter
	 * @param minutes The minutes to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */      
	public void setMinutes(String minutes){
		this.minutes = minutes;
	}
	/** Seconds setter
	 * @param seconds The seconds to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */      
	public void setSeconds(String seconds){
		this.seconds = seconds;
	}
	/** Months setter
	 * @param months The Monts to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */  
	public void setMonths(String months){
		this.months = months;
	}
	/** Days of Week
	 * @param daysOfWeek The days of the week
	 */  
        public void setDaysOfWeek(String daysOfWeek){
		this.daysOfWeek = daysOfWeek;
	}
	/** Days of Month setter
	 * @param daysOfMonth The days of the month
	 */  
	public void setDaysOfMonth(String daysOfMonth){
		this.daysOfMonth = daysOfMonth;
	}
		/** Hours setter
	 * @param hours The hours to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */        
	public void setBHours(boolean[] bHours){
		this.bHours = bHours;
	}
	/** Minutes setter
	 * @param minutes The minutes to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */      
	public void setBMinutes(boolean[] bMinutes){
		this.bMinutes = bMinutes;
	}
	/** Months setter
	 * @param months The Monts to execute the Class,
	 * the values can take are [ * , 2-4 , 2,3,4,5 , 3/5]
	 */  
	public void setBMonths(boolean[] bMonths){
		this.bMonths = bMonths;
	}
	/** Days of Week
	 * @param daysOfWeek The days of the week
	 */  
    public void setBDaysOfWeek(boolean[] bDaysOfWeek){
		this.bDaysOfWeek = bDaysOfWeek;
	}
	/** Days of Month setter
	 * @param daysOfMonth The days of the month
	 */  
	public void setBDaysOfMonth(boolean[] bDaysOfMonth){
		this.bDaysOfMonth = bDaysOfMonth;
	}
    /** Days of Month setter
	 * @param daysOfMonth The days of the month
	 */  
	public void setBSeconds(boolean[] bSeconds){
		this.bSeconds = bSeconds;
	}
	/** bextraInfo setter
	 * @param daysOfMonth There are 
	 */  
	public void setBExtraInfo(boolean bextraInfo) {
	this.bextraInfo = bextraInfo;
	}
	/**Description setter
	 * @param description The desciption 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
    /** Id getter
    * @return the Id of this CrontabBean
    */        
    public int getId(){
		return id;
	} 
    /** Class Name getter
     * @return the Class's Name of this CrontabBean
     */      
	public String getClassName(){
		return className;
	}
    /** Method Name getter
     * @return the Method's Name of this CrontabBean
     */      
	public String getMethodName(){
		return methodName;
	}
    /** Extra Info getter
     * @return the extraInfo of this CrontabBean
     */      
	public String[] getExtraInfo(){
		return extraInfo;
	}
    /** Hours getter
     * @return the hours of this CrontabBean
     */      
    public String getHours(){
		return hours;
	}
	/** Minutes getter
	 * @return the minutes of this CrontabBean
	 */      
    public String getMinutes(){
		return minutes;
	}
    /** Minutes getter
	 * @return the minutes of this CrontabBean
	 */      
    public String getSeconds(){
		return seconds;
	}
	/** Months getter
	 * @return the months of this CrontabBean
	 */      
    public String getMonths(){
		return months;
	}
	/** Returns true if theres extra info false otherwise.
	 * @return extraInfo
	 */   
	public boolean getBExtraInfo() {
		return bextraInfo;
	}

	/** Days of week getter
	 * @return the Days of week of this CrontabBean
	 */      
    public String getDaysOfWeek(){
		return daysOfWeek;
	}
	/** Days of Month getter
	 * @return the Id of this CrontabBean
	 */      
    public String getDaysOfMonth(){
		return daysOfMonth;
	}
	/** Description getter
	 * @return the Description of this CrontabBean 
	 */      
    public String getDescription(){
		return description;
	}


   /** Represents the CrotnabEntryBean in XML format
    * @return the returning XML
    */        
	public String toXML(){
	        StringWriter stringWriter = new StringWriter();
       		PrintWriter printWriter = new PrintWriter(stringWriter, true);
        	toXML(printWriter);
        	return stringWriter.toString();
	}

   /** Returns the XML that represents this Crontab EntryBean
    * @param pw The printWritter to write the XML
    */        
	public void toXML(PrintWriter pw) {
		pw.println("<crontabentry>");
                pw.println("<id>" + id + "</id> ");
                pw.println("<hours>" + hours + "</hours> ");
		pw.println("<minutes>" + minutes + "</minutes> ");
		pw.println("<month>" + months + "</month> ");
		pw.println("<daysofweek>" + daysOfWeek + "</daysofweek> ");
		pw.println("<daysofmonth>" + daysOfMonth + "</daysofmonth> ");
                pw.println("<classname>" + className + "</classname> ");
		pw.println("<methodname>" + methodName + "</methodname> ");
 		if (bextraInfo) {               
			for (int i = 0; i < extraInfo.length ; i++) {
			pw.println("<extrainfo parameter = \"" + i + "\" >");
			pw.println(extraInfo[i] + " </extrainfo>");
			}
        	}
                pw.println("<description>" + description + "</description> ");
		pw.println("</crontabentry>");
	}
        
    /** 
     * Returns true if the time table entry matchs with the calendar given
     * @param cal Calendar to compare with the time table entry
     * @return true if the time table entry matchs with the calendar given
     */    
	public boolean equals(Calendar cal) {
        // IMPORTANT: Day of week and day of month in Calendar begin in
        // 1, not in 0. Thats why we decrement them
        return ( bHours[cal.get(Calendar.HOUR_OF_DAY)] &&
            bMinutes[cal.get(Calendar.MINUTE)] &&
            bMonths[cal.get(Calendar.MONTH)] &&
            bDaysOfWeek[cal.get(Calendar.DAY_OF_WEEK)-1] &&
            bDaysOfMonth[cal.get(Calendar.DAY_OF_MONTH)-1]);
	}

    /** 
     * Returns true if the CrontabEntryBean equals the given
     * @param ceb CrontabEntryBean to compare with the CrontabEntryBean 
     * @return true if the CrontabEntryBean entry equals the CrontabEntryBean 
	 * given
     */
	
	public boolean equals(CrontabEntryBean ceb) {
        boolean checker = false;
		if (this.id == ceb.getId()){
            return true;
		} else {
			return false;	
		}
	}
 }
