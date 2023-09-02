package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.Relation entre l'entité et la table
 *      @Eitity
 *      @Table
 * 2.Relation entre les propriétés de classe et les colonnes de table
 *      @Id
 *      @GeneratedValue
 *      @Column
 */
@Entity
@Table(name="cst_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cust_id")
    private Long custId;
    @Column(name="cust_address")
    private String custAddress;
    @Column(name="cust_industry")
    private String custIndustry;
    @Column(name="cust_level")
    private String custLevel;
    @Column(name="cust_name")
    private String custName;
    @Column(name="cust_phone")
    private String custPhone;
    @Column(name="cust_source")
    private String custSource;

    //configurations pour la relation entre un client et ses contacts (relation one-to-many)
    /**
     *  la relation one-to-many entre un client et ses contacts en utilisant des annotations
     *      1.Déclaration de la relation :
     *          @OneToMany : configurations pour la relation one to many
     *              targetEntity ：spécifie la classe de l'entité cible
     *      2.Configuration de la clé étrangère (table intermédiaire)
     *              @JoinColumn :  configurer la clé étrangère
     *                  name：le nom de la colonne de la clé étrangère dans la table des contacts (table intermédiaire).
     *                  referencedColumnName：le nom de la colonne de la clé primaire du client référencée dans la table des contacts
     *
     *  * En ajoutant la configuration de clé étrangère dans l'entité Client (le côté "one" de la relation),
     *  le client peut également modifier la valeur de la clé étrangère pour maintenir la relation avec les contacts.
     *
     */

//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    /**
     * pour abandonner la gestion de la clé étrangère dans l'entité Client
     *      mappedBy：Cette annotation est utilisée pour indiquer que la relation est gérée par l'entité inverse
     * cascade : Cette annotation configure le comportement de cascade pour les opérations CRUD entre l'entité Client et ses contacts.
     *      CascadeType.all         : TOUS
     *                  MERGE       ：MISE A JOUR
     *                  PERSIST     ：sauvegarde
     *                  REMOVE      ：DELETE
     *
     * fetch : cette annotation configure le mode de chargement des objets associés.
     *          EAGER   ：charger tout de suite
     *          LAZY    ：pour charger les contacts de manière paresseuse

      */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<LinkMan> linkMans = new HashSet<>();

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custAddress='" + custAddress + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custName='" + custName + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custSource='" + custSource + '\'' +
                '}';
    }
}
