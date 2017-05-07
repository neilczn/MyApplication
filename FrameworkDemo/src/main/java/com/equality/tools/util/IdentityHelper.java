package com.equality.tools.util;

import com.equality.tools.model.OnlineUserInfo;

/**
 * Created by neil on 2017/5/1.
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
