package com.nehs.antares.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * 打包成Jar后放到hive中当做UDF使用
 */
public class Lower extends UDF {
    public String evaluate(final String s) {
        if (s == null) {
            return null;
        }
        return s.toLowerCase();
    }
}
