package ghpackage;


import ghInterface.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
















import org.apache.catalina.Session;
import org.apache.commons.logging.Log;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ModifiedFunction.New_Customer;
import ModifiedFunction.New_CustomerDao;
import ModifiedFunction.New_WorkingTable;
import ModifiedFunction.New_WorkingTableDao;
/**
 * Servlet Filter implementation class FilterDispatcher
 */
@WebFilter(filterName="gh",urlPatterns={"/*"})
public class FilterDispatcher implements Filter {

    /**
     * Default constructor. 
     */
    public FilterDispatcher() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Let's go..");
		HttpServletRequest hrequest=(HttpServletRequest)request;
		String requestPath =hrequest.getServletPath();
		String path=null;
		
		//+++++++++++++++主页面到登陆或者注册页面过程++++++++++++++++++++++++
		if("/html/goodhelper-login.action".equals(requestPath)){
			
			path="/html/login.html";
		}
		
		if("/html/goodhelper-Signup.action".equals(requestPath)){
			path="/html/SignUp.html";
		}
		//++++++++++++++++登陆页面到主功能页面过程+++++++++++++++++++++++++
		
		if("/html/goodhelper-main.action".equals(requestPath)){
			ApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
			String username=request.getParameter("maintext");
			String password=request.getParameter("mainpass");
			loginOrSignup loginorsignup=new loginOrSignup();
			if(loginorsignup.isCorresponed(username,password)){
			//request.setAttribute("usr", username);	
			HttpSession session=hrequest.getSession();
			session.setAttribute("username",username);
			path="/html/main.html";
			}
			else{
			path="/html/login.html";
			}
		}
		//++++++++++++++++注册页面到主功能页面的过程+++++++++++++++++++++++++
		if("/html/goodhelper-main2.action".equals(requestPath)){
			
			String usrID=request.getParameter("usrID");
			String password=request.getParameter("mainpass");
			String phone=request.getParameter("phone");
			//实现数据库存储功能
			loginOrSignup loginorsignup=new loginOrSignup();
			loginorsignup.setUsrID(usrID);
			loginorsignup.setPassword(password);
			loginorsignup.setPhoneNumber(phone);
			loginorsignup.save();
			
			path="/html/main.html";
		}
		if("/html/goodhelper-main3.action".equals(requestPath)||"/function/goodhelper-main3.action".equals(requestPath)){
			path="/html/main.html";
		}
		if("/html/fuction1.action".equals(requestPath)||"/function/fuction1.action".equals(requestPath)){
			
			path="/function/function1.jsp";
		}
		if("/html/fuction2.action".equals(requestPath)){
			
			path="/function/function2.jsp";
		}
		if("/html/fuction3.action".equals(requestPath)){
			System.out.println("function3 here");
			path="/function/function3.jsp";
		}
		if("/html/fuction4.action".equals(requestPath)){
			path="/function/function4.jsp";
		}
		if("/html/fuction5.action".equals(requestPath)){
			path="/function/function5.jsp";
		}
		if("/html/data.action".equals(requestPath)){
			path="/html/data.html";
		}
		//+++++++++++++++++++++++++++制作通知++++++++++++++++++++++++++++
		if("/html/product1.action".equals(requestPath)){
			System.out.println("function 1 here!");
			
			 ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
			 HttpSession session=hrequest.getSession(); 
			 String usrID=(String) session.getAttribute("username");
			 String communityID=request.getParameter("Community_ID");
			 String title=request.getParameter("title");
			 String content=request.getParameter("content");
			   Information inf=new Information();
			   inf.setUsrID(usrID);
			   if(communityID!=null){
			   inf.setCommunityID(Integer.parseInt(communityID));
			   }
			   inf.setTitile(title);
			   inf.setContent(content);
			   
			   
			   InformationDao informationDaoImpl=ctx.getBean("InformationDao",InformationDaoImpl.class);
			   Integer informationId=informationDaoImpl.save(inf);
			   
			   request.setAttribute("informationId", String.valueOf(informationId));
			   request.setAttribute("communityId",communityID);
			 
			
			path="/function/product1.jsp";
			
		}
		if(requestPath.startsWith("/html/finish1")||requestPath.startsWith("/pageLibrary/finish1")){
			
			String[] parampair1=requestPath.split("&");
			String[] parampair2=parampair1[1].split("[.]");
			String informationId=parampair2[0];
			System.out.println("the id is:"+informationId);
			String menber= request.getParameter("menber");
			System.out.println("the menber is:"+menber);
			ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
			InformationReadEvent inrEvt=new InformationReadEvent("hello",menber,Integer.parseInt(informationId));
			ctx.publishEvent(inrEvt);
			path="/function/finish.html";
		}
		if("/html/goodhelper-data1.action".equals(requestPath)){
			path="/data/data1.jsp";
		}
//+++++++++++++++++++++++++++++第二个功能制作班表++++++++++++++++++++++++++++++++++++++++++++
		if("/html/product2.action".equals(requestPath)){
			ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
			String num1=request.getParameter("numberOfDates");//获取列数
			int Num1=Integer.parseInt(num1);
			String num2=request.getParameter("numberOfTimes");//获取行数
			int Num2=Integer.parseInt(num2);
			System.out.println(num2);
			String num3=request.getParameter("numberOfCustomer");//获取人数
			int Num3=Integer.parseInt(num3);
			String nameOfTable=request.getParameter("nameOfTable");//获取表格名称
			String numberOfEachBlock=request.getParameter("numberOfEachBlock");
			
			workingTable workingTable=new workingTable(nameOfTable,Num1,Num2,Num3);//初始化对象
			workingTable.setLimitNumOfEachBlock(Integer.valueOf(numberOfEachBlock));
			HttpSession session=hrequest.getSession(); 
			String usrId=(String)session.getAttribute("username");
			workingTableDao workingTableDaoImpl=ctx.getBean("workingTableDao",workingTableDaoImpl.class);
			workingTable.setUsrId(usrId);
			//开始实现功能
			//处理字符串来完成获取参数的目的,获取date的代表值
			StringBuilder date=new StringBuilder();
			date.append("date");
			List<String>Dates=new ArrayList<String>();
			for(int i=0;i<Num1;i++){
				String p=date.append(String.valueOf(i)).toString();
				String Date=request.getParameter(p);
				if(!Date.equals(null)){
				System.out.println(Date);
				Dates.add(Date);
				}
			}
			workingTable.setDates(Dates);
			//处理字符串来完成获取参数的目的,获取time的代表值
			StringBuilder time=new StringBuilder();
			time.append("time");
			List<String> times=new ArrayList<String>();
			 for(int j=0;j<Num2;j++){
				 String t=time.append(String.valueOf(j)).toString();
				 String Time=request.getParameter(t);
					 if(!Time.equals(null)){
					 System.out.println(Time);
					 times.add(Time);
				 }
			 }
			 workingTable.setTimes(times);
			 String workingTableID=String.valueOf(workingTableDaoImpl.save(workingTable));
			//request.setAttribute("workingTable", workingTable);
			 request.setAttribute("workingTableID",workingTableID);
			 path="/function/product2.jsp";
		}
		//++++++++++++++++++++++++第二个功能班表回收数据+++++++++++++++++++++++++
		
		if(requestPath.startsWith("/html/finish2")||requestPath.startsWith("/pageLibrary/finish2")){
			
			ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
			workingTableDao workingTableDaoImpl=ctx.getBean("workingTableDao",workingTableDaoImpl.class);
			String name=request.getParameter("name");
			String[] parampair1=requestPath.split("&");
			String[] parampair2=parampair1[1].split("[.]");
			String workingTableID=parampair2[0];
			System.out.println("the id is:"+workingTableID);
			workingTable workingTable=workingTableDaoImpl.get(Integer.parseInt(workingTableID));
			int Num1=workingTable.getTableRow();
			int Num2=workingTable.getTableColumn();
			
			String []table=new String[Num1*Num2];
			for(int i=0;i<Num1;i++){
				for(int j=0;j<Num2;j++){
					StringBuilder tablecheck=new StringBuilder();
					tablecheck.append(String.valueOf(i));
					tablecheck.append(String.valueOf(j));//获得名称
					System.out.println(tablecheck);
					String s=request.getParameter(tablecheck.toString());
					
					if(s==null)
						table[i*Num2+j]="0";
					else
						table[i*Num2+j]="1";
					
				}
			}
			//customer customer=new customer(name,Num1,Num2,table);//此处可能存在构造注入问题需要jiejue
			customer customer=new customer();
			int time=0;
			for(int i=0;i<table.length;i++){
				 System.out.print(table[i]+" ");
			  }
			for(int i=0;i<table.length;i++){
				  time+=Integer.parseInt(table[i]);
			  }
			customer.setTtable(table);
			customer.setName(name);
			customer.setWorkingTable(workingTable);
			customer.setTime(time);
			customerDao customerDaoImpl=ctx.getBean("customerDao",customerDaoImpl.class);
			customerDaoImpl.save(customer);
			//workingTable.getCustomers().add(customer);
			//workingTableDaoImpl.update(workingTable);
			
			path="/function/finish.html";
		}
		if("/html/goodhelper-data2.action".equals(requestPath)){
			HttpSession session=hrequest.getSession(); 
			String usrId=(String)session.getAttribute("username");
			ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
			//workingTableDao workingTableDaoImpl=ctx.getBean("workingTableDao",workingTableDaoImpl.class);
			//List<workingTable> inforamtionList=workingTableDaoImpl.findByUsrname(usrId);
			workingTableFactory workingTableFactory=ctx.getBean("workingTableFactory",workingTableFactoryImpl.class);
			workingTableFactory.produceWorkingTable(usrId);
			path="/data/data2.jsp";
		}
		//++++++++++++++++++++++第三个功能创建通讯录+++++++++++++++++++
		if("/html/product3.action".equals(requestPath)){
			
			
			
			path="/function/product3.jsp";
		}
		
		//++++++++++++++++++++++第四个功能制作小问卷++++++++++++++++++++
		if("/html/product4.action".equals(requestPath)){
			//通过session方式获取用户名
			HttpSession session=hrequest.getSession();
		    String nameOfQuestionare=request.getParameter("nameOfQuestionare");
		    //使用questionare类处理数据
			questionare questionare=new questionare();
			questionare.setNameOfQuestionare(nameOfQuestionare);
			//获得题目的问题及答案内容，默认答案数量最多有10个
			for(int i=0;i<7;i++){
				StringBuilder question=new StringBuilder();
				question.append("question");
				StringBuilder type=new StringBuilder();
				type.append("type");
				
				String tempquestion=question.append(String.valueOf(i)).toString();
				String temptype=type.append(String.valueOf(i)).toString();
				String requestQuestion=request.getParameter(tempquestion);
				String requestType=request.getParameter(temptype);
				
				if(requestQuestion==null)
				{
					System.out.println("there are "+i+" problems!");
					continue;
				}
				radio radio=new radio();
				checkbox checkbox=new checkbox();
				text text=new text();
				switch(requestType){
				case "r":
				radio.setQuestion(requestQuestion);
				
				questionare.addSequence("r");
                break;
				case "c":
				checkbox.setQuestion(requestQuestion);
				
				questionare.addSequence("c");
				break;
				case "t":
				text.setQuestion(requestQuestion);
				questionare.addText(text);
				questionare.addSequence("t");
				break;
				default:
					
				}
				System.out.println("the "+i+"problem is"+requestQuestion);
				for(int j=0;j<7;j++){
					StringBuilder answer=new StringBuilder();
					answer.append("answer");
					String tempanswer=answer.append(String.valueOf(i)).append(String.valueOf(j)).toString();
					String requestAnswer=request.getParameter(tempanswer);
					System.out.println(tempanswer);
					
					if(requestAnswer==null){
						switch(requestType){
						case "r":questionare.addRadio(radio);break;
						case "c":questionare.addcheckbox(checkbox);break;
						default:
							break;
						
						}
						System.out.println("the "+i+" problem has "+(j+1)+"answers");
						continue;//由于前段会设置一个不定项参数名（answer+j）j大小不能确定，暂时认为最大为7
					}else{
					switch(requestType){
					case "r":radio.addAnswers(requestAnswer);break;
					case "c":checkbox.addAnswers(requestAnswer);break;
					default:break;
					}
					}
					
				}
				
				
			}
			
			//把用户名置入questionare对象中
			questionare.setQuestionareId((String)(session.getAttribute("username")));
			//将上面获取的数据全部存储入数据库
			questionare.save();
			//获取生成的questionare
			String usr=questionare.getUsr();
			String questionareID=questionare.getQuestionareID();
			session.setAttribute("questionareID", questionareID);
			String templinkPath="http://localhost:8080/goodhelper/pageLibrary/product4-1.jsp";
			String linkPath=templinkPath.concat("?questionareID="+questionareID);
			session.setAttribute("linkPath", linkPath);
			path="/function/product4.jsp";
		}
		//+++++++++++++++++回收数据+++++++++++++++++++++++
		if("/html/finish4.action".equals(requestPath)||"/pageLibrary/finish4.action".equals(requestPath)){
			HttpSession session=hrequest.getSession();
			String questionareID=(String)session.getAttribute("questionareID");
			
			statisticsQuestionare statisticsquestionare=new statisticsQuestionare();
			statisticsquestionare.setQuestionareID(questionareID);
			String name=request.getParameter("name");
			statisticsquestionare.setName(name);
			System.out.println("the id is:"+questionareID);
			System.out.println("the name is:"+name);
			try{
				String driverName="com.mysql.jdbc.Driver";
				String dbid="jdbc:mysql://localhost:3306/goodhelper";
				Class.forName(driverName);
				Connection conn=DriverManager.getConnection(dbid,"root","110");
				Statement stmt=conn.createStatement();
				
				
				ResultSet rset=stmt.executeQuery("select question_ID,type "+"from questionare "+"where questionare_ID="+questionareID+";");
				
				
				while(rset.next()){
					char type=rset.getString("type").charAt(0);
					String question_ID=rset.getString("question_ID");
					System.out.println("the questionID is:"+question_ID);
					if(type=='c'){
						String[] answers=request.getParameterValues(question_ID);
						statisticsquestionare.addAnswer(answers);
					}
					else{
						String answer=request.getParameter(question_ID);
						statisticsquestionare.addAnswer(answer);
						System.out.println("the answer is:"+answer);
					}
				}
				stmt.close();
				conn.close();
				}
				catch(Exception sqle){
					System.out.println("filterException:"+sqle);
				}
			statisticsquestionare.save();
			path="/function/finish.html";
		}
		if("/html/goodhelper-data4.action".equals(requestPath)){
			path="/data/data4.jsp";
		}
		//+++++++++++++++++++++++++++第五个功能建立工作群++++++++++++++++++++++++
		if("/html/product5.action".equals(requestPath)){
			System.out.println("good boy");
			 Configuration conf=new Configuration().configure();
			 SessionFactory sf=conf.buildSessionFactory();
			 org.hibernate.classic.Session sess=sf.openSession();
			 Transaction tx=  sess.beginTransaction();
			 
			 HttpSession session=hrequest.getSession();
			 String usrId=(String)session.getAttribute("username");
			 System.out.println(usrId);
			 community community=new community();
			 community.setUsrID(usrId);
			 String nameOfCommunity=request.getParameter("nameOfCommunity");
			 community.setNameOfCommunity(nameOfCommunity);
			 System.out.println(nameOfCommunity);
			 List<String> menbers=new ArrayList<String>();
			for(int i=0;i<50;i++){
				String s="menber";
				String ss=s.concat(String.valueOf(i));
				String nameOfMenber=request.getParameter(ss);
				if(nameOfMenber.equals(""))
					break;
				menbers.add(nameOfMenber);
			}
			 community.setMenbers(menbers);
			  sess.save(community);
			  tx.commit();
			  sess.close();
			  sf.close();
			
			
			path="/function/product5.jsp";
		}
		
		
		if(path!=null){
			request.getRequestDispatcher(path).forward(request, response);
			return;
		
		}
		
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
