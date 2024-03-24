package com.ABCLaboratories.TestRegistrationSystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffLoginProcess {
    public boolean ifLogged(String email, String password){ // to check login inputs are correct and return true if not return false

        try{
            Connection con = DbConnection.getConnection();
            String mySqlQuery =
                    "SELECT s_name, s_password, id FROM tbl_staff WHERE s_name = '"+
                            email+
                            "' AND s_password = '"+
                            password+
                            "'";
            PreparedStatement preparedStatement = con.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                LoginSession.Email = resultSet.getString("s_name");
                LoginSession.Password = resultSet.getString("s_password");
                LoginSession.Id = resultSet.getInt("id");


                return true;
            }

        }catch (Exception exception){
            System. out. println("Database error: " + exception.getMessage());
        }

        return false;
    }
}
