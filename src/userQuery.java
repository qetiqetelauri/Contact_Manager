
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kate
 */

public class userQuery {
    public void insertMember(user cont, Integer userID)
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        ResultSet get;
        Statement st;
        
        try {
            st=con.createStatement();
            get = st.executeQuery("SELECT `id` FROM `group` WHERE Group_Admin_ID= " +userID);
            ps = con.prepareStatement("INSERT INTO `members`(`Group_ID`, `User_ID`) VALUES (?,?)");
            ps.setInt(1, cont.getUid());
            ps.setInt(2, userID);
            
            
            if(ps.executeUpdate() != 0){
                    JOptionPane.showMessageDialog(null, "New Member Added");
                    ps = con.prepareStatement("DELETE FROM `request` WHERE `User_ID`= ?");
                    ps.setInt(1, userID);
                    ps.executeUpdate();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DeleteRequest(Integer gid)
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        PreparedStatement contactup;
        
        try {
            ps = con.prepareStatement("DELETE FROM `request` WHERE `id`= ?");
            ps.setInt(1, gid);
            
            
            if(ps.executeUpdate() != 0){
                    JOptionPane.showMessageDialog(null, "group Deleted");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public ArrayList<user> memberList(int userId) throws SQLException{
        
        ArrayList<user> mlist = new ArrayList<user>();
        Connection con = myConnection.getConnection();
        Statement st;
        ResultSet rs;
        PreparedStatement grs;
        
            st = con.createStatement();
            user us;
            int id;
            int groupid;
            rs=st.executeQuery("SELECT `id`,`user_ID`,'Group_ID' FROM `request` WHERE Admin_ID =" + userId);
            grs=con.prepareStatement("SELECT `id`, `fname`, `lname`, `username` FROM `user` WHERE id = ?");
            while(rs.next()){
                grs.setInt(1, rs.getInt("user_ID"));
                id=rs.getInt("id");
                groupid=rs.getInt("groupid");
                
                rs=grs.executeQuery();
                if(rs.next()){
                    us=new user(id,rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("username"),userId,groupid);
                mlist.add(us);
                grs.clearParameters();
                }
                
            }
            
            
            
        return mlist;
        
    }

    
}
