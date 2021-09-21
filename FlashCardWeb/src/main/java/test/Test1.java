package test;

import java.util.stream.Stream;

public class Test1 {


    private static void setKeyWithoutAuthority(String userName, String... keys) {
        System.out.println("#1 num one");
        System.out.println("userName = " + userName);
        System.out.println("keys = " );
        Stream.of(keys).forEach(System.out::println);
        System.out.println("");
    }

    private static void setKeyWithAuthority(String userName, String inheritedAuthority, String... keys) {
        System.out.println("#2 num two");
        System.out.println("userName = " + userName);
        System.out.println("inheritedAuthority = " + inheritedAuthority);
        System.out.println("keys = " );
        Stream.of(keys).forEach(System.out::println);
        System.out.println("");
    }

    private static void setKey(UserType userType, UserBean userBean, String... keys) {
        if (userType == UserType.USER) {
            setKeyWithoutAuthority(userBean.getUserName(), keys);
        } else if (userType == UserType.USER_ADMIN) {
            setKeyWithAuthority(userBean.getUserName(), userBean.getInheritedAuthority(), keys);
        } else {
            throw new RuntimeException("incorrect type");
        }
    }

    public static void main(String[] args) {
        UserBean userBean1 = new UserBean();
        userBean1.setUserName("simon");
        userBean1.setInheritedAuthority("simon login");

        UserBean userBean2 = new UserBean();
        userBean2.setUserName("anderson");

        setKey(UserType.USER, userBean2, new String[] { "1", "2", "3" });

        setKey(UserType.USER_ADMIN, userBean1, new String[] { "4", "5", "6" });
    }


}
