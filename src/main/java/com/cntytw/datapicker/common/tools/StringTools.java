package com.cntytw.datapicker.common.tools;

public class StringTools {
    /**
     * 将下划线命名法（snake_case）的字符串转换为小驼峰命名法（camelCase）
     * @param input 使用下划线命名法的字符串
     * @return 转换为小驼峰命名法的字符串
     */
    public static String convertSnakeToCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // 使用StringBuilder来构建结果字符串，以提高效率
        StringBuilder camelCaseString = new StringBuilder();
        boolean nextCharToUpper = false; // 标记下一个字符是否需要转换为大写

        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);

            // 如果当前字符是下划线，并且不是字符串的最后一个字符
            // 则需要将下一个字符转换为大写，并且跳过下划线
            if (currentChar == '_' && i < input.length() - 1) {
                nextCharToUpper = true;
                continue;
            }

            // 如果需要转换为大写，并且不是第一个字符（避免首字母大写）
            if (nextCharToUpper) {
                camelCaseString.append(Character.toUpperCase(currentChar));
                nextCharToUpper = false; // 重置标记
            } else {
                camelCaseString.append(currentChar);
            }
        }

        return camelCaseString.toString();
    }
}
