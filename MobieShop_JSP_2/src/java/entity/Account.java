
package entity;

public class Account {
    private int AccountID;
    private String Email;
    private String Password;
    private String CustomerID;
    private int EmployeeID;
    private int Role;
    private int QuestionID;
    private String Answer;

    public Account(int AccountID, String Email, String Password, String CustomerID, int EmployeeID, int Role, int QuestionID, String Answer) {
        this.AccountID = AccountID;
        this.Email = Email;
        this.Password = Password;
        this.CustomerID = CustomerID;
        this.EmployeeID = EmployeeID;
        this.Role = Role;
        this.QuestionID = QuestionID;
        this.Answer = Answer;
    }

    public Account(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }
        public Account(String Email, String Password, int QuestionID, String Answer) {
        this.Email = Email;
        this.Password = Password;
        this.QuestionID = QuestionID;
        this.Answer = Answer;
    }
        public Account(String Password, int QuestionID, String Answer) {
        this.Email = Email;
        this.Password = Password;
        this.QuestionID = QuestionID;
        this.Answer = Answer;
    }

    

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }
    

    @Override
    public String toString() {
        return "Account{" + "AccountID=" + AccountID + ", Email=" + Email + ", Password=" + Password + ", CustomerID=" + CustomerID + ", EmployeeID=" + EmployeeID 
                + ", Role=" + Role + ", QuestionID=" + QuestionID + ", Answer=" + Answer +'}';
    }
}
