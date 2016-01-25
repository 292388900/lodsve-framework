package message.security;

/**
 * 安全模块静态常量.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0
 * @createTime 2014-12-5 20:35
 */
public class SecurityConstants {
    /**
     * 序列号
     */
    public static final String S_SECURITY = "s_security";
    /**
     * 账号表名
     */
    public static final String T_ACCOUNT = "t_account";
    /**
     * 角色表名
     */
    public static final String T_ROLE = "t_role";
    /**
     * 账号角色关系表名
     */
    public static final String T_ACCOUNT_ROLE = "t_account_role";

    /**
     * 用户名正则表达式
     */
    public static final String REGEX_LOGINNAME = "^[a-zA-Z0-9_-]{3,16}$";

    /**
     * 密码正则表达式
     */
    public static final String REGEX_PASSWORD = "^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,20}$";

    /**
     * 账号在session中的key
     */
    public static final String ACCOUNT_KEY_IN_SESSION = "ACCOUNT_SESSION_KEY";
}
