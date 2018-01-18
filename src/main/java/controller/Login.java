package controller;

import DatabaseConnection.DatabaseOperations;
import modal.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {


        DatabaseOperations  databaseOperations=new DatabaseOperations();
        String userName=req.getParameter("username");
        String userPassword=req.getParameter("password");

        String parola = userPassword;
        StringBuffer sb16 = new StringBuffer();

        try {
            MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
            messageDigestNesnesi.update(parola.getBytes());
            byte messageDigestDizisi[] = messageDigestNesnesi.digest();
            for (int i = 0; i < messageDigestDizisi.length; i++) {
                sb16.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
            }
        }catch(NoSuchAlgorithmException ex){
            ex.getStackTrace();
        }


        User user=databaseOperations.login(userName,sb16.toString());
        if (user!=null) {
            HttpSession session=req.getSession();
            session.setAttribute("user","natay");
            session.setMaxInactiveInterval(30*60);
            Cookie userName1=new Cookie("user", user.getUserName());
            userName1.setMaxAge(30*60);
            resp.addCookie(userName1);
            String encodedURL = resp.encodeRedirectURL("login.jsp");
            resp.sendRedirect(encodedURL);

        }else {

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.include(req, resp);
            System.out.println("olmadı");
        }

    }
}
