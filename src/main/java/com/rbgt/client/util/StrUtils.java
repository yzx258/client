package com.rbgt.client.util;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

public class StrUtils {
    public StrUtils() {
    }

    public static String bytesToHexStr(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes != null && bytes.length > 0) {
            for(int i = 0; i < bytes.length; ++i) {
                int v = bytes[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static boolean isBlank(String str) {
        return str == null || "".equals(str);
    }

    public static boolean notBlank(String str) {
        return !isBlank(str);
    }

    public static String firstToLowerCase(String str) {
        return String.valueOf(str.toCharArray()[0]).toLowerCase() + str.substring(1);
    }

    public static String firstToUpperCase(String str) {
        return String.valueOf(str.toCharArray()[0]).toUpperCase() + str.substring(1);
    }

    public static String camelCaseToUnderLine(String str, boolean isToUpperCase) {
        StringBuilder buf = new StringBuilder(str);

        for(int i = 1; i < buf.length() - 1; ++i) {
            if (Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i)) && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }

        return isToUpperCase ? buf.toString().toUpperCase() : buf.toString().toLowerCase();
    }

    public static String format(String strPattern, Object... argArray) {
        if (!StrUtil.isBlank(strPattern) && !ArrayUtil.isEmpty(argArray)) {
            int strPatternLength = strPattern.length();
            StringBuilder sbuf = new StringBuilder(strPatternLength + 50);
            int handledPosition = 0;

            for(int argIndex = 0; argIndex < argArray.length; ++argIndex) {
                int delimIndex = strPattern.indexOf("{}", handledPosition);
                if (delimIndex == -1) {
                    if (handledPosition == 0) {
                        return strPattern;
                    }

                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }

                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == '\\') {
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == '\\') {
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(StrUtil.utf8Str(argArray[argIndex]));
                        handledPosition = delimIndex + 2;
                    } else {
                        --argIndex;
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append('{');
                        handledPosition = delimIndex + 1;
                    }
                } else {
                    sbuf.append(strPattern, handledPosition, delimIndex);
                    sbuf.append(StrUtil.utf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + 2;
                }
            }

            sbuf.append(strPattern, handledPosition, strPattern.length());
            return sbuf.toString();
        } else {
            return strPattern;
        }
    }

    public static boolean isJsonStr(String str) {
        return str.startsWith("{") && str.endsWith("}") || str.startsWith("[") && str.endsWith("]");
    }
}
