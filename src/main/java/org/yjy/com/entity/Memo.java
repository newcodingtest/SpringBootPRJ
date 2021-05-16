package org.yjy.com.entity;


import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "tbl_memo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//@Builder 설정을 할땐 @AllArgsConstructor,@NoArgsConstructor 같이 써줘야한다.
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

}
