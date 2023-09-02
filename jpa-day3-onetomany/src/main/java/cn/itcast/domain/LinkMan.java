package cn.itcast.domain;

import javax.persistence.*;

@Entity
@Table(name = "cst_linkman")
public class LinkMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long lkmId; //Identifiant du contact (clé primaire)
    @Column(name = "lkm_name")
    private String lkmName;//Nom du contact
    @Column(name = "lkm_gender")
    private String lkmGender;//Genre du contact
    @Column(name = "lkm_phone")
    private String lkmPhone;//Numéro de téléphone fix du contact
    @Column(name = "lkm_mobile")
    private String lkmMobile;//Numéro de téléphone portable du contact
    @Column(name = "lkm_email")
    private String lkmEmail;//Adresse e-mail du contact
    @Column(name = "lkm_position")
    private String lkmPosition;//Poste du contact
    @Column(name = "lkm_memo")
    private String lkmMemo;//Remarques sur le contact

    /**
     * Pour configurer la relation many-to-one entre un contact et un client en utilisant des annotations,
     *
     *          @ManyToOne : configurer la relation many-to-one avec l'entité "un"
     *              targetEntity：indiquer la classe d'entité cible.
     *          @JoinColumn :spécifier la colonne de clé étrangère dans la table des contacts qui référence l'ID du client.
     *
     *
     */
    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                '}';
    }
}
