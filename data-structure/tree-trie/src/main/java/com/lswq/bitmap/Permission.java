package com.lswq.bitmap;

public class Permission {
    // 是否允许查询，二进制第1位，0表示否，1表示是
    public static final int ALLOW_SELECT = 1 << 0; // 0001

    // 是否允许新增，二进制第2位，0表示否，1表示是
    public static final int ALLOW_INSERT = 1 << 1; // 0010

    // 是否允许修改，二进制第3位，0表示否，1表示是
    public static final int ALLOW_UPDATE = 1 << 2; // 0100

    // 是否允许删除，二进制第4位，0表示否，1表示是
    public static final int ALLOW_DELETE = 1 << 3; // 1000

    // 存储目前的权限状态
    private int flag;

    /**
     * 重新设置权限
     */
    public void setPermission(int permission) {
        flag = permission;
    }

    /**
     * 添加一项或多项权限
     */
    public void enable(int permission) {
        flag |= permission;
    }

    /**
     * 删除一项或多项权限
     */
    public void disable(int permission) {
        flag &= ~permission;
    }

    /**
     * 是否拥某些权限
     */
    public boolean isAllow(int permission) {
        return (flag & permission) == permission;
    }

    /**
     * 是否禁用了某些权限
     */
    public boolean isNotAllow(int permission) {
        return (flag & permission) == 0;
    }

    /**
     * 是否仅仅拥有某些权限
     */
    public boolean isOnlyAllow(int permission) {
        return flag == permission;
    }

    public static void main(String[] args) {
        Permission permission = new Permission();
        permission.enable(Permission.ALLOW_UPDATE);

        boolean allow = permission.isAllow(Permission.ALLOW_UPDATE);
        System.err.println(allow);

        permission.enable(Permission.ALLOW_INSERT | Permission.ALLOW_UPDATE | Permission.ALLOW_DELETE);

    }
}
