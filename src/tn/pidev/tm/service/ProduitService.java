package tn.pidev.tm.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.utils.MybdConnection;






public class ProduitService implements Iservice<Produit>{
  Connection mycon;
 
 
    public ProduitService() {
    mycon = MybdConnection.getInstanceBD().getConnection();
   

    }
  
    public  boolean inserer(Produit p) throws SQLException {
      
     

     String req1="INSERT INTO `produit` (`id`,`reference` , `nom`, `idenseigne`, `categorie`, `prix`, `description`, `promo`, `image` ) VALUES ('"+p.getId()+"' , '"+p.getReference()+"','"+p.getNom()+"','"+p.getEnseigne().getId()+"', '"+p.getCategorie()+"','"+p.getPrix()+"','"+p.getDescription()+"','"+p.getPromo()+"', '"+p.getImage()+"');";  
       Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
                   
       return true;
  }
  
  public boolean modifier(Produit p) throws SQLException{
      String req1="UPDATE `produit` SET prix= ? WHERE id = ? ";
            
           PreparedStatement ps= mycon.prepareStatement(req1); 
            ps.setDouble(1, p.getPrix());
            ps.setInt(2, p.getId());
             
            ps.executeUpdate();
            
            return true;
    
    }
  
    
  public boolean modifierRef(Produit p) throws SQLException{
       
      String req1="UPDATE `produit` SET nom= ?,categorie= ?,prix= ?,description= ?,promo= ?,image= ? WHERE reference = ? ";
            
            PreparedStatement ps= mycon.prepareStatement(req1); 
            ps.setString(1, p.getNom());
            ps.setString(2, p.getCategorie());
            ps.setDouble(3, p.getPrix());
            ps.setString(4, p.getDescription());
            ps.setFloat(5, p.getPromo());
            ps.setString(6, p.getImage());
            ps.setInt(7, p.getReference());
             
            ps.executeUpdate();
            
              return true;
  }
  
    public  boolean supprimer(Produit p) throws SQLException {
        
     String req = "delete from produit where "
                + "id= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1, p.getId());
       ps.executeUpdate();
              return true;
  
    }

  
                public   List<String> showNomEnseigne() {
                    
                    
         try {
                List<String> liste = new ArrayList();
            Enseigne ens=new Enseigne();
            ServiceEnseigne e=new ServiceEnseigne();
            
            String req = "SELECT idEnseigne FROM `produit`";
            Statement statement = mycon.createStatement();
            ResultSet rs = statement.executeQuery(req);
            
            //int counterPopulate = 0;
            while (rs.next()) {
                ens= e.chercherens(rs.getInt("idEnseigne"));

//                  Produit produit;
//                 produit = new Produit(ens);
                liste.add(ens.getNom());
                liste.toString();
       
            }
            return liste;
        }
        catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            return null; 
        }
    }
        
        //SELECT concat(nom_user,' ',prenom_user) FROM `util` WHERE 1
        

    
  public  boolean supprimerRef(Produit p) throws SQLException {
        
     String req = "delete from produit where "
                + "reference= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1, p.getReference());
       ps.executeUpdate();
              return true;
  
    }


    
//    public void m() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
     
           public ObservableList<Produit> getAll() {
        ObservableList<Produit> produits = FXCollections.observableArrayList();
        String req = "select * from produit";
        Enseigne ens=new Enseigne();
        ServiceEnseigne e=new ServiceEnseigne();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Produit produit;
               ens= e.chercherens(res.getInt("idEnseigne"));
                     System.out.println("");   
                     
                produit = new Produit(res.getInt("reference"), res.getString("nom"),ens,res.getString("categorie") ,res.getDouble("prix"), res.getString("description"),res.getFloat("promo"), res.getString("image"));
                produits.add(produit);
                produits.toString();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;   
    }
  
           public ObservableList <Produit> getAll1() {
        ObservableList<Produit> produits = FXCollections.observableArrayList();
        String req = "select * from produit";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Produit produit;
                 ServiceEnseigne se=new ServiceEnseigne();
       Enseigne E =new Enseigne() ;
       E=se.chercherens(res.getInt("idenseigne"));
                     System.out.println("");     
                  
                produit = new Produit(res.getInt("id"),res.getString("nom"),res.getString("categorie"),res.getDouble("prix"), res.getString("description"),res.getFloat("promo"),res.getInt("reference"), res.getString("image"),E);
                produits.add(produit);
                produits.toString();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;   
    }
           
           
           
                
           
             public ObservableList <Produit> getAllS(String r) {
        ObservableList<Produit> produits = FXCollections.observableArrayList();
        String req = "select * from produit where nom LIKE '%"+r+"%'"+" or description LIKE '%"+r+"%';";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Produit produit;
                 ServiceEnseigne se=new ServiceEnseigne();
       Enseigne E =new Enseigne() ;
       E=se.chercherens(res.getInt("idenseigne"));
                     System.out.println("");     
                  
                produit = new Produit(res.getInt("id"),res.getString("nom"),res.getString("categorie"),res.getDouble("prix"), res.getString("description"),res.getFloat("promo"),res.getInt("reference"), res.getString("image"),E);
                produits.add(produit);
                produits.toString();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;   
    }
           
           
           
            public ObservableList<Produit> getAll(String nom) throws SQLException {
        ObservableList<Produit> produits = FXCollections.observableArrayList();
        ServiceEnseigne ens=new ServiceEnseigne();
        Enseigne e=new Enseigne();
         e =ens.cherchernom(nom);
        String req = "select * from produit where idEnseigne='"+e.getId()+"';";
       
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Produit produit;
               e= ens.chercherens(res.getInt("idEnseigne"));
                     System.out.println("");   
                     
                produit = new Produit(res.getInt("reference"), res.getString("nom"),e,res.getString("categorie") ,res.getDouble("prix"), res.getString("description"),res.getFloat("promo"), res.getString("image"));
                produits.add(produit);
                produits.toString();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;   
    }
           
           
     
           
           
           
                    public ObservableList<Produit> getAllprodParEns( String enseigne) throws SQLException {
        ObservableList<Produit> produits = FXCollections.observableArrayList();
          ServiceEnseigne e=new ServiceEnseigne();
       int idEns=e.chercherEns(enseigne).getId();
        String req = "select * from produit where idEnseigne='"+idEns+"';";
        Enseigne ens=new Enseigne();
      
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Produit produit;
               ens= e.chercherens(res.getInt("idEnseigne"));
                     System.out.println("");   
                     
                produit = new Produit(res.getInt("reference"), res.getString("nom"),ens,res.getString("categorie") ,res.getDouble("prix"), res.getString("description"),res.getFloat("promo"), res.getString("image"));
                produits.add(produit);
                produits.toString();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;   
    }
           
        public List<Produit> getRef(String ref) {
        List<Produit> produits = new ArrayList();
         Enseigne ens=new Enseigne();
        ServiceEnseigne e=new ServiceEnseigne();
        String req = "select * from produit WHERE categorie= '"+ref+"';";
        PreparedStatement ps;
        
          
        
        try {
            ps = mycon.prepareStatement(req);
             
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Produit produit;
                  ens= e.chercherens(res.getInt("idEnseigne"));
                     System.out.println("");     
                produit = new Produit(res.getInt("reference"), res.getString("nom"),ens,res.getString("categorie") ,res.getDouble("prix"), res.getString("description"),res.getFloat("promo"), res.getString("image"));
                produits.add(produit);
                produits.toString();
                 System.out.println(produits);   
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;   
    }
           
           
      public  Produit getProduit(int ref) {

        try {
            ResultSet res;
             Enseigne ens=new Enseigne();
        ServiceEnseigne e=new ServiceEnseigne();
            String req = "SELECT * FROM produit WHERE reference=" + ref;
            Produit p= null;
            PreparedStatement stt = mycon.prepareStatement(req);

  
            res = stt.executeQuery(req);
              ens= e.chercherens(res.getInt("idEnseigne"));
            while (res.next()) {
                p = new Produit(res.getInt("reference"), res.getString("nom"), ens,res.getString("categorie") ,res.getDouble("prix"), res.getString("description"),res.getFloat("promo"), res.getString("image"));
              
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("get adherent ");
        }
        return null;
    }
           
           
           
   
      public int CalculP() throws SQLException {
         String sql = "SELECT * FROM produit";
        
      
     Statement statement = mycon.createStatement(); 
     statement.setFetchSize(0);
     
     
ResultSet resultat = statement.executeQuery(sql); 

int n=0;
while (resultat.next()) {
   n=n+1;
  
}
 //System.out.println(n);
  
 return n;
 
//statement.close();


//ResultSetMetaData metadata = resultat.getMetaData(); 
//int nombreColonnes = metadata.getColumnCount(); 
//System.out.println("Ce ResultSet contient "+nombreColonnes+" colonnes.");





    }     

      
           
           public void Afficher() throws SQLException {}
//    public void Afficher() throws SQLException {
//          String req1 = "select * from produit";
//       
//       Statement ste = mycon.createStatement();
//      ResultSet res= ste.executeQuery(req1);
//        while (res.next()) {
//            System.out.println("produit est "+
//                    res.getInt("id")
//             +" "+ res.getString("nom")
//            +" "+ res.getFloat("prix"));
//            
//        }
//    }
           
           
           
           
            public Produit chercheproduit(int id) throws SQLException {
                 
               
                 Produit c=new Produit();

       String requete = "SELECT * FROM `produit` WHERE `id` = ?;";
        
        Enseigne e =new Enseigne();
       ServiceEnseigne se=new ServiceEnseigne();
 PreparedStatement ps;
    try {
        ps = mycon.prepareStatement(requete);
         ps.setInt(1,id);
            ResultSet res = ps.executeQuery();

          if(res.next());
          { 
          e=se.chercherens(res.getInt("idEnseigne"));
               c.setId(id);
                c.setNom(res.getString("nom"));
                
                c.setPrix(res.getDouble("prix"));
                c.setDescription(res.getString("description"));
                c.setPromo(res.getFloat("promo"));
                c.setReference(res.getInt("reference"));
                c.setImage(res.getString("image"));
               c.setCategorie(res.getString("categorie"));
               
                    c.setEnseigne(e); }
    } catch (SQLException ex) {
        Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
         
          return c;
          
          

        
    }

    }
