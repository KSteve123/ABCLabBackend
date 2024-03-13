package com.ABCLaboratories.TestRegistrationSystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginProcess {
    public boolean ifLogged(String email, String password){ // to check login inputs are correct and return true if not return false

        try{
            Connection con = DbConnection.getConnection();
            String mySqlQuery =
                    "SELECT p_email, p_password FROM tbl_patient WHERE p_email = '"+
                            email+
                            "' AND p_password = '"+
                            password+
                            "'";
            PreparedStatement preparedStatement = con.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                LoginSession.Email = resultSet.getString("p_email");
                LoginSession.Password = resultSet.getString("p_password");


                return true;
            }

        }catch (Exception exception){
            System. out. println("Database error: " + exception.getMessage());
        }

        return false;
    }
}
