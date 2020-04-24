package com.wy.upms.system.service;

import com.wy.upms.system.domain.*;

/**
 * @author wangyu
 * @title: SystemService
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 13:52
 */
public interface SoftwareSystemService {
    /**
     * 新增系统
     * @param softwareSysInfo
     * @return
     */
    Object addSystem(SoftwareSysInfo softwareSysInfo) throws Exception;

    /**
     * 新增角色
     * @param roleInfo
     * @return
     */
    Object addRole(RoleInfo roleInfo) throws Exception;

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    Object addMenu(MenuInfo menuInfo) throws Exception;


    /**
     * 更新权限
     * @param permissionInfo
     * @return
     */
    Object putPermission(PermissionInfo permissionInfo) throws Exception;

    /**
     * 获取所有角色
     * @return
     */
    Object getAllRole();

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    Object removeRole(Integer roleId);

    /**
     * 更新角色
     * @param roleInfo
     * @return
     */
    Object updateRole(RoleInfo roleInfo);

    /**
     * 新增部门
     * @param departmentInfo
     * @return
     */
    Object addDepartment(DepartmentInfo departmentInfo);

    /**
     * 更新部门
     * @param departmentInfo
     * @return
     */
    Object updateDepartment(DepartmentInfo departmentInfo);

    /**
     * 删除部门
     * @param depId
     * @return
     */
    Object removeDepartment(Integer depId);

    /**
     * 获取所有部门
     * @return
     */
    Object getAllDepartment();

    /**
     * 更新系统信息
     * @param softwareSysInfo
     * @return
     */
    Object updateSystem(SoftwareSysInfo softwareSysInfo);

    /**
     * 删除系统
     * @param sysId
     * @return
     */
    Object removeSystem(Integer sysId);

    /**
     * 获取所有系统信息
     * @return
     */
    Object getAllSystem();

    /**
     * 更新菜单
     * @param menuInfo
     * @return
     */
    Object updateMenu(MenuInfo menuInfo);

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    Object removeMenu(Integer menuId);

    /**
     * 获取系统下的菜单
     * @param menuQueryParems
     * @return
     */
    Object listMenu(MenuQueryParems menuQueryParems);
}