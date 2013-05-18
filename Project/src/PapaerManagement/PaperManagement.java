/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PapaerManagement;
import java_xml.java_xml;

/**
 *
 * @author liuxiaoning
 */
public class PaperManagement {
     private Infor infor = new Infor();   
     
     
     public static void main(String args[]){
         login.Login loginWin = new login.Login(infor);
         
         loginWin.setVisible(true);
     }
}
