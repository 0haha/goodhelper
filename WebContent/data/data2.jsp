<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ghpackage.*" %>
<%@ page import="ghInterface.*" %>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成的课表</title>
</head>
<body>
<% String usename=(String)session.getAttribute("username");
out.println(usename);
ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
workingTableDao workingTableDaoImpl=ctx.getBean("workingTableDao",workingTableDaoImpl.class);
List<workingTable> workingTableList=new ArrayList<workingTable>();
workingTableList=workingTableDaoImpl.findByUsrname(usename); 
for(workingTable tmp:workingTableList){
	out.println(tmp.getNameOfWorkingTable());
	int row=tmp.getTableRow();
	int column=tmp.getTableColumn();
	out.println("the row:"+row+" the column:"+column);
	Set<block> blocksSet=tmp.getBlocks();
	List<block> blocks=new ArrayList<block>();
	Iterator it=blocksSet.iterator();
	while(it.hasNext()){
		block b=(block)it.next();
		blocks.add(b);
	}
	int num=blocks.size();
	for(int k=0;k<num;k++){
		int r=blocks.get(k).getRow();
		int t=blocks.get(k).getColumn();
		out.println("sign"+k+":"+r+" "+t);
		List<customer> customers=blocks.get(k).getCustomerList();
		for(customer tmp_customer:customers){
			out.print("A:"+tmp_customer.getName()+" ");
		}
	}
}

%>

</body>
</html>