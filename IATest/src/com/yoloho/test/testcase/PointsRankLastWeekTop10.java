package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class PointsRankLastWeekTop10 
{
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public PointsRankLastWeekTop10(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_PointsRankLastWeekTop10.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void Testcase_01() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_01";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
	}
}