package crazyjava.ThirdChapter;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;  
    
    public static String username;//static�������ۼӲ���transient�ؼ��֣�������������ܱ����л�
    private transient String passwd;//transient���εı������ܱ����л�
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPasswd() {
        return passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
