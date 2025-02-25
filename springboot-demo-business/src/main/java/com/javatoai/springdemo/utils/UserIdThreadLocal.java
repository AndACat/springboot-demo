package com.javatoai.springdemo.utils;

public class UserIdThreadLocal {
    private static final ThreadLocal<Long> USER_ID_THREAD_LOCAL = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        if(userId != null) {
            USER_ID_THREAD_LOCAL.set(userId);
        }
    }
    public static void setUserId(String userId) {
        if(userId != null && !userId.isEmpty()) {
            try {
                setUserId(Long.parseLong(userId));
            }catch (Exception e) {
                // ignored
            }
        }
    }

    public static Long getUserId() {
        return USER_ID_THREAD_LOCAL.get();
    }

    public static void removeUserId() {
        USER_ID_THREAD_LOCAL.remove();
    }

}
