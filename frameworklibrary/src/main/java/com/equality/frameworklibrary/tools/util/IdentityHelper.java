package com.equality.frameworklibrary.tools.util;

import com.equality.frameworklibrary.tools.model.OnlineUserInfo;

/**
 * Created by neil on 2017/5/7.
 */

public class IdentityHelper {
    private  static OnlineUserInfo user;

    public static synchronized void login(OnlineUserInfo _user)
    {
        if (user==null)
        {
            user=_user;
        }
    }


    public  static OnlineUserInfo getUser()
    {
        return user;
    }
}
