package com.yoloho.test.framework;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	public static void printWelecomeMsg(String strWelcomeMsgFilePath){
		txtFileManager.readTxtFile(strWelcomeMsgFilePath);
	}
	public static void printTestsuitMsg(String testsuitname,String tag){
		Date date = new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		System.out.println("=================" + testsuitname+" "+tag+" " +time+" ==================");
	}
/*
	public static void main(String args[]){
		Logger.printWelecomeMsg("./log/welcome.log");
		Logger.createLogFile("./log/", "UserLoginTest");
	}*/
	public static File createLogFile(String path,String scriptname){
		File logFile=null;
		String logFilePathName =null;
		if (!txtFileManager.isFolderExisted(path)){
			/*
			if(path.equals("./log/")){
				txtFileManager.createFolder(path);
			}
			else{
				System.out.println("Error: Log path" +path+" is invalid");
				return logFile;
			}*/
			txtFileManager.createFolder(path);
		}
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=format.format(date); 
		logFilePathName=path+"Log_"+scriptname+"_"+time+".log";	
		try{
			logFile=txtFileManager.createTxtFile(logFilePathName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return logFile;
	}
	public static void log(File logfile,String content){
		txtFileManager.appendData(logfile, content);
	}
	public static void showLog(File logFile){
		txtFileManager.readTxtFile(logFile);
	}
	public static void logTestScriptHeaderFooter(File logfile,String scriptname,String tag){
		drawScriptHeaderFooter(logfile,"Test Script: "+scriptname,tag);
	}

	public static void logTestcaseHeaderFooter(File logFile,String testcasename,String tag){
		drawTestcaseHeaderFooter(logFile,"Test Case: " +testcasename,tag);
	}
	public static void logMethodHeaderFooter(File logFile,String methodname,String tag){
		drawMethodheaderFooter(logFile,"Method: " +methodname,tag);
	}
		
	public static void drawScriptHeaderFooter(File logfile,String name,String tag){
		String content="***********************";
		content+=name;
		content+=" ";
		content+=tag;
		Date date = new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		content+=" ";
		content+=time;
		content+="*************************";
		log(logfile,content);
	}
	public static void drawTestcaseHeaderFooter(File logfile,String name,String tag){
		String content="==========================";
		content+=name;
		content+=" ";
		content+=tag;
		Date date = new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		content+=" ";
		content+=time;
		content+="===========================";
		log(logfile,content);
	}
	public static void drawMethodheaderFooter(File logfile,String name,String tag)
	{
		String content="---------------------------";
		content+=name;
		content+=" ";
		content+=tag;
		Date date = new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		content+=" ";
		content+=time;
		content+="-----------------------------";
		log(logfile,content);
	}
	
}

