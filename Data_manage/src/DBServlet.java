

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:12000/management_system";
	static final String USER = "root";
	static final String PASS = "1234";
	ArrayList<Employee> qualified_List = new ArrayList<>();
	ArrayList<Product> qualified_product = new ArrayList<>();
	ArrayList<Order> qualified_order = new ArrayList<>();
	Product existed;
	Product adding_product;
	Order adding_order = new Order();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		Connection conn = null;
	    Statement stmt = null;
	    
	    response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String but = new String(request.getParameter("the_only_button"));
		
		
		if( request.getParameter("the_only_button").equals("Add_to_Database") ){
			System.out.println(but + " request received(emp)");
			System.out.println("****************************************************");
			
			boolean flag_checkname = true;
			
			String name = new String(request.getParameter("Name_emp_add"));
			String ID = new String(request.getParameter("ID_emp_add"));
			String year = new String(request.getParameter("Birth_year_emp_add"));
			String salary = new String(request.getParameter("Salary_emp_add"));
			String title = new String(request.getParameter("Title_emp_add"));
			String contact = new String(request.getParameter("Contact_emp_add"));
			
		        try{
		            Class.forName(JDBC_DRIVER);
		            conn = DriverManager.getConnection(DB_URL,USER,PASS);
		        
		            stmt = conn.createStatement();
		            String sql;
		            PreparedStatement psql;
		            psql = conn.prepareStatement("insert into employee(id_employee, name,Birthday_year,salary,title,contact)" + "values(?,?,?,?,?,?)");
		            //psql.setInt(1, Integer.parseInt(ID));
		            psql.setLong(1, Long.parseLong(ID));
		            psql.setString(2, name);
		            psql.setInt(3,  Integer.parseInt(year));
		            psql.setInt(4, Integer.parseInt(salary));
		            psql.setString(5, title);
		            //psql.setInt(6, Integer.parseInt(contact));
		            psql.setLong(6, Long.parseLong(contact));
		            
		            sql = "SELECT id_employee, name,Birthday_year,salary,title,contact FROM employee";
		            ResultSet rs = stmt.executeQuery(sql);
		        		            
		            while(rs.next()){
		                String name_temp = rs.getString("name");
		                long ID_temp = rs.getLong("id_employee");
		                int year_temp = rs.getInt("Birthday_year");
		                int salary_temp = rs.getInt("salary");
		                String title_temp = rs.getString("title");
		                long contact_temp = rs.getLong("contact");
		                
		                if(ID_temp == Long.parseLong(ID)) {
		                	if(name_temp.equals(name)) {
		                		flag_checkname = false;
		                	}
		                }
		                System.out.print(name_temp + ID_temp + year_temp + salary_temp + title_temp + contact_temp);
		            }
		            if(flag_checkname){
		            	psql.executeUpdate();
		    			out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + title + "</title></head>\n" +
		    		            "<body bgcolor=\"#ffea73\">\n" +
		    		            "<h1 align=\"center\">" + "New employee added" + "</h1>\n" +
		    		            "<ul>\n" +
		    		            "  <h4 align=\"center\">name: "
		    		            + name +  "<br>" + 
		    		            "  <h4 align=\"center\">ID: "
		    		            + ID +  "<br>" + 
		    		            "  <h4 align=\"center\">Birth-year: "
		    		            + year +  "<br>" + 
		    		            "  <h4 align=\"center\">salary: "
		    		            + salary +  "<br>" + 
		    		            "  <h4 align=\"center\">title: "
		    		            + title +  "<br>" + 
		    		            "  <h4 align=\"center\">contact: "
		    		            + contact +  "<br>" + 
		    		            "</ul>\n" +
		    		            "<center><a href='DB_manage_emp.jsp' class='button'>Back</a></center>"
		    		            +
		    		            "</body></html>");
		            }
		            else {
		    			out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + title + "</title></head>\n" +
		    		            "<body bgcolor=\"#ffea73\">\n" +
		    		            "<h1 align=\"center\">" + "Operation Failed!" + "</h1>\n" +
		    		            "<ul>\n" +
		    		            "  <h4 align=\"center\"> Identical information detected! Please check "
		    		            + "<br>" + 
		    		            "</ul>\n" +
		    		            "<center><a href='DB_manage_emp.jsp' class='button'>Back</a></center>"
		    		            +
		    		            "</body></html>");
		            }
		            rs.close();
		            stmt.close();
		            conn.close();
		        }catch(SQLException se){
		            se.printStackTrace();
		        }catch(Exception e){
		            e.printStackTrace();
		        }finally{
		            try{
		                if(stmt!=null) stmt.close();
		            }catch(SQLException se2){
		            }
		            try{
		                if(conn!=null) conn.close();
		            }catch(SQLException se){
		                se.printStackTrace();
		            }
		        }
		      
		}
		
		else if(request.getParameter("the_only_button").equals("Search_Database")) {
			System.out.println(but + " request received(emp)");
			System.out.println("****************************************************");
			
			boolean flag_checkname = true;
			
			String name,ID,year,salary,title,contact;
			name = request.getParameter("Name_emp_search");
			ID = request.getParameter("ID_emp_search");
			year = request.getParameter("Birth_year_emp_search");
			salary =  request.getParameter("Salary_emp_search");
			title = request.getParameter("Title_emp_search");
			contact = request.getParameter("Contact_emp_search");
			
			boolean flag_name = false;
			boolean flag_ID = false;
			boolean flag_year = false;
			boolean flag_salary = false;
			boolean flag_title = false;
			boolean flag_contact = false;
			
			long convert_ID;
			int convert_year;
			int convert_salary;
			long convert_contact;
			
			if(name.equals(""))
				flag_name = true;
			if(ID.equals("")) {
				flag_ID = true;
			}
			if(year.equals("")) {
				flag_year = true;
			}
			if(salary.equals(""))
				flag_salary = true;
			if(title.equals(""))
				flag_title = true;
			if(contact.equals(""))
				flag_contact = true;
			
			if(flag_ID)
				convert_ID = 0;
			else
				convert_ID = Long.parseLong(ID);
			if(flag_year)
				convert_year = 0;
			else
				convert_year = Integer.parseInt(year);
			if(flag_salary)
				convert_salary = 0;
			else
				convert_salary = Integer.parseInt(salary);
			if(flag_contact)
				convert_contact = 0;
			else
				convert_contact = Long.parseLong(contact);
				
/*testing for the empty field
			System.out.println(flag_name);
			System.out.println(flag_ID);
			System.out.println(flag_year);
			System.out.println(flag_salary);
			System.out.println(flag_title);
			System.out.println(flag_contact);
*/

			try{
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            stmt = conn.createStatement();
	            String sql;
	            sql = "SELECT id_employee, name,Birthday_year,salary,title,contact FROM employee";
	            ResultSet rs = stmt.executeQuery(sql);
	            qualified_List.clear();
	            
	            
	            while(rs.next()){
	            	 String name_temp = rs.getString("name");
		             long ID_temp = rs.getLong("id_employee");
		             int year_temp = rs.getInt("Birthday_year");
		             int salary_temp = rs.getInt("salary");
		             String title_temp = rs.getString("title");
		             long contact_temp = rs.getLong("contact");
	                
		             
	                if(name_temp.equals(name) || flag_name){
	                	if(ID_temp == convert_ID || flag_ID) {
	                		if(year_temp == convert_year || flag_year) {
	                			if(salary_temp == convert_salary || flag_salary) {
	                				if(title_temp.equals(title) || flag_title) {
	                					if(contact_temp == convert_contact || flag_contact) {
	                						Employee result = new Employee();
	                						result.contact = contact_temp;
	                						result.ID = ID_temp;
	                						result.name = name_temp;
	                						result.salary = salary_temp;
	                						result.title = title_temp;
	                						result.year = year_temp;
	                						
	                						qualified_List.add(result);
	                					}
	                				}
	                			}
	                		}
	                	}

	                }
	            }
	            System.out.println(qualified_List.size());
	            String search_result;
	            search_result = "<!DOCTYPE html> \n" + "<html>" + "<head><title>" + "Search Result" + "</title></head>\n" +
    		            "<body bgcolor=\"#ffea73\">\n" + "<h1 align=\"center\">" + "Search Result" + "</h1>\n" + "<center><table border=\"1\">\r\n"+
    		            "<form action='DBServlet' method='POST'>";
	            String temp = "";
	            if(qualified_List.size() == 0) {
	            	temp = "None qualified result!";
	            }
	            else {
	            	temp =  "  <tr>\r\n" + 
		            		"    <th>Name</th>\r\n" + 
		            		"    <th>ID</th>\r\n" + 
		            		"    <th>Birth-Year</th>\r\n" + 
		            		"    <th>Salary</th>\r\n" + 
		            		"    <th>Title</th>\r\n" + 
		            		"    <th>Contact</th>\r\n" + 
		            		"  </tr>\r\n";
	            }
	            for(int i = 0; i < qualified_List.size(); i++) {
	            	temp = temp +   "<tr>\n "
	            			+ "<td>" + qualified_List.get(i).name + "</td>\n"
	            			+ "<td>" + qualified_List.get(i).ID +"</td>\n"
	            			+ "<td>" + qualified_List.get(i).year +"</td>\n"
	            			+ "<td>" + qualified_List.get(i).salary +"</td>\n"
	            			+ "<td>" + qualified_List.get(i).title +"</td>\n"
	            			+ "<td>" + qualified_List.get(i).contact +"</td>\n"
	            			+ "<td>	<button id = \"add_database_emp\" name = \"the_only_button\" type=\"submit\" value=" + i + ">\r\n" + 
	            			"	Delete\r\n" + 
	            			"	</button></td>\n"
	            			+ "</tr>\n";
	            }
	            search_result = search_result + temp;
	            search_result = search_result + "</table></center>\r\n" + 
	            		"</form>"+
	            		"<br><br>"+
    		            "<center><a href='DB_manage_emp.jsp' class='button'>Back</a></center>"+
	            		"</body>\r\n" + 
	            		"</html>";
	            
	            out.println(search_result);
	            rs.close();
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
			
			
		}
		
		else if(request.getParameter("the_only_button").equals("lucky")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			ArrayList<Employee> all_emp_lucky = new ArrayList<>();
			
			try{
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            stmt = conn.createStatement();
	            String sql;
 
	            sql = "SELECT id_employee, name,Birthday_year,salary,title,contact FROM employee";
	            ResultSet rs = stmt.executeQuery(sql);
	        
	            
	            
	            while(rs.next()){
	                String name_temp = rs.getString("name");
	                long ID_temp = rs.getLong("id_employee");
	                int year_temp = rs.getInt("Birthday_year");
	                int salary_temp = rs.getInt("salary");
	                String title_temp = rs.getString("title");
	                long contact_temp = rs.getLong("contact");
	                
	                Employee result = new Employee();
					result.contact = contact_temp;
					result.ID = ID_temp;
					result.name = name_temp;
					result.salary = salary_temp;
					result.title = title_temp;
					result.year = year_temp;
					
					all_emp_lucky.add(result);
	                //System.out.println(name_temp +" "+ ID_temp +" "+ year_temp + " "+salary_temp + " "+title_temp + " "+contact_temp);
	            }
	            
	            
	            rs.close();
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
			
			 int randomNumber = (int)(Math.random() * all_emp_lucky.size()-1);
			 out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + "Emploee of the Day" + "</title></head>\n" +
 		            "<body bgcolor=\"#ffea73\">\n" +
 		            "<h1 align=\"center\">" + "Emploee of the Day!" + "</h1>\n" +
 		            "<br><br>"+
 		           "<center>" + "Name: " + all_emp_lucky.get(randomNumber).name + "</center> " + 
 		          "<center>" + "ID: " +all_emp_lucky.get(randomNumber).ID + "</center> " +
 		           "<br><br><br>"+
 		            "<center><a href='DB_manage_emp.jsp' class='button'>Back</a></center>"
 		            +
 		            "</body></html>");
			
		}
		
		else if(isInteger(but)){
			System.out.println("Delete request received");
			System.out.println("Delete " + but);
			System.out.println("****************************************************");
			
			String emp_name_removing = qualified_List.get(Integer.parseInt(but)).name;
			long emp_id_removing = qualified_List.get(Integer.parseInt(but)).ID;
			
			try{
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            stmt = conn.createStatement();
            PreparedStatement psql;
            psql = conn.prepareStatement("delete from employee where name = ? and id_employee = ?");
            psql.setString(1, emp_name_removing);
            psql.setLong(2, emp_id_removing);
            psql.executeUpdate();
            psql.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
                System.out.println("Delete Successed!£¡"+"\n");
        }
        
			
			qualified_List.remove(Integer.parseInt(but));
			
			System.out.println(qualified_List.size());
            String search_result;
            search_result = "<!DOCTYPE html> \n" + "<html>" + "<head><title>" + "Search Result" + "</title></head>\n" +
		            "<body bgcolor=\"#ffea73\">\n" + "<h1 align=\"center\">" + "Search Result" + "</h1>\n" + "<center><table border=\"1\">\r\n"+
		            "<form action='DBServlet' method='POST'>";
            String temp = "";
            if(qualified_List.size() == 0) {
            	temp = "None qualified result!";
            }
            else {
            	temp =  "  <tr>\r\n" + 
	            		"    <th>Name</th>\r\n" + 
	            		"    <th>ID</th>\r\n" + 
	            		"    <th>Birth-Year</th>\r\n" + 
	            		"    <th>Salary</th>\r\n" + 
	            		"    <th>Title</th>\r\n" + 
	            		"    <th>Contact</th>\r\n" + 
	            		"  </tr>\r\n";
            }
            for(int i = 0; i < qualified_List.size(); i++) {
            	temp = temp +   "<tr>\n "
            			+ "<td>" + qualified_List.get(i).name + "</td>\n"
            			+ "<td>" + qualified_List.get(i).ID +"</td>\n"
            			+ "<td>" + qualified_List.get(i).year +"</td>\n"
            			+ "<td>" + qualified_List.get(i).salary +"</td>\n"
            			+ "<td>" + qualified_List.get(i).title +"</td>\n"
            			+ "<td>" + qualified_List.get(i).contact +"</td>\n"
            			+ "<td>	<button id = \"add_database_emp\" name = \"the_only_button\" type=\"submit\" value=" + i + ">\r\n" + 
            			"	Delete\r\n" + 
            			"	</button></td>\n"
            			+ "</tr>\n";
            }
            search_result = search_result + temp;
            search_result = search_result + "</table></center>\r\n" + 
            		"</form>"+
            		"<br><br>"+
		            "<center><a href='DB_manage_emp.jsp' class='button'>Back</a></center>"+
            		"</body>\r\n" + 
            		"</html>";
            
            out.println(search_result);
		}
		else if(request.getParameter("the_only_button").equals("product_add")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			try {
				addProduct(request,response,out);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("the_only_button").equals("summery")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			System.out.println("Redirecting to orderSummery.jsp ... ");
			summeryOrder(request,response,out);
			
		}
		else if(request.getParameter("the_only_button").equals("News")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			newsProduct(request,response,out);
			
		}
		else if(request.getParameter("the_only_button").equals("Search_product")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			searchProduct(request,response,out);
		}
		else if(request.getParameter("the_only_button").equals("order_add")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			try {
				addOrder(request,response,out);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("the_only_button").equals("Search_order")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			try {
				SearchOrder(request,response,out);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("the_only_button").equals("merge_product")) {
			System.out.println(but + " request received");
			System.out.println("****************************************************");
			boolean flag_success = false;
			Product result = new Product();
			try{
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            
	            int new_count = existed.getCount() + adding_product.getCount();
	        
	            stmt = conn.createStatement();
	            PreparedStatement psql;
	            psql = conn.prepareStatement("UPDATE goods SET number = ? WHERE name = ? and id = ?");
	            
	            psql.setInt(1, new_count);
	            psql.setString(2, existed.getName());
	            psql.setInt(3, existed.getID());
	            psql.executeUpdate();
	            psql.close();
	            
	            String psql2;
	            psql2 = "SELECT * FROM goods";
	            ResultSet rs = stmt.executeQuery(psql2);
	            while(rs.next()){
	            	Product temp = new Product();
	                temp.setName(rs.getString("name"));
	                temp.setCount(rs.getInt("number"));
	                temp.setCategory(rs.getString("category"));
	                temp.setExpiration(rs.getDate("expiration_date"));
	                temp.setPrice(rs.getDouble("price"));
	                temp.setCost(rs.getDouble("cost"));
	                temp.setSource(rs.getString("provider"));
	                temp.setSource_contact(rs.getString("provider_contact"));
	                temp.setID(rs.getInt("id"));
	                if(temp.getName().equals(existed.getName()) && temp.getID() == existed.getID()) {
	                	flag_success = true; 
	                	result = temp;
	                }
	            }
	            
			}catch(SQLException e){
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(flag_success) {
				System.out.println("Redirecting to productAdded.jsp from merge request ... ");
	        	 HttpSession session=request.getSession();
	        	 session.setAttribute("newproduct",result);
	        	 response.sendRedirect("productAdded.jsp");
			}
			else {
				System.out.println("Failed ... ");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void addOrder(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException, ParseException{

		String order_id = new String(request.getParameter("ID_order_add"));
		String product = new String(request.getParameter("product_order_add"));
		String product_id = new String(request.getParameter("PID_order_add"));
		String number = new String(request.getParameter("num_order_add"));
		//String price = new String(request.getParameter("Price_order_add"));
		String date_string = new String(request.getParameter("Date_order_add"));
		String member_id = new String(request.getParameter("Member_order_order_add"));
		String status = new String(request.getParameter("status_order_add"));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        java.util.Date d = null;  
        try {  
            d = format.parse(date_string);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        
        
        adding_order.setOrder_id(order_id);
        adding_order.setGood_name(product);
        adding_order.setGood_id(Integer.parseInt(product_id));
        adding_order.setNumber(Integer.parseInt(number));
        //adding_order.setPrice(Integer.parseInt(price));
        adding_order.setStatus(Integer.parseInt(status));
        adding_order.setMember_id(Integer.parseInt(member_id));
        adding_order.setDate(date);
        
        Connection conn = null;
	    Statement stmt = null;
		try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            stmt = conn.createStatement();
            String sql;
            
            PreparedStatement psql;
            psql = conn.prepareStatement("insert into orders(order_id, time, good_id, status, number, price, member_id, good_name)" + "values(?,?,?,?,?,?,?,?)");
            psql.setString(1, order_id);
            psql.setDate(2, date);
            psql.setInt(3, Integer.parseInt(product_id));
            psql.setInt(4, Integer.parseInt(status));
            psql.setInt(5, Integer.parseInt(number));
            //psql.setDouble(6, Double.parseDouble(price));
            psql.setInt(7, Integer.parseInt(member_id));
            psql.setString(8, product);
            
            String sql5;
            sql5 = "SELECT * FROM goods";
            ResultSet rsa = stmt.executeQuery(sql5);
            ArrayList<Product> all_product = new ArrayList<>();
            while(rsa.next()){
            	Product temp = new Product();
                temp.setName(rsa.getString("name"));
                temp.setCount(rsa.getInt("number"));
                temp.setCategory(rsa.getString("category"));
                temp.setExpiration(rsa.getDate("expiration_date"));
                temp.setPrice(rsa.getDouble("price"));
                temp.setCost(rsa.getDouble("cost"));
                temp.setSource(rsa.getString("provider"));
                temp.setSource_contact(rsa.getString("provider_contact"));
                temp.setID(rsa.getInt("id"));
                
                all_product.add(temp);
            }
            for(int i = 0; i < all_product.size(); i++) {
            	if(adding_order.getGood_name().equals(all_product.get(i).getName()) && adding_order.getGood_id() == all_product.get(i).getID()) {
            		if(adding_order.getMember_id() == 0) {
            			adding_order.setPrice(all_product.get(i).getPrice() * adding_order.getNumber());
            		}
            		else {
            			adding_order.setPrice(all_product.get(i).getPrice() * adding_order.getNumber() * 0.9);
            		}
            		psql.setDouble(6, adding_order.getPrice());
            	}
            }
            
            
            String sqq;
            boolean fail_flag = true;
            sqq = "SELECT * FROM goods where name = '" + adding_order.getGood_name() + "' and id = '" + adding_order.getGood_id() +"'; ";
            ResultSet rs = stmt.executeQuery(sqq);

            rs.last();
            int n = rs.getRow();
            if(n == 0) {
            	fail_flag = false;
            }
            System.out.println("No such item...");
            rs.beforeFirst();
            while(rs.next()) {
            	if(rs.getInt("number") - adding_order.getNumber() <= 0)
            		fail_flag = false;
            }
            
            if(fail_flag) {
	            PreparedStatement ps;
	        	ps = conn.prepareStatement("UPDATE goods SET number = number - ? WHERE name = ? and id = ?");
	            
	            ps.setInt(1, (adding_order.getNumber()));
	            ps.setString(2, adding_order.getGood_name());
	            ps.setInt(3, adding_order.getGood_id());
	            
	    		System.out.println("Sending Redirection to orderAdded.jsp ... ");
		       	 HttpSession session=request.getSession();
		       	 session.setAttribute("neworder",adding_order);
		       	 response.sendRedirect("orderAdded.jsp");
		         ps.executeUpdate();
		         psql.executeUpdate();
		         ps.close();
            }
            else {
            	HttpSession session=request.getSession();
            	 System.out.println("Sending Redirection to orderFailed.jsp ... ");
		       	 response.sendRedirect("orderFailed.jsp");
            }
            
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void addProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException, ParseException{
		
		String name = new String(request.getParameter("Name_product_add"));
		String ID = new String(request.getParameter("ID_product_add"));
		String number = new String(request.getParameter("Count_product_add"));
		String category = new String(request.getParameter("Category_product_add"));
		String expiration_date = new String(request.getParameter("Expiration_product_add"));
		String provider = new String(request.getParameter("Source_product_add"));
		String price = new String(request.getParameter("Price_product_add"));
		String provider_contact = new String(request.getParameter("Contact_product_add"));
		String cost = new String(request.getParameter("Cost_product_add"));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        java.util.Date d = null;  
	        try {  
	            d = format.parse(expiration_date);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        java.sql.Date date = new java.sql.Date(d.getTime());  
	        
		
		adding_product = new Product();
		adding_product.setName(name);
		adding_product.setCount(Integer.parseInt(number));
		adding_product.setCategory(category);
		adding_product.setExpiration(date);
		adding_product.setPrice(Double.parseDouble(price));
		adding_product.setCost(Double.parseDouble(cost));
		adding_product.setSource(provider);
		adding_product.setSource_contact(provider_contact);
		adding_product.setID(Integer.parseInt(ID));
        
		
		boolean flag_dup = false;
		Connection conn = null;
	    Statement stmt = null;
		try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            stmt = conn.createStatement();
            String sql;
            
            PreparedStatement psql;
            psql = conn.prepareStatement("insert into goods(name, number, category, expiration_date,price,cost, provider, provider_contact, id)" + "values(?,?,?,?,?,?,?,?,?)");
            psql.setString(1, name);
            psql.setInt(2, Integer.parseInt(number));
            psql.setString(3, category);
            psql.setDate(4, date);
            psql.setDouble(5, Double.parseDouble(price));
            psql.setDouble(6, Double.parseDouble(cost));
            psql.setString(7, provider);
            psql.setString(8, provider_contact);
            psql.setInt(9, Integer.parseInt(ID));
            
            
            sql = "SELECT name, number, category, expiration_date,price,cost, provider, provider_contact, id FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
            existed = new Product();
            
            while(rs.next()){
            	Product temp = new Product();
                temp.setName(rs.getString("name"));
                temp.setCount(rs.getInt("number"));
                temp.setCategory(rs.getString("category"));
                temp.setExpiration(rs.getDate("expiration_date"));
                temp.setPrice(rs.getDouble("price"));
                temp.setCost(rs.getDouble("cost"));
                temp.setSource(rs.getString("provider"));
                temp.setSource_contact(rs.getString("provider_contact"));
                temp.setID(rs.getInt("id"));
				
                if(temp.getID() == Integer.parseInt(ID)) {
                	if(temp.getName().equals(name)) {
                			flag_dup = true;
                			existed = temp;
                	}
                }
				System.out.println(temp.getExpiration());
            }
            
            if(!flag_dup) {
            	System.out.println("Sending Redirection to productAdded.jsp ... ");
            	psql.executeUpdate();
            	 HttpSession session=request.getSession();
            	 session.setAttribute("newproduct",adding_product);
            	 response.sendRedirect("productAdded.jsp");
            }
            else {
            	System.out.println("Sending Redirection to productAdded.jsp ... ");
            	//psql.executeUpdate();
            	HttpSession session=request.getSession();
           	 	session.setAttribute("newproduct",adding_product);
           	 	session.setAttribute("existingone", existed);
           	 	response.sendRedirect("productExist.jsp");
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
	}
	
	private void SearchOrder(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException, ParseException{
		Connection conn = null;
	    Statement stmt = null;

		String order_id;
		order_id = request.getParameter("ID_order_search");
		String product;
		product = request.getParameter("product_order_search");
		String product_id;
		product_id = request.getParameter("PID_order_search");
		String number;
		number = request.getParameter("num_order_search");
		String price;
		price = request.getParameter("Price_order_search");
		String date_string;
		date_string = request.getParameter("Date_order_search");
		String member_id;
		member_id = request.getParameter("Member_order_order_search");
		String status;
		status = request.getParameter("status_order_search");
		
		boolean flag_order_id = false;
		boolean flag_product = false;
		boolean flag_product_id = false;
		boolean flag_number = false;
		boolean flag_price = false;
		boolean flag_date_string = false;
		boolean flag_member_id = false;
		boolean flag_status = false;
		
		if(order_id.equals(""))
			flag_order_id = true;
		if(product.equals("")) {
			flag_product = true;
		}
		if(product_id.equals("")) {
			flag_product_id = true;
		}
		if(number.equals(""))
			flag_number = true;
		if(price.equals("")) {
			flag_price = true;
		}
		if(date_string.equals(""))
			flag_date_string = true;
		if(member_id.equals(""))
			flag_member_id = true;
		if(status.equals(""))
			flag_status = true;
		
		long time = System.currentTimeMillis();
		java.sql.Date date = new Date(time);
		
		int converted_good_id;
		int converted_status;
		int converted_num;
		double converted_price;
		int converted_member_id;
		
		if(flag_product_id)
			converted_good_id = 0;
		else
			converted_good_id = Integer.parseInt(product_id);
		if(flag_status)
			converted_status = 0;
		else
			converted_status = Integer.parseInt(status);
		if(flag_number)
			converted_num = 0;
		else
			converted_num = Integer.parseInt(number);
		if(flag_price)
			converted_price = 0;
		else
			converted_price = Integer.parseInt(price);
		if(flag_member_id)
			converted_member_id = 0;
		else
			converted_member_id = Integer.parseInt(member_id);
		if(flag_date_string) {
			
		}
		else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        java.util.Date d = null;  
	        try {  
	            d = format.parse(date_string);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        date = new java.sql.Date(d.getTime()); 
		}
		
		try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM orders";
            ResultSet rs = stmt.executeQuery(sql);
            qualified_order.clear();
            
            while(rs.next()){
            	Order temp = new Order();
                temp.setOrder_id(rs.getString("order_id"));
                temp.setGood_id(rs.getInt("good_id"));
                temp.setDate(rs.getDate("time"));
                temp.setPrice(rs.getDouble("price"));
                temp.setGood_name(rs.getString("good_name"));
                temp.setMember_id(rs.getInt("member_id"));
                temp.setStatus(rs.getInt("status"));
                temp.setNumber(rs.getInt("number"));
	             
                if(temp.getOrder_id().equals(order_id) || flag_order_id){
                	if(temp.getGood_name().equals(product) || flag_product) {
                		if(temp.getGood_id() == converted_good_id || flag_product_id) {
                			if(temp.getMember_id() == converted_member_id || flag_member_id) {
                				if(temp.getNumber() == converted_num || flag_number) {
                					if(temp.getDate().getTime() == date.getTime() || flag_date_string) {
                						if(temp.getPrice() == converted_price || flag_price){
                							if(temp.getStatus() == converted_status || flag_status){
                								qualified_order.add(temp);
                							}
                						}
                					}
                				}
                			}
                		}
                	}

                }
            }
            System.out.println("Sending Redirection to orderResult.jsp ... ");
        	HttpSession session=request.getSession();
       	 	session.setAttribute("ordersearchresult",qualified_order);
       	 	response.sendRedirect("orderResult.jsp");
        
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
	}
	
	private void searchProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException{
		
		Connection conn = null;
	    Statement stmt = null;
		
		String name;
		name = request.getParameter("Name_search_product");
		String ID;
		ID = request.getParameter("ID_search_product");
		String number; 
		number  = request.getParameter("Count_search_product");
		String category;
		category =request.getParameter("Category_search_product");
		String expiration_date; 
		expiration_date= request.getParameter("Expiration_search_product");
		String provider; 
		provider =request.getParameter("Source_search_product");
		String price;
		price =request.getParameter("Price_search_product");
		String provider_contact;
		provider_contact =request.getParameter("Contact_search_product");
		String cost;
		cost =request.getParameter("Cost_search_product"); 
	        
		
		boolean flag_name = false;
		boolean flag_ID = false;
		boolean flag_number = false;
		boolean flag_category = false;
		boolean flag_expiration = false;
		boolean flag_provider = false;
		boolean flag_contact = false;
		boolean flag_price = false;
		boolean flag_cost = false;
		
		
		
		if(name.equals(""))
			flag_name = true;
		if(ID.equals("")) {
			flag_ID = true;
		}
		if(category.equals("")) {
			flag_category = true;
		}
		if(provider_contact.equals(""))
			flag_contact = true;
		if(expiration_date.equals("")) {
			flag_expiration = true;
		}
		if(provider.equals(""))
			flag_provider = true;
		if(cost.equals(""))
			flag_cost = true;
		if(price.equals(""))
			flag_price = true;
		if(number.equals(""))
			flag_number = true;
		
		
		int convert_number;
		double convert_price;
		double convert_cost;
		int conver_id;
		long time = System.currentTimeMillis();
		java.sql.Date date = new Date(time);
		
		if(flag_price)
			convert_price = 0;
		else
			convert_price = Double.parseDouble(price);
		if(flag_number)
			convert_number = 0;
		else
			convert_number = Integer.parseInt(number);
		if(flag_cost)
			convert_cost = 0;
		else
			convert_cost = Double.parseDouble(cost);
		if(flag_ID)
			conver_id = 0;
		else
			conver_id = Integer.parseInt(ID);
		if(flag_expiration) {
			
		}
		else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        java.util.Date d = null;  
	        try {  
	            d = format.parse(expiration_date);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        date = new java.sql.Date(d.getTime()); 
		}

		try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
            qualified_product.clear();
            
            while(rs.next()){
            	Product temp = new Product();
                temp.setName(rs.getString("name"));
                temp.setCount(rs.getInt("number"));
                temp.setCategory(rs.getString("category"));
                temp.setExpiration(rs.getDate("expiration_date"));
                temp.setPrice(rs.getDouble("price"));
                temp.setCost(rs.getDouble("cost"));
                temp.setSource(rs.getString("provider"));
                temp.setSource_contact(rs.getString("provider_contact"));
                temp.setID(rs.getInt("id"));
	             
                if(temp.getName().equals(name) || flag_name){
                	if(temp.getID() == conver_id || flag_ID) {
                		if(temp.getPrice() == convert_price || flag_price) {
                			if(temp.getCost() == convert_cost || flag_cost) {
                				if(temp.getCount() == convert_number || flag_number) {
                					if(temp.getExpiration().getTime() == date.getTime() || flag_expiration) {
                						if(temp.getCategory().equals(category) || flag_category){
                							if(temp.getSource().equals(provider) || flag_provider){
                								if(temp.getSource_contact().equals(provider_contact) || flag_contact){
			                						qualified_product.add(temp);
                								}
                							}
                						}
                					}
                				}
                			}
                		}
                	}

                }
            }
            System.out.println("Sending Redirection to productResult.jsp ... ");
        	HttpSession session=request.getSession();
       	 	session.setAttribute("searchresult",qualified_product);
       	 	response.sendRedirect("productResult.jsp");
        
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		
	}
	private void summeryOrder(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException{
		Connection conn = null;
	    Statement stmt = null;
	    
	    try{
	    	 Class.forName(JDBC_DRIVER);
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);
	         stmt = conn.createStatement();
	         
	            String sql;
	            sql = "SELECT * FROM goods";
	            ResultSet rs = stmt.executeQuery(sql);
	            ArrayList<Product> all_product = new ArrayList<>();
	            while(rs.next()){
	            	Product temp = new Product();
	                temp.setName(rs.getString("name"));
	                temp.setCount(rs.getInt("number"));
	                temp.setCategory(rs.getString("category"));
	                temp.setExpiration(rs.getDate("expiration_date"));
	                temp.setPrice(rs.getDouble("price"));
	                temp.setCost(rs.getDouble("cost"));
	                temp.setSource(rs.getString("provider"));
	                temp.setSource_contact(rs.getString("provider_contact"));
	                temp.setID(rs.getInt("id"));
	                
	                all_product.add(temp);
	            }
	            
	            
			String sql2;
	        sql2 = "SELECT * FROM orders";
			ResultSet rss = stmt.executeQuery(sql2);
	        
			 ArrayList<Product> produt_in_order= new ArrayList<>();
	        rss.last();
			int order_num = rss.getRow();
			rss.beforeFirst();
			System.out.print("order_num: ");
			System.out.println(order_num);
	        while(rss.next()) {
	        	String temp_name = rss.getString("good_name");
	        	int temp_id = rss.getInt("good_id");
	        	int temp_num = rss.getInt("number");
	        	int temp_member = rss.getInt("member_id");
	        	
	        	System.out.print("temp_member: ");
    			System.out.println(temp_member);
    			
	        	boolean flag_e = true;
	        	if(produt_in_order.size() == 0) {
	        		Product new_item = new Product();
	    			new_item.setName(temp_name);
	    			new_item.setID(temp_id);
	    			new_item.setCount(temp_num);
	    			System.out.print("temp_num: ");
	    			System.out.println(temp_num);
	    			
	    			//new_item.setPrice(Integer.parseInt(new java.text.DecimalFormat("0").format(temp_member)));
	    			for(int j = 0; j < all_product.size(); j++) {
	    				if(new_item.getName().equals(all_product.get(j).getName()) && new_item.getID() == all_product.get(j).getID()) {
	    					if(temp_member == 0) {
	    						new_item.setPrice((all_product.get(j).getPrice()*new_item.getCount() - all_product.get(j).getCost())*new_item.getCount() );
	    						System.out.print("price: ");
	    		    			System.out.println(new_item.getPrice());
	    					}
	    					else {
	    						new_item.setPrice( (all_product.get(j).getPrice()* new_item.getCount()* 0.9 - all_product.get(j).getCost() * new_item.getCount()));
	    						System.out.print("member price: ");
	    		    			System.out.println(new_item.getPrice());
	    					}
	    				}
	    			}
	    			produt_in_order.add(new_item);
	    			System.out.println("adding..." + new_item.getName());
	        	}
	        	else {
	            	for(int i = 0; i < produt_in_order.size(); i++) {
	            		System.out.println(i);
	            		System.out.print(temp_name+ " ");
	            		System.out.println(temp_id);
	            		if(produt_in_order.get(i).getName().equals(temp_name) && produt_in_order.get(i).getID() == temp_id) {
	            			produt_in_order.get(i).setCount(produt_in_order.get(i).getCount() + temp_num);
	    	    			for(int j = 0; j < all_product.size(); j++) {
	    	    				if(produt_in_order.get(i).getName().equals(all_product.get(j).getName()) && produt_in_order.get(i).getID() == all_product.get(j).getID()) {
	    	    					if(temp_member == 0)
	    	    						produt_in_order.get(i).setPrice( produt_in_order.get(i).getPrice() + ((all_product.get(j).getPrice() * temp_num - all_product.get(j).getCost() * temp_num)) );
	    	    					else
	    	    						produt_in_order.get(i).setPrice( produt_in_order.get(i).getPrice() + ((all_product.get(j).getPrice() * temp_num* 0.9 - all_product.get(j).getCost()  * temp_num) ) );
	    	    				}
	    	    			}
	            			flag_e = false;
	            		}
	            		System.out.println(flag_e);
	            	}
	            	if(flag_e) {
	            		Product new_item = new Product();
	        			new_item.setName(temp_name);
	        			new_item.setID(temp_id);
	        			new_item.setCount(temp_num);
	           			for(int j = 0; j < all_product.size(); j++) {
		    				if(new_item.getName().equals(all_product.get(j).getName()) && new_item.getID() == all_product.get(j).getID()) {
		    					if(temp_member == 0)
		    						new_item.setPrice( (all_product.get(j).getPrice()* new_item.getCount() - all_product.get(j).getCost()* new_item.getCount()) );
		    					else
		    						new_item.setPrice((all_product.get(j).getPrice()* new_item.getCount()* 0.9 - all_product.get(j).getCost() * new_item.getCount()) );
		    				}
		    			}
	        			produt_in_order.add(new_item);
	        			System.out.println("adding..." + new_item.getName());
	            	}
	        	}
	        }
	        System.out.println("produt_in_order.size() = ");
	        System.out.println(produt_in_order.size());
	        
	 /*       for(int i = 0; i < produt_in_order.size(); i++) {
	        	double profit;
	        	for(int j = 0; j < all_product.size(); j++) {
	        		if(produt_in_order.get(i).getName().equals(all_product.get(j).getName()) && produt_in_order.get(i).getID() == all_product.get(j).getID()) {
	        			produt_in_order.get(i).setPrice( (all_product.get(j).getPrice() - all_product.get(j).getCost()) * produt_in_order.get(i).getCount());
	        		}
	        	}
	        }
	 */
	   	 	HttpSession session=request.getSession();
	   	 	session.setAttribute("orderlist",produt_in_order);
	   	 	response.sendRedirect("orderSummery.jsp");

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
	    
	}
	private void newsProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException{
		int min_num = 0;
		long time = System.currentTimeMillis();
		Date next_exp = new Date(time);

		Product min_number = new Product();
		Product next_sell = new Product();
		Connection conn = null;
	    Statement stmt = null;
		
		try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
            	min_num = rs.getInt("number");
            	next_exp = rs.getDate("expiration_date");
            	
            }
            
            while(rs.next()){
            	Product temp = new Product();
                temp.setName(rs.getString("name"));
                temp.setCount(rs.getInt("number"));
                temp.setCategory(rs.getString("category"));
                temp.setExpiration(rs.getDate("expiration_date"));
                temp.setPrice(rs.getDouble("price"));
                temp.setCost(rs.getDouble("cost"));
                temp.setSource(rs.getString("provider"));
                temp.setSource_contact(rs.getString("provider_contact"));
                temp.setID(rs.getInt("id"));
                
                if(temp.getCount() < min_num) {
                	min_num = temp.getCount();
                	min_number = temp;
                }
                if(temp.getExpiration().before(next_exp)) {
                	next_exp = temp.getExpiration();
                	next_sell = temp;
                }
            }
            
            String sql2;
            sql2 = "SELECT * FROM orders";
            ResultSet rss = stmt.executeQuery(sql2);
           
           
            ArrayList<Product> produt_in_order= new ArrayList<>();
            rss.last();
    		int order_num = rss.getRow();
    		rss.beforeFirst();
    		System.out.print("order_num: ");
    		System.out.println(order_num);
            while(rss.next()) {
            	String temp_name = rss.getString("good_name");
            	int temp_id = rss.getInt("good_id");
            	int temp_num = rss.getInt("number");
            	boolean flag_e = true;
            	if(produt_in_order.size() == 0) {
            		Product new_item = new Product();
        			new_item.setName(temp_name);
        			new_item.setID(temp_id);
        			new_item.setCount(temp_num);
        			produt_in_order.add(new_item);
        			System.out.println("adding..." + new_item.getName());
            	}
            	else {
	            	for(int i = 0; i < produt_in_order.size(); i++) {
	            		System.out.println(i);
	            		System.out.print(temp_name+ " ");
	            		System.out.println(temp_id);
	            		if(produt_in_order.get(i).getName().equals(temp_name) && produt_in_order.get(i).getID() == temp_id) {
	            			produt_in_order.get(i).setCount(produt_in_order.get(i).getCount() + temp_num);
	            			flag_e = false;
	            		}
	            		System.out.println(flag_e);
	            	}
	            	if(flag_e) {
	            		Product new_item = new Product();
	        			new_item.setName(temp_name);
	        			new_item.setID(temp_id);
	        			new_item.setCount(temp_num);
	        			produt_in_order.add(new_item);
	        			System.out.println("adding..." + new_item.getName());
	            	}
            	}
            }
            System.out.println("produt_in_order.size() = ");
            System.out.println(produt_in_order.size());
            int best = 0;
            Product top_seller = new Product();
            for(int i = 0; i < produt_in_order.size(); i++) {
            	if(best <= produt_in_order.get(i).getCount()) {
            		best = produt_in_order.get(i).getCount();
            		top_seller.setName(produt_in_order.get(i).getName());
            		top_seller.setID(produt_in_order.get(i).getID());
            		top_seller.setCount(produt_in_order.get(i).getCount());;
            	}
            }
            
            
            System.out.println("Sending Redirection to productNews.jsp ... ");
        	HttpSession session=request.getSession();
       	 	session.setAttribute("min_num",min_number);
       	 	session.setAttribute("next_sell",next_sell);
       	 	session.setAttribute("best_seller",top_seller);
       	 	response.sendRedirect("productNews.jsp");
        
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
	}
	
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
  }
	
	 public static class Employee {

			private String name;
			private long ID;
			private int year;
			private int salary;
			private String title;
			private long contact;
            
            
			public void setName(String name){
				this.name=name;
			}
			public String getName(){
				return this.name;
			}
			
			public void setID(long ID){
				this.ID=ID;
			}
			public long getID(){
				return this.ID;
			}
			
			public void setyear(int year){
				this.year=year;
			}
			public int getyear(){
				return this.year;
			}
			
			public void setsalary(int salary){
				this.salary=salary;
			}
			public int getsalary(){
				return this.salary;
			}
			
			public void settitle(String title){
				this.title=title;
			}
			public String gettitle(){
				return this.title;
			}
			
			public void setcontact(long contact){
				this.contact=contact;
			}
			public long getcontact(){
				return this.contact;
			}

		}

}
