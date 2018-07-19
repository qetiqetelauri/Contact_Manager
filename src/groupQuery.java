
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
public class groupQuery {
    public void insertGroup(group gr, int userid) throws SQLException
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        ResultSet check;
           Statement st;
        
       
            try {
            st=con.createStatement();
            check = st.executeQuery("SELECT `Group_Name` FROM `group` WHERE Group_Name= '" + gr.getGname()+"'");
            if(check.next()){
                JOptionPane.showMessageDialog(null, "There is already such group");

            }else{
                ps = con.prepareStatement("INSERT INTO `group`(`Group_Name`,`Group_Admin_ID`) VALUES (?,?)"); 
                ps.setString(1, gr.getGname());
                ps.setInt(2, userid);
                 if(ps.executeUpdate() != 0){
                    JOptionPane.showMessageDialog(null, "New Group Added");
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            }
            
            
            
            
           
           
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
       public void updateGroup(group gr)
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        PreparedStatement contactup;
        String updateQuery = "UPDATE `group` SET `Group_Name`= ? WHERE `id` = ?";
        
        try {
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, gr.getGname());
            ps.setInt(2,gr.getGid());
            
            
            if(ps.executeUpdate() != 0){
                    JOptionPane.showMessageDialog(null, "Group Name Edited");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void deleteGroup(int gid)
    {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        PreparedStatement contactup;
        
        try {
            ps = con.prepareStatement("DELETE FROM `group` WHERE `id`= ?");
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
    
    // create  a list of contact
    public ArrayList<group> groupList(int userId) throws SQLException{
        
        ArrayList<group> glist = new ArrayList<group>();
        Connection con = myConnection.getConnection();
        Statement st;
        ResultSet rs;
        ResultSet grs;
        int id;
        
            st = con.createStatement();
            group gr;
            grs=st.executeQuery("SELECT `id`,`Group_Name` FROM `group` WHERE Group_Admin_ID =" + userId);
            while(grs.next()){
                gr = new group(grs.getInt("id"),grs.getString("Group_Name"),userId);
                glist.add(gr);
            }
            
        return glist;
        
    }
  
    public void sendRequest(String GroupName, int userid){
        Connection con = myConnection.getConnection();
        ResultSet ps;
        PreparedStatement sn;
        Statement st;
        ResultSet check;
        
        try {
            st=con.createStatement();
            ps = st.executeQuery("SELECT `id`,`Group_Admin_ID` FROM `group` WHERE Group_Name= '" + GroupName+"'");
            if(ps.next()){
                int AdminId=ps.getInt("id");
                int GroupId=ps.getInt("Group_Admin_ID");
                if(AdminId==userid){
                    JOptionPane.showMessageDialog(null, "you are Admin");
                }else{
                    check=st.executeQuery("SELECT `User_ID` FROM `members` WHERE User_ID=" + userid);
                    if(check.next()){
                        JOptionPane.showMessageDialog(null, "you already are member");
                    }else{
                        sn=con.prepareStatement("INSERT INTO `request`(`Admin_ID`,`user_ID`,`Group_ID`) VALUES (?,?,?)");
                        sn.setInt(1,AdminId);
                        sn.setInt(2,userid);
                        sn.setInt(3, GroupId);
                         if(sn.executeUpdate() != 0){
                            JOptionPane.showMessageDialog(null, "sent request");

                        }else{
                            JOptionPane.showMessageDialog(null, "Something Wrong");

                        }
                    }
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "There is not such group");
            }
        } catch (SQLException ex) {
            Logger.getLogger(groupQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
