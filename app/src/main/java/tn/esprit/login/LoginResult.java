package tn.esprit.login;

public class LoginResult {
    private  String username;

    private  String age;
    private String email;
    private String password;

    public LoginResult(String username, String password) {
        this.email = username;

        this.password = password;
    }

    public LoginResult(String email) {
        this.email = email;
    }




    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return username;
    }

    public String getAge(){ return age;}
}
