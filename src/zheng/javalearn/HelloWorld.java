package zheng.javalearn;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Zheng
 */
public class HelloWorld {


    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "select * from student";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Position p = new Position();
        p.setName("aaa");
        p.setAge("12");
        Position p1 = new Position();
        p1.setName("bbb");
        p1.setAge("13");
        Position p2 = new Position();
        p2.setName("aaa");
        p2.setAge("14");
        Position p3 = new Position();
        p3.setName("ccc");
        p3.setAge("15");
        Position p4 = new Position();
        p4.setName("bbb");
        p4.setAge("16");
        Step1 s1 = new Step1();
        HashMap<ApfDto, ArrayList<Position>> hmp = new HashMap<>();
        hmp = s1.getResult(p);
        hmp = s1.getResult(p1);
        hmp = s1.getResult(p2);
        hmp = s1.getResult(p3);
        hmp = s1.getResult(p4);

        for (ApfDto a : hmp.keySet()) {
            System.out.println(a);
            for (int i = 0; i < hmp.get(a).size(); i++) {
                System.out.println(hmp.get(a).get(i).getName());
                System.out.println(hmp.get(a).get(i).getAge());
            }
        }


    }
}
