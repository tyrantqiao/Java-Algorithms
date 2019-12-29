package work;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author tyrantqiao
 * @date 2019年12月29日23:39:03
 */
public class MakeGateWaySql {
    static String deleteFormat = "DELETE FROM public_http_service_define() values()";

    static class GateWaySql {
        private String primaryKey;
        private String module;
        private String beanId;

        public String getPrimaryKey() {
            return primaryKey;
        }

        public void setPrimaryKey(String primaryKey) {
            this.primaryKey = primaryKey;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String getBeanId() {
            return beanId;
        }

        public void setBeanId(String beanId) {
            this.beanId = beanId;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int option = JOptionPane.YES_OPTION;
        List<GateWaySql> gateWaySqls = new ArrayList<>();
        while (option == JOptionPane.YES_OPTION) {
            GateWaySql gateWaySql = new GateWaySql();
            System.out.println("请输入主键");
            String primaryKey = scanner.next();
            gateWaySql.setPrimaryKey(primaryKey);
            System.out.println("请输入所属模块");
            String module = scanner.next();
            gateWaySql.setModule(module);
            System.out.println("请输入consumer定义的bean id，注意大小写");
            String beanId = scanner.next();
            gateWaySql.setBeanId(beanId);
            option = JOptionPane.showConfirmDialog(null, "Continue?");
        }

        System.out.println("delete from public_http_service_define(xxx) values (");
        StringJoiner stringJoiner = new StringJoiner(",");
        for (GateWaySql sql : gateWaySqls) {
            stringJoiner.add(sql.getPrimaryKey());
        }
        System.out.println(stringJoiner.toString());
        System.out.println(")");

    }
}
