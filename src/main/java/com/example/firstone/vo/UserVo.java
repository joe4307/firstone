package com.example.firstone.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import lombok.Data;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * @author miao
 */
@Data
public class UserVo {

    @ExcelProperty("用户名")
    @ContentFontStyle(fontName = "宋体")
    @ContentStyle(horizontalAlignment = HorizontalAlignment.CENTER)
    private String name;

    @ExcelProperty("手机号")
    @ContentFontStyle(fontName = "宋体")
    @ContentStyle(horizontalAlignment = HorizontalAlignment.CENTER)
    private String password;
}
