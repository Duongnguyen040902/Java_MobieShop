/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author duongndhhe163691
 */
public class Questions {
    private int QuestionID;
    private String Question;


    public Questions(int QuestionID, String Question) {
        this.QuestionID = QuestionID;
        this.Question = Question;
    }
    
    public Questions(String Question) {
        this.Question = Question;
    }


    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    @Override
    public String toString() {
        return "Questions{" + "QuestionID=" + QuestionID + ", Question=" + Question + '}';
    }
    
    
}
