package com.revature.enums;

public enum PermissionType {
    PERM_EMP, PERM_ADM;
    
    public static int typeToInt(PermissionType p) {
    	if (p == PermissionType.PERM_ADM) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
    
    public static PermissionType intToType(int in) {
    	switch (in) {
    	case 1: return PermissionType.PERM_ADM;
    	default: return PermissionType.PERM_EMP;
    	}
    }
}
