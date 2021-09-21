package test;

import java.io.Serializable;

public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName = null;
    private String inheritedAuthority = null;

    public UserBean() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInheritedAuthority() {
        return inheritedAuthority;
    }

    public void setInheritedAuthority(String inheritedAuthority) {
        this.inheritedAuthority = inheritedAuthority;
    }

}
