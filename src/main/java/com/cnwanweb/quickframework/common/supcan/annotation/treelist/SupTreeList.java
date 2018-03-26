//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cnwanweb.quickframework.common.supcan.annotation.treelist;

import com.cnwanweb.quickframework.common.supcan.annotation.common.fonts.SupFont;
import com.cnwanweb.quickframework.common.supcan.annotation.common.properties.SupProperties;
import com.cnwanweb.quickframework.common.supcan.annotation.treelist.cols.SupGroup;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupTreeList {
    SupProperties properties() default @SupProperties;

    SupFont[] fonts() default {};

    SupGroup[] groups() default {};
}
