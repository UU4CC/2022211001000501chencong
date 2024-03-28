package dabing.week4;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//use @webservlet - no web.xml code
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name = "driver",value = "com. mysql.cj. jdbc. Driver"),
                @WebInitParam(name = "url",value = "jdbc:mysql://localhost 8080;databaseName=jsp"),
                @WebInitParam(name = "username",value = "root"),
                @WebInitParam(name = "password",value = "123456")
                        },loadOnStartup = 1
)//end of webservlet
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;//class variable
    @Override
    public void init() throws ServletException {
        //only one connection
        //String driver="com. mysql.cj. jdbc. Driver";
        //String url="jdbc:mysql://localhost 8080;databaseName=jsp";
        //String username="root";
        //String password="123456";
        //code like this is bad way---because change is not easy
        //for example change password of db-change in java code

        //get servletcinfig -->getinitparameters
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");//<param-name>driver</param-name>
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try{
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);//ok(java code)-ok(use config-in web.xml)--ok-use (@webservlet)
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }
}