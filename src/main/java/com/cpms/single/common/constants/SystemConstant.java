package com.cpms.single.common.constants;

/**
 * @description: 系统常量配置
 * @author: gulang
 * @time: 2021/7/8 10:51
 */
public class SystemConstant {
   public final static String BASE_PACKAGES = "com.cpms";
   public final static String APPLICATION_NAME = "Cpms";

   /** 租户管理员默认角色名称 **/
   public static final String TENANT_ADMINISTRATOR_ROLE_NAME = "管理员";

   /** 租户管理员默认角色编码 **/
   public static final String TENANT_ADMINISTRATOR_ROLE_CODE = "TENANT_ADMINISTRATOR";

   /** 租户管理员默认角色描述 **/
   public static final String TENANT_ADMINISTRATOR_ROLE_DESC = "租户管理员角色";

   /** 数据状态:已禁用 **/
   public static final int DATA_STATUS_FORBIDDEN = 1;
   /** 数据状态:正常 **/
   public static final  int DATA_STATUS_NORMAL = 0;

   /** 数据状态:已删除 **/
   public static final int DEL_FLAG_DELETED = 1;
   /** 数据状态:未删除 **/
   public static final int DEL_FLAG_NOT_DELETED = 0;

   /** 类型：菜单 **/
   public static final int TYPE_MENU = 0;
   /** 类型：按钮 **/
   public static final int TYPE_BUTTON = 1;

   /** 系统数据 **/
   public static final int SYS_DATA = 1;

   public final static String DEFAULT_AVATAR = "https://iconfont.alicdn.com/t/9abd4acd-0b67-4b63-9163-205238a6aab4.png";
}
