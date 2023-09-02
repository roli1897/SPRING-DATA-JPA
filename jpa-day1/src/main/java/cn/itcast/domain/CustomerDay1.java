package cn.itcast.domain;

import javax.persistence.*;

/**
 * configurer la relation de mappage entre les entités et les tables dans JPA,
 * @Entity : Cette annotation est utilisée pour déclarer une classe comme une entité JPA. Elle doit être appliquée à la classe d'entité.
 * @Table : Cette annotation est utilisée pour configurer la relation de mappage entre la classe d'entité et la table de base de données correspondante.
 *
 * name : Cette propriété permet de spécifier le nom de la table dans la base de données.
 *
 */
@Entity
@Table(name = "cst_customer")
public class CustomerDay1 {

    /**
     *  configurer la clé primaire (primary key) et la stratégie de génération de clé primaire dans JPA
     * @Id : Cette annotation est utilisée pour déclarer un attribut comme clé primaire dans une classe d'entité.
     * @GeneratedValue : Cette annotation est utilisée pour configurer la stratégie de génération de la clé primaire.
     *      strategy
     *          GenerationType.IDENTITY ：mysql
     *
     *          GenerationType.SEQUENCE : oracle
     *
     *          GenerationType.TABLE :
     *          GenerationType.AUTO ：
     * @Column : Cette annotation est utilisée pour configurer la relation de mappage entre les attributs de la classe d'entité et les colonnes de la table, y compris le nom de la colonne
     * name : Cette propriété permet de spécifier le nom de la colonne dans la table de base de données correspondante.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name="cust_source")
    private String custSource;

    @Column(name="cust_level")
    private String custLevel;

    @Column(name="cust_industry")
    private String custIndustry;

    @Column(name="cust_phone")
    private String custPhone;

    @Column(name="cust_address")
    private String custAddress;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}
