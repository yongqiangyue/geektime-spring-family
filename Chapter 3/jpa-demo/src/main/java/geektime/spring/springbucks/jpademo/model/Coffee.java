package geektime.spring.springbucks.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.joda.money.Money;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity // 定义实体类，实体类与一张表一一对应
@Table(name = "T_MENU") // 定义实体类对应的表的名称
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor // @Builder, @Data, @NoArgsConstructor, @AllArgsConstructor都是与lombok相关的
public class Coffee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键
    private String name; // 菜单名称
    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price; // 金额
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime; // 创建时间
    @UpdateTimestamp
    private Date updateTime; // 更新时间
//    @Columns(columns = { @Column(name = "MY_CURRENCY"), @Column(name = "MY_AMOUNT") })
//    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
//    private Money price;
}
