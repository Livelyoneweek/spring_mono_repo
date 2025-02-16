package kr.co.mhnt.msds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Builder
@Entity
@Table(name = "c00_chemical_substances", schema = "msds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChemicalSubstance {

    @Id
    @Column(name = "chem_id", nullable = false)
    @Comment("화학 물질 ID")
    private Integer chemId;

    @Column(name = "cas_no", length = 20)
    @Comment("CAS 번호")
    private String casNo;

    @Column(name = "chem_name_kor", length = 255)
    @Comment("화학 물질명 (한글)")
    private String chemNameKor;

    @Column(name = "chem_name_kor_jaso", length = 512)
    @Comment("화학물질명(한글) 자소 분리")
    private String chemNameKorJaso;

    @Column(name = "en_no", length = 20)
    @Comment("EN 번호")
    private String enNo;

    @Column(name = "ke_no", length = 20)
    @Comment("KE 번호")
    private String keNo;

    @Column(name = "last_date")
    @Comment("최종 업데이트 날짜")
    private LocalDate lastDate;

    @Column(name = "un_no", length = 20)
    @Comment("UN 번호")
    private String unNo;
}
