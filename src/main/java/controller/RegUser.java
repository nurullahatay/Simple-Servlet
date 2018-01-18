package controller;

import DatabaseConnection.DatabaseOperations;
import modal.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class RegUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {


        DatabaseOperations databaseOperations=new DatabaseOperations();
        String userName=req.getParameter("uname");
        String userPassword=req.getParameter("password");
        String userFirstName=req.getParameter("userfirstname");
        String userLastName=req.getParameter("userlastname");
        String usereEmail=req.getParameter("useremail");

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
            System.err.println(ex);
        }



        User user=new User(userName,sb16.toString(),userFirstName,userLastName,usereEmail);
        databaseOperations.Insert(user);
        req.setAttribute("user",user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);

    }
}
