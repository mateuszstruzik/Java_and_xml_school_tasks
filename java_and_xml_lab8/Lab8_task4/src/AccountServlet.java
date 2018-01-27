import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MATI on 13.12.2017.
 */
public class AccountServlet extends HttpServlet {

    BankAcc []bankAcc=new BankAcc[4];

    public void setcos(){
        bankAcc[0]=new BankAcc();
        bankAcc[0].Id=1;
        bankAcc[0].Balance=-123;
        bankAcc[0].First_name="Mateusz";
        bankAcc[0].Last_name="Truskawka";

        bankAcc[1]=new BankAcc();
        bankAcc[1].Id=2;
        bankAcc[1].Balance=1123;
        bankAcc[1].First_name="Marian";
        bankAcc[1].Last_name="Trzmiel";

        bankAcc[2]=new BankAcc();
        bankAcc[2].Id=3;
        bankAcc[2].Balance=2222;
        bankAcc[2].First_name="Michał";
        bankAcc[2].Last_name="Trochim";

        bankAcc[3]=new BankAcc();
        bankAcc[3].Id=4;
        bankAcc[3].Balance=-3;
        bankAcc[3].First_name="Maciek";
        bankAcc[3].Last_name="Traba";
    }
    int i;
    public boolean setParam(String id){
        for( i=0;i<bankAcc.length;i++){
            if(Integer.parseInt(id) == bankAcc[i].Id)
                return true;
        }
        return false;
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        setcos();


        String id=request.getParameter("id");

            if (setParam(id)) {
                String first_name = bankAcc[i].First_name;
                String last_name=bankAcc[i].Last_name;
                String balance=String.valueOf(bankAcc[i].Balance);
                request.setAttribute("first", first_name);
                request.setAttribute("last", last_name);
                request.setAttribute("balance", balance);
                request.getRequestDispatcher("/out.jsp").forward(request, response);

            }else{
              request.getRequestDispatcher("/outfalse.jsp").forward(request, response);
            }

    }


}
