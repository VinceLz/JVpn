# JVpn
java版的vpn








使用方法：
  vpn包下Jpn.java  类 ，使用方法
        Jvpn.eDall.INSTANCE2.xxxxxxxxxxx方法
        
        int createVpn(String name, String uname, String pwd, String ip, int type); 创建vpn 拨号簿
          name  为 vpn名称
          uname  vpn 用户名
          pwd   vpn 密码
          ip   vpn 地址
          type   1 pptp  2 L2TP
          
          
        int AddConnection(String strNewEntryName, String strNewPhoneNumber,String strNewCallbackNumber, String strNewUsername,
        String strNewPassword, String strNewDomain);    拨号操作  
        strNewEntryName    同上函数中的name   name 必须一致
        strNewPhoneNumber   一般为空
        strNewCallbackNumber  为空
        strNewUsername     vpn用户名
        strNewPassword    vpn密码
        strNewDomain   为空
        
        int getRasCode();  得到拨号成功后的vpn代码
        int close(int hRasConn);  关闭vpn 
        hRasConn   就是getRasCode（）得到的值 整形
        
        
        
        上述即可完成拨号，具体有什么问题，可以去查微软官方的文档.............
  
