package tn.pidev.tm.entite;




public class Produit {
    
    private int id;
    private String nom;
    private String categorie;
    private Double prix;
    private String description;
    private float promo;
    private String image;
    private int reference;
    private Enseigne enseigne;

    public Produit() {
    }

    public Produit(int id, String nom, Double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
    
    
    
  
        public Produit(Enseigne enseigne) {
        this.enseigne=enseigne;
    }

    public Produit(int id, String nom,String categorie, Double prix, String description, float promo, int reference, String image, Enseigne enseigne) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.promo = promo;
        this.reference = reference;
        this.image = image;
        this.enseigne=enseigne;
    }
     public Produit( int reference,String nom ,Enseigne enseigne,String categorie, Double prix, String description, float promo,  String image) {
       
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.promo = promo;
        this.reference = reference;
        this.image = image;
        this.enseigne=enseigne;
    }

    public Produit(String nom, String image) {
        this.nom = nom;
        this.image = image;
    }

    public Produit(String nom, Double prix, String description, float promo, String image) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.promo = promo;
        this.image = image;
       
    }
    
     
     
     
    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Enseigne getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(Enseigne enseigne) {
        this.enseigne = enseigne;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
        public float getPromo() {
        return promo;
    }

    public void setPromo(float promo) {
       this.promo = promo;
    }
    
   public boolean equals (Object o)
     {  if(o instanceof Produit)
        
    {Produit p= (Produit)o; // forcage lel objet o nrodouh produit
    if(this.id==p.id ) 
    return true;
    }
    return false ;
     
     }
     public String toString() {
        return "produit est "+ nom +  " Sa categorie est "+ categorie
                +" Son prix est : " + prix +  " Sa description est "+ description +   " Sa reference est "+ reference +" Sa promotion est "+ promo+" idEnseigne est"+enseigne;
    }
     
     
   

    
}
