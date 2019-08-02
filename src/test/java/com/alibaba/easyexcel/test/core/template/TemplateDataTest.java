package com.alibaba.easyexcel.test.core.template;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.alibaba.easyexcel.test.util.TestFileUtil;
import com.alibaba.excel.EasyExcelFactory;

/**
 *
 * @author zhuangjiaju
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TemplateDataTest {

    private static File file07;
    private static File file03;

    @BeforeClass
    public static void init() {
        file07 = TestFileUtil.createNewFile("template07.xlsx");
        file03 = TestFileUtil.createNewFile("template03.xls");
    }

    @Test
    public void T01ReadAndWrite07() {
        readAndWrite07(file07);
    }

    @Test
    public void T02ReadAndWrite03() {
        readAndWrite03(file03);
    }

    private void readAndWrite07(File file) {
        EasyExcelFactory.write(file, TemplateData.class)
            .withTemplate(TestFileUtil.readFile("template" + File.separator + "template07.xlsx")).sheet()
            .doWrite(data()).finish();
        EasyExcelFactory.read(file, TemplateData.class, new TemplateDataListener()).headRowNumber(2).sheet().doRead()
            .finish();
    }

    private void readAndWrite03(File file) {
        EasyExcelFactory.write(file, TemplateData.class)
            .withTemplate(TestFileUtil.readFile("template" + File.separator + "template03.xls")).sheet().doWrite(data())
            .finish();
        EasyExcelFactory.read(file, TemplateData.class, new TemplateDataListener()).headRowNumber(2).sheet().doRead()
            .finish();
    }

    private List<TemplateData> data() {
        List<TemplateData> list = new ArrayList<TemplateData>();
        TemplateData data = new TemplateData();
        data.setString0("字符串0");
        data.setString1("字符串01");
        TemplateData data1 = new TemplateData();
        data1.setString0("字符串1");
        data1.setString1("字符串11");
        list.add(data);
        list.add(data1);
        return list;
    }
}
