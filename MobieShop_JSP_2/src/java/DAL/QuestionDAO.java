/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import entity.Questions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author duongndhhe163691
 */
public class QuestionDAO extends entity.DBContext{
    
      public ArrayList<Questions> getQuestions() {
        ArrayList<Questions> list = new ArrayList<>();
        try {
            String sql = "select * from Questions_HE163691";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int QuestionID = rs.getInt("QuestionID");
                String Question = rs.getString("Question");
               

            Questions q = new Questions(QuestionID, Question);

                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      
      public Questions getQuestion(int quesId) {
        Questions ques = null;
        try {
            String sql = "select * from Questions_HE163691 where QuestionID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quesId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int QuestionID = rs.getInt("QuestionID");
                String Question = rs.getString("Question");
               
               ques = new Questions(QuestionID, Question);
                return ques;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      
    public static void main(String[] args) {
        
        ArrayList<Questions> q = new ArrayList<>();
        q = new QuestionDAO().getQuestions();
        
        System.out.println(q);
       
        
    }
}
