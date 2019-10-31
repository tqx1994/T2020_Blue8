
import javax.servlet.http.HttpSession;
import kong.unirest.HttpResponse;
//import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import newpackage.*;

import org.json.simple.parser.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        Customer a = new Customer();
        ObjectMapper mapper = new ObjectMapper();
        a = mapper.readValue(getId(username), Customer.class);
        String customerId = a.customerId;
        a = mapper.readValue(getCustdetails(customerId), Customer.class);
        session.setAttribute("customerId", a.customerId);
        session.setAttribute("gender", a.gender);
        session.setAttribute("firstName", a.firstName);
        session.setAttribute("lastName", a.lastName);
        session.setAttribute("lastLogIn", a.lastLogIn);

        /*DepositAccounts b = new DepositAccounts();
        b = mapper.readValue(getDepositaccounts(customerId), DepositAccounts.class);
        session.setAttribute("accountId", b.accountId);
        session.setAttribute("type", b.type);
        session.setAttribute("displayName", b.displayName);
        session.setAttribute("accountNumber", b.accountNumber);
        String acctid = String.valueOf(b.accountId);
        b = mapper.readValue(getDepositbal(acctid), DepositAccounts.class);
        session.setAttribute("availableBalance", b.availableBalance);
        session.setAttribute("currency", b.currency);
        session.setAttribute("displayName", b.displayName);*/

        response.sendRedirect("Accounts.jsp");
    }

    public String getId(String userName) {
        HttpResponse<String> response = Unirest.get("http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/" + userName)
                .header("identity", "Group8")
                .header("token", "545a6a5f-f955-48c1-936b-d545eac1aee8")
                .header("User-Agent", "PostmanRuntime/7.18.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "e2645fe4-a5a1-490a-8f08-6d07f402d03b,f6af8585-15e0-453c-aae1-1339c55acc0c")
                .header("Host", "techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }

    public static String getDepositbal(String accountId) {
        HttpResponse<String> response = Unirest.get("http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/accounts/deposit/" + accountId + "/balance?month=1&year=2018")
                .header("identity", "Group8")
                .header("token", "545a6a5f-f955-48c1-936b-d545eac1aee8")
                .header("User-Agent", "PostmanRuntime/7.18.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "69774853-5f89-40e9-8555-f1e5db59fde8,98f7e3f8-3434-435d-baae-00eea4088276")
                .header("Host", "techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }

    public String getCustdetails(String custId) {
        HttpResponse<String> response = Unirest.get("http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/" + custId + "/details")
                .header("identity", "Group8")
                .header("token", "545a6a5f-f955-48c1-936b-d545eac1aee8")
                .header("User-Agent", "PostmanRuntime/7.18.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "ccba7c6f-de70-48dd-b803-581af55f918f,e89c8600-2109-4b3a-bb7e-4299e1280194")
                .header("Host", "techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();

    }

    public String getDepositaccounts(String custId) {
        HttpResponse<String> response = Unirest.get("http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/accounts/deposit/" + custId)
                .header("identity", "Group8")
                .header("token", "545a6a5f-f955-48c1-936b-d545eac1aee8")
                .header("User-Agent", "PostmanRuntime/7.18.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "69b030f5-2681-482b-8524-7966e080e6de,8a94c4b9-4db6-4597-b6e9-3766bb367b0c")
                .header("Host", "techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }

    public String getTransdetails(String accountId) {
        HttpResponse<String> response = Unirest.get("http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/transactions/" + accountId + "?from=01-01-2018&to=02-01-2019")
                .header("identity", "Group8")
                .header("token", "545a6a5f-f955-48c1-936b-d545eac1aee8")
                .header("User-Agent", "PostmanRuntime/7.18.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "8bca843a-f2b8-47d1-8685-c76f7491a9b7,e0d20b76-b0fa-4798-818b-5bc7ae004e99")
                .header("Host", "techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }

    public String getCreditaccounts(String custId) {
        HttpResponse<String> response = Unirest.get("http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/accounts/credit/" + custId)
                .header("identity", "Group8")
                .header("token", "545a6a5f-f955-48c1-936b-d545eac1aee8")
                .header("User-Agent", "PostmanRuntime/7.18.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "66342480-e19e-4674-91fb-4304abd1f749,b76ae432-6663-4d8e-84e9-a49e8b4b7f79")
                .header("Host", "techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
