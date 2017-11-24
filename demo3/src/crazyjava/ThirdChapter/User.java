package crazyjava.ThirdChapter;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;  
    
    public static String username;//static对象无论加不加transient关键字，这个变量均不能被序列化
    private transient String passwd;//transient修饰的变量不能被序列化
    
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
