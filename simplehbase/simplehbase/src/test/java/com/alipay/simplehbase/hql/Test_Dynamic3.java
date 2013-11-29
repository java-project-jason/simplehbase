package com.alipay.simplehbase.hql;

import org.junit.Test;

public class Test_Dynamic3 extends TestHQL {
    /*
     * <dynamic prepend="hi"> allen <isNull prepend="AND" property="c"> love
     * <dynamic prepend="hello"> <isNull property="d"> dandan </isNull> cup
     * <isNull prepend="cat" property="e"> linzhi </isNull> </dynamic> </isNull>
     */
    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic3");
        para.put("c", null);

        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen hi love cup", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic3");
        para.put("c", null);
        para.put("d", null);

        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen hi love hello dandan cup", sb.toString());
    }

    @Test
    public void test_2() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic3");
        para.put("c", null);
        para.put("d", null);
        para.put("e", null);

        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen hi love hello dandan cup cat linzhi",
                sb.toString());
    }

    @Test
    public void test_3() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic3");
        para.put("c", null);
        para.put("e", null);

        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen hi love cup hello linzhi", sb.toString());
    }

}
