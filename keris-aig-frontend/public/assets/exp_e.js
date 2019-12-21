function drawPaper(para)
{
	this.chkDrawOk=function()
	{
		this.cdmlApi = new CdmlApi();
	}

	this.submitExam=function(url, bsubmit)
	{
		var question_ids = cdmlApi.getProblemList();
		var answers = cdmlApi.getInputList( question_ids );
		var answer_arr = answers.split("|");
		document.bnkfrm.action=url;
		var arr=document.getElementsByName("f_input");
		for( var i in answer_arr )
		{
			var objinput=document.getElementById("f_input_"+i);
			if(objinput==null)
			{
                objinput=document.createElement("INPUT");
                objinput.setAttribute("type","hidden");
                objinput.setAttribute("name","f_input_"+i);
                objinput.setAttribute("id","f_input_"+i);
                document.bnkfrm.appendChild(objinput);
			}
			var answer = answer_arr[i].replace(/,/gi, "/C/");
			objinput.value = answer;
		}
		if(bsubmit)
			document.bnkfrm.submit();
		else
			return document.bnkfrm;
	}

	this.setOX=function(result)
	{
		cdmlApi.eb_setOX(result);
	}

	this.getProblemList=function()
	{
		return cdmlApi.getProblemList();
	}

	this.delProblem=function(pid)
	{
		cdmlApi.delProblem( pid );
	}
	
	this.moveProblem=function(pid,pos)
	{
		cdmlApi.moveProblem( pid, pos );	
	}

	this.addProblem=function(mlist, numlist,resultlist,userinputlist, beforehtml, afterhtml,bmsg)
	{
		cdmlApi.addProblem(mlist, numlist,resultlist,userinputlist, beforehtml, afterhtml,bmsg);
	}

	this.replaceProblem=function(opid,npid)
	{
		cdmlApi.replaceProblem(opid, npid);
	}

	this.getRows=function() 
	{
		return cdmlApi.getRows();
	}

	this.getPTypeByIndex=function(index)
	{
		return cdmlApi.getPTypeByIndex(index);
	}


	this.getPidByIndex=function(index)
	{
		return cdmlApi.getPidByIndex(index);
	}

	this.getIndexByPid=function(pid)
	{
		return cdmlApi.getIndexByPid(pid);
	}

	this.getSelectedKeys=function()
	{
		return cdmlApi.get_checkboxes();
	}

	this.showOneProblem=function(index)
	{
		cdmlApi.showOneProblem(index);
	}

	this.setAnswer=function(index,answer,userinput)
	{
		cdmlApi.setAnswer(index, answer, userinput);
	}

	this.getInputByPid=function(pid)
	{
		return cdmlApi.getInputByPid(pid);
	}

	this.getInputByIndex=function(index)
	{
		return cdmlApi.getInputByIndex(index);
	}

	this.setInputByPid=function(pid,strinput)
	{
		cdmlApi.setInputByPid(pid, strinput);
	}

	this.getProblemDivByPid=function(pid)
	{
		return cdmlApi.getProblemDivByPid(pid);
	}

	this.getInputList=function(s)
	{
		return cdmlApi.getInputList( s );
	}

	this.chkNoSolve=function()
	{
		return cdmlApi.chkNoSolve();
	}

	this.changeMode=function(mode)
	{
		cdmlApi.changeMode(mode);
	}

	this.getTestResult=function()// 1 세모 2 정답 0틀림 문항수만큼  - 로 구분해서 return
	{
		return cdmlApi.getTestResult();
	}

}
