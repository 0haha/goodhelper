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
		
		//+++++++++++++++��ҳ�浽��½����ע��ҳ�����++++++++++++++++++++++++
		if("/html/goodhelper-login.action".equals(requestPath)){
			
			path="/html/login.html";
		}
		
		if("/html/goodhelper-Signup.action".equals(requestPath)){
			path="/html/SignUp.html";
		}
		//++++++++++++++++��½ҳ�浽������ҳ�����+++++++++++++++++++++++++
		
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
		//++++++++++++++++ע��ҳ�浽������ҳ��Ĺ���+++++++++++++++++++++++++
		if("/html/goodhelper-main2.action".equals(requestPath)){
			
			String usrID=request.getParameter("usrID");
			String password=request.getParameter("mainpass");
			String phone=request.getParameter("phone");
			//ʵ�����ݿ�洢����
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
		//+++++++++++++++++++++++++++����֪ͨ++++++++++++++++++++++++++++
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
//+++++++++++++++++++++++++++++�ڶ��������������++++++++++++++++++++++++++++++++++++++++++++
		if("/html/product2.action".equals(requestPath)){
			ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
			String num1=request.getParameter("numberOfDates");//��ȡ����
			int Num1=Integer.parseInt(num1);
			String num2=request.getParameter("numberOfTimes");//��ȡ����
			int Num2=Integer.parseInt(num2);
			System.out.println(num2);
			String num3=request.getParameter("numberOfCustomer");//��ȡ����
			int Num3=Integer.parseInt(num3);
			String nameOfTable=request.getParameter("nameOfTable");//��ȡ�������
			String numberOfEachBlock=request.getParameter("numberOfEachBlock");
			
			workingTable workingTable=new workingTable(nameOfTable,Num1,Num2,Num3);//��ʼ������
			workingTable.setLimitNumOfEachBlock(Integer.valueOf(numberOfEachBlock));
			HttpSession session=hrequest.getSession(); 
			String usrId=(String)session.getAttribute("username");
			workingTableDao workingTableDaoImpl=ctx.getBean("workingTableDao",workingTableDaoImpl.class);
			workingTable.setUsrId(usrId);
			//��ʼʵ�ֹ���
			//�����ַ�������ɻ�ȡ������Ŀ��,��ȡdate�Ĵ���ֵ
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
			//�����ַ�������ɻ�ȡ������Ŀ��,��ȡtime�Ĵ���ֵ
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
		//++++++++++++++++++++++++�ڶ������ܰ���������+++++++++++++++++++++++++
		
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
					tablecheck.append(String.valueOf(j));//�������
					System.out.println(tablecheck);
					String s=request.getParameter(tablecheck.toString());
					
					if(s==null)
						table[i*Num2+j]="0";
					else
						table[i*Num2+j]="1";
					
				}
			}
			//customer customer=new customer(name,Num1,Num2,table);//�˴����ܴ��ڹ���ע��������Ҫjiejue
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
		//++++++++++++++++++++++���������ܴ���ͨѶ¼+++++++++++++++++++
		if("/html/product3.action".equals(requestPath)){
			
			
			
			path="/function/product3.jsp";
		}
		
		//++++++++++++++++++++++���ĸ���������С�ʾ�++++++++++++++++++++
		if("/html/product4.action".equals(requestPath)){
			//ͨ��session��ʽ��ȡ�û���
			HttpSession session=hrequest.getSession();
		    String nameOfQuestionare=request.getParameter("nameOfQuestionare");
		    //ʹ��questionare�ദ������
			questionare questionare=new questionare();
			questionare.setNameOfQuestionare(nameOfQuestionare);
			//�����Ŀ�����⼰�����ݣ�Ĭ�ϴ����������10��
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
						continue;//����ǰ�λ�����һ���������������answer+j��j��С����ȷ������ʱ��Ϊ���Ϊ7
					}else{
					switch(requestType){
					case "r":radio.addAnswers(requestAnswer);break;
					case "c":checkbox.addAnswers(requestAnswer);break;
					default:break;
					}
					}
					
				}
				
				
			}
			
			//���û�������questionare������
			questionare.setQuestionareId((String)(session.getAttribute("username")));
			//�������ȡ������ȫ���洢�����ݿ�
			questionare.save();
			//��ȡ���ɵ�questionare
			String usr=questionare.getUsr();
			String questionareID=questionare.getQuestionareID();
			session.setAttribute("questionareID", questionareID);
			String templinkPath="http://localhost:8080/goodhelper/pageLibrary/product4-1.jsp";
			String linkPath=templinkPath.concat("?questionareID="+questionareID);
			session.setAttribute("linkPath", linkPath);
			path="/function/product4.jsp";
		}
		//+++++++++++++++++��������+++++++++++++++++++++++
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
		//+++++++++++++++++++++++++++��������ܽ�������Ⱥ++++++++++++++++++++++++
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
