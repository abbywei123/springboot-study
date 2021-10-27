package com.yw.config;

import com.yw.pojo.User;
import com.yw.service.UserService;
import com.yw.service.UserServiceImple;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加设置权限
        info.addStringPermission("user:add");

        //判断是否具有权限
        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//拿到UUsr对象

        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=》认证 doGetAuthenticationInfo");
        //用户名 密码  数据库中去
        //伪造数据
//        String name="admin";
//        String password="123456";

        UsernamePasswordToken userToken=(UsernamePasswordToken)token;

        System.out.println("userToken=>"+userToken);
        User user = userService.queryBYName(userToken.getUsername());
        System.out.println(user);
        if (user==null){
            return null;
        }
//
//        if (!userToken.getUsername().equals(user.getName())){
//            return null; //抛出异常 UnknownAccountException
//        }

        //密码认证 shiro做

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
