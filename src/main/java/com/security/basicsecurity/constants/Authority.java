package com.security.basicsecurity.constants;

import com.security.basicsecurity.enums.PermissionsOperations;

public class Authority {
    public static final String[] USER_AUTHORITIES = {PermissionsOperations.read.name()};
    public static final String[] HR_AUTHORITIES = {PermissionsOperations.read.name(), PermissionsOperations.update.name()};
    public static final String[] MANAGER_AUTHORITIES = {PermissionsOperations.read.name(), PermissionsOperations.update.name()};
    public static final String[] ADMIN_AUTHORITIES = {PermissionsOperations.read.name(), PermissionsOperations.write.name(), PermissionsOperations.update.name()};
    public static final String[] SUPER_ADMIN_AUTHORITIES = {PermissionsOperations.read.name(), PermissionsOperations.write.name(), PermissionsOperations.update.name(), PermissionsOperations.delete.name()};
}
